package com.example.myapplication;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ToPost {
    @SerializedName("name")
    @Expose
    private String title;
    @SerializedName("small_description")
    @Expose
    private String shortdesc;
    @SerializedName("description")
    @Expose
    private String longdesc;
    @SerializedName("image")
    @Expose
    private String image;

    public ToPost(Idea idea) {
        this.title = idea.title;
        this.shortdesc = idea.shortdesc;
        this.longdesc = idea.longdesc;
        this.image = idea.image;
    }
}

public class Idea {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("name")
    @Expose
    String title;
    @SerializedName("small_description")
    @Expose
    String shortdesc;
    @SerializedName("description")
    @Expose
    String longdesc;
    @SerializedName("author_id")
    @Expose
    int author;
    @SerializedName("image")
    @Expose
    String image;

    public Idea(int id, String title, String shortdesc, String longdesc, int author, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.longdesc = longdesc;
        this.author = author;
        this.image = image;
    }

    public Idea(String title, String shortdesc, String longdesc, String image) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.longdesc = longdesc;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void print() {
        Log.i("Title: ", this.getTitle());
        Log.i("Short description: ", this.getShortdesc());
        Log.i("Long description: ", this.getLongdesc());
        Log.i("ID: ", String.valueOf(this.getId()));
        Log.i("Author: ", String.valueOf(this.getAuthor()));
        Log.i("Image: ", this.getImage());
    }
}
