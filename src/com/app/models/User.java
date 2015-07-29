package com.app.models;

import com.app.exceptions.MalformedEnteredInformation;

/**
 * Created by jgomes on 7/28/15.
 */
public class User extends LoginCredentials{
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    private String phoneNumberRule = new String(".*[1-9].*");

    public User(String name, String email, String address, String phoneNumber, String libraryNumber, String password)
            throws MalformedEnteredInformation {
        super(libraryNumber, password);

        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.toUpperCase();
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) throws MalformedEnteredInformation {
        if (phoneNumber.matches(this.phoneNumberRule)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new MalformedEnteredInformation("The phone number must contain only numbers, without dashes, " +
                    "parenthesis, dots or any dividing symbols.");
        }

    }
}
