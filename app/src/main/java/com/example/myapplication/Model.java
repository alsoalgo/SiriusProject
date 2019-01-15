package com.example.myapplication;

/**
 * Created by Parsania Hardik on 28-Jun-17.
 */
public class Model {

    private String name;
    private int image_drawable;
    private String description;

    public String getName() {
        return name;
    }
    public String getDescription() { return description; }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) { this.description = description;}

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }
}
