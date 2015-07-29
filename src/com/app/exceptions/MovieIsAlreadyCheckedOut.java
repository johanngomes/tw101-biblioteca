package com.app.exceptions;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieIsAlreadyCheckedOut extends Exception {
    public MovieIsAlreadyCheckedOut(String message)
    {
        super(message);
    }
}
