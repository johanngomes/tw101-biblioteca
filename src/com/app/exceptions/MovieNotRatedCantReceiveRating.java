package com.app.exceptions;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieNotRatedCantReceiveRating extends Exception {
    public MovieNotRatedCantReceiveRating(String message)
    {
        super(message);
    }
}
