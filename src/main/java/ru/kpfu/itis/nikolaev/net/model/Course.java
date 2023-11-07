package ru.kpfu.itis.nikolaev.net.model;

import lombok.Builder;
import lombok.Data;

import java.awt.*;

@Data
@Builder
public class Course {
    private int id;
    private String name;
    private int price;
    private int duration;
    private String subject;
    private String area;

    public Course(int id, String name, int price, int duration, String subject, String area) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.subject = subject;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
}
