package com.example.srinivas.listviewwithbaseadapter.Model;

/**
 * Created by Srinivas on 6/10/2017.
 */

public class SocialMedia {
    private String name;
    private int imageId;

    public SocialMedia(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
