package ru.kpfu.itis.nikolaev.net.server;

import com.cloudinary.Cloudinary;
import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.nikolaev.net.model.User;
import ru.kpfu.itis.nikolaev.net.util.CloudinaryUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadingServlet extends HttpServlet {
    Dao userDaoImpl;

    @Override
    public void init() throws ServletException {
        ServletContext sc = getServletContext();
        userDaoImpl = (Dao) sc.getAttribute("userDaoImpl");
    }
    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File file = new File(FILE_PATH_PREFIX + File.separator
                + filename.hashCode() % DIRECTORIES_COUNT + File.separator + filename);

        file.getParentFile().mkdirs();
        file.createNewFile();

        try (InputStream inputStream = part.getInputStream()) {
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(buffer);
            }
        }

        Map map = cloudinary.uploader().upload(file, null);

        HttpSession session = req.getSession();
        Integer userId = Integer.parseInt((String) session.getAttribute("id"));

        User user = (User) userDaoImpl.get(userId);

        String url = (String) map.get("url");

        user.setPhoto(url);
        userDaoImpl.save(user);
        resp.sendRedirect("/profile");
    }
}