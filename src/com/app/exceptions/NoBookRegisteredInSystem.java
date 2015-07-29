package com.app.exceptions;

/**
 * Created by jgomes on 7/24/15.
 */
public class NoBookRegisteredInSystem extends Exception{
    public NoBookRegisteredInSystem(String message)
    {
        super(message);
    }
}
