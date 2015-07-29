package com.app.models;

/**
 * Created by jgomes on 7/28/15.
 */
public class Item {
    private String title;
    private Integer year;
    private Boolean checkedOut;
    private User checkedOutBy = null;

    public Item(String title, Integer year, Boolean checkedOut) {
        this.setTitle(title);
        this.setYear(year);
        this.setCheckedOut(checkedOut);
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
