package ru.kpfu.itis.nikolaev.net.model;

public class Position {
    private int id;
    private String position;
    private String possibilities;

    public Position(int id, String position, String possibilities) {
        this.id = id;
        this.position = position;
        this.possibilities = possibilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPossibilities() {
        return possibilities;
    }

    public void setPossibilities(String possibilities) {
        this.possibilities = possibilities;
    }
}
