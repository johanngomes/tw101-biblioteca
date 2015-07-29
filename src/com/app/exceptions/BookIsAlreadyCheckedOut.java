package com.app.exceptions;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookIsAlreadyCheckedOut extends Exception{
    public BookIsAlreadyCheckedOut(String message)
    {
        super(message);
    }
}
