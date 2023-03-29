package com.example.java_fx_table;

public class Item {
    private String name;
    private String surname;
    private String date;
    private String post;

    public Item(String name, String surname, String date, String post) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getPost() {
        return post;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
