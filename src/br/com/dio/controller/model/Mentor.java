package br.com.dio.controller.model;

public class Mentor {
    private int id = 0;
    private String name;
    private String email;

    public Mentor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int increment) {
        this.id += increment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
