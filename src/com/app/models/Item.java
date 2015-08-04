package com.app.models;

/**
 * Created by jgomes on 7/28/15.
 */

interface Item {
    String getTitle();
    void setTitle(String title);

    Integer getYear();
    void setYear(Integer year);

    boolean isCheckedOut();

    void setCheckedOut(Boolean checkedOut);
    Boolean getCheckedOut();

    void setCheckedOutBy(User user);
    User getCheckedOutBy();
}
