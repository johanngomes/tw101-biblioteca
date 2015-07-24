package com.app.custom;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookIsAlreadyCheckedIn extends Exception {
    public BookIsAlreadyCheckedIn(String message)
    {
        super(message);
    }
}