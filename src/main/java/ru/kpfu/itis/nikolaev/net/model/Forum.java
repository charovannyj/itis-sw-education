package ru.kpfu.itis.nikolaev.net.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Forum {
    private int id;
    private String login_user;
    private String time;
    private String content;

    public Forum(int id, String login_user, String time, String content) {
        this.id = id;
        this.login_user = login_user;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return login_user + " в " + time + " отправил сообщение: " + content;
    }
}
