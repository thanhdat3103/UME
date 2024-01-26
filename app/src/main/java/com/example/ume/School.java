package com.example.ume;
public class School {
    private String key;
    private String name;
    private String website;

    public School() {
        // Hàm tạo rỗng cần thiết cho Firebase Realtime Database
    }

    public School(String name, String website) {
        this.name = name;
        this.website = website;
    }

    // Getters và Setters cho key, name và website
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}