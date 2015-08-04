package com.app.exceptions;

/**
 * Created by jgomes on 7/23/15.
 */
public class ItemIsAlreadyCheckedOut extends Exception{
    public ItemIsAlreadyCheckedOut(String message)
    {
        super(message);
    }
}
