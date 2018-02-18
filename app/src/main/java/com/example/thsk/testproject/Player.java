package com.example.thsk.testproject;

/**
 * Created by thsk on 18/02/2018.
 */

public class Player {

    private String name;
    private String club;
    private String age;
    private String type;
    private boolean checked;

    public Player(String name, String club, String age) {
        this.name = name;
        this.club = club;
        this.age = age;
        this.type = "PLAYER";
        this.checked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
