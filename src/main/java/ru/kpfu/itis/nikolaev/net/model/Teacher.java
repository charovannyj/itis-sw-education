package ru.kpfu.itis.nikolaev.net.model;

public class Teacher {
    private int id;
    private String subject;
    private String area;
    private String content;
    private String photo;
    private String name;

    public Teacher(int id, String subject, String area, String content, String photo, String name) {
        this.id = id;
        this.subject = subject;
        this.area = area;
        this.content = content;
        this.photo = photo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}