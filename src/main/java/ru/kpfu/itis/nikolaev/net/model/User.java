package ru.kpfu.itis.nikolaev.net.model;

import java.util.Date;

public class User {

    private int id;

    private String name;

    private String login;
    private Date date;
    private String password;
    private String gender;
    private String position;

    public User(int id, String name, String login, Date date, String password, String gender, String position) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.date = date;
        this.password = password;
        this.gender = gender;
        this.position = position;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}