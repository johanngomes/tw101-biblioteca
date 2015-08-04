package com.app.exceptions;

/**
 * Created by jgomes on 7/23/15.
 */
public class ItemIsAlreadyCheckedIn extends Exception {
    public ItemIsAlreadyCheckedIn(String message)
    {
        super(message);
    }
}