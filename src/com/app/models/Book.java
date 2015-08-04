package com.app.models;

/**
 * Created by jgomes on 7/22/15.
 */
public class Book implements Item {

    private String title;
    private Integer year;
    private String author;
    private Boolean checkedOut;
    private User checkedOutBy;

    public Book (String title, String author, Integer year,
                 Boolean checkedOut, User checkedOutBy) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setYear(year);
        this.setCheckedOut(checkedOut);
        this.setCheckedOutBy(checkedOutBy);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author.toUpperCase();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.toUpperCase();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Boolean getCheckedOut() { return checkedOut; }

    public void setCheckedOutBy(User user) { this.checkedOutBy = user; }

    public User getCheckedOutBy() { return checkedOutBy; }
}
