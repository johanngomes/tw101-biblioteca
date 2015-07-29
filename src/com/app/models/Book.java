package com.app.models;

/**
 * Created by jgomes on 7/22/15.
 */
public class Book extends Item {
    private String author;

    public Book (String title, String author, Integer year, Boolean checkedOut) {
        super(title, year, checkedOut);

        this.setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author.toUpperCase();
    }

}
