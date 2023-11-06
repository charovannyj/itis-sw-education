package ru.kpfu.itis.nikolaev.net.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {
    private int id;
    private String login_user;
    private String grade;
    private String subject;
    private String area;
    private String teacher;
    private String content;

    public Rating(int id, String login_user, String grade, String subject, String area, String teacher, String content) {
        this.id = id;
        this.login_user = login_user;
        this.grade = grade;
        this.subject = subject;
        this.area = area;
        this.teacher = teacher;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
