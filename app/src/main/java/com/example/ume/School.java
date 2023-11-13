package com.example.ume;

import android.util.Log;

public class School {
    private int id;
    private String name;
    private String website;

    public int getId() {
        Log.d("School.java", "getId()");
        return id;
    }

    public void setId(int id) {
        Log.d("School.java", "setId(int id)");
        this.id = id;
    }

    public String getName() {
        Log.d("School.java", "getName()");
        return name;
    }

    public void setName(String name) {
        Log.d("School.java", "setName(String name)");
        this.name = name;
    }

    public String getWebsite() {
        Log.d("School.java", "getWebsite()");
        return website;
    }

    public void setWebsite(String website) {
        Log.d("School.java", "setWebsite(String website)");
        this.website = website;
    }
}

