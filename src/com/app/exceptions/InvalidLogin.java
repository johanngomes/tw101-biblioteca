package com.app.exceptions;

/**
 * Created by jgomes on 8/3/15.
 */
public class InvalidLogin extends Exception {
    public InvalidLogin(String message) {
        super(message);
    }
}
