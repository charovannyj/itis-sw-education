package ru.kpfu.itis.nikolaev.net.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {
    private int id;
    private int id_user;
    private String course;
    private String teacher;
    private String content;
    private int grade;

    public Rating(int id, int id_user, String course, String teacher, String content, int grade) {
        this.id = id;
        this.id_user = id_user;
        this.course = course;
        this.teacher = teacher;
        this.content = content;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
