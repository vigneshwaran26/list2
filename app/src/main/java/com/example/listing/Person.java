package com.example.listing;

public class Person {
    private String name;
    private String birthday;
    private String gender;

    public Person(String name, String birthday,  String gender) {
        this.birthday = birthday;
        this.name = name;
        this.gender= gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}