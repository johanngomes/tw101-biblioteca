package com.app.exceptions;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieIsAlreadyCheckedIn extends Exception{
    public MovieIsAlreadyCheckedIn(String message)
    {
        super(message);
    }
}
