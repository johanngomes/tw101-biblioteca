package com.app.models;


import com.app.exceptions.MalformedEnteredInformation;

/**
 * Created by jgomes on 7/28/15.
 */
public class LoginCredentials {

    private String libraryNumber;
    private String password;

    private String libraryNumberRule = new String("[1-9][1-9][1-9]-[1-9][1-9][1-9][1-9]");

    public LoginCredentials(String libraryNumber, String password) throws MalformedEnteredInformation {
        this.setLibraryNumber(libraryNumber);
        this.setPassword(password);
    }

    public Boolean doLogin(String libraryNumber, String password) {
        if (libraryNumber.equals(getLibraryNumber()) && password.equals(getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) throws MalformedEnteredInformation {
        if (libraryNumber.matches(libraryNumberRule)) {
            this.libraryNumber = libraryNumber;
        } else {
            throw new MalformedEnteredInformation("Your entered library number doesn't fit the rule " +
                    "xxx-xxxx (only numbers allowed).");
        }
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
