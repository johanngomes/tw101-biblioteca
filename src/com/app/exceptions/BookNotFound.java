package com.app.exceptions;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookNotFound extends Exception {
    public BookNotFound(String message)
    {
        super(message);
    }
}