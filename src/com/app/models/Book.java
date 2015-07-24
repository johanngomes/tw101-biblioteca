package com.app.models;

/**
 * Created by jgomes on 7/22/15.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut = false;

    public Book (String title, String author, int year, boolean... checkedOut) {
        this.title = title.toUpperCase();
        this.author = author.toUpperCase();
        this.year = year;

        if ( checkedOut.length > 0 ) {
            this.checkedOut = checkedOut[0];
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
