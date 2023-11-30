package com.example.ume;

import android.util.Log;

//public class School {
//    private int id;
//    private String name;
//    private String website;
//
//    public int getId() {
//        Log.d("School.java", "getId()");
//        return id;
//    }
//
//    public void setId(int id) {
//        Log.d("School.java", "setId(int id)");
//        this.id = id;
//    }
//
//    public String getName() {
//        Log.d("School.java", "getName()");
//        return name;
//    }
//
//    public void setName(String name) {
//        Log.d("School.java", "setName(String name)");
//        this.name = name;
//    }
//
//    public String getWebsite() {
//        Log.d("School.java", "getWebsite()");
//        return website;
//    }
//
//    public void setWebsite(String website) {
//        Log.d("School.java", "setWebsite(String website)");
//        this.website = website;
//    }
//}

// School.java
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