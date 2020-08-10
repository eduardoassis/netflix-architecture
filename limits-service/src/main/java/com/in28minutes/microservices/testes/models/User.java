package com.in28minutes.microservices.testes.models;

public class User {
    private int age;
    private String name;
    private boolean isAdmin;

    public User(int age, String name, boolean isAdmin) {
        this.age = age;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
