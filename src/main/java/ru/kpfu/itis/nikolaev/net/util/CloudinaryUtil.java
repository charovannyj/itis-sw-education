package ru.kpfu.itis.nikolaev.net.util;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(Map.of(
                    "cloud_name", "doaetvccv",
                    "api_key", "955375793197148",
                    "api_secret", "W2BQCAEMC_10bNiapPXqVSFbf7w"));
        }
        return cloudinary;
    }
}