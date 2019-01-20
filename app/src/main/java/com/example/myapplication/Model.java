package com.example.myapplication;

/**
 * Created by Parsania Hardik on 28-Jun-17.
 */
public class Model {
    private int id;
    private String title;
    private String shortdesc;
    private String longdesc;
    private int author;
    private String image;

    public Model(int id, String title, String shortdesc, String longdesc, int author, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.longdesc = longdesc;
        this.author = author;
        this.image = image;
    }

    public Model(Idea idea) {
        this.id = idea.getId();
        this.title = idea.getTitle();
        this.shortdesc = idea.getShortdesc();
        this.longdesc = idea.getLongdesc();
        this.author = idea.getAuthor();
        this.image = idea.getImage();
    }

    public Model(String title, String shortdesc, String longdesc, String image) {
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

}
