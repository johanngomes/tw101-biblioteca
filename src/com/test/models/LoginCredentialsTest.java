package com.test.models;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.models.LoginCredentials;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jgomes on 7/29/15.
 */
public class LoginCredentialsTest {

    ArrayList<String> invalidLibraryNumbers = new ArrayList(
            Arrays.asList("72187282", "", "1e2-9999", "abcjgsddsg", "abc-defg", "'"));

    @Test
    public void createValidLoginCredentials() throws MalformedEnteredInformation {
        LoginCredentials loginCredentials = new LoginCredentials("989-9921", "1234");
        Assert.assertEquals(loginCredentials.getLibraryNumber(), "989-9921");
        Assert.assertEquals(loginCredentials.getPassword(), "1234");
    }

    @Test(expected = MalformedEnteredInformation.class)
    public void tryToCreateInvalidLoginCredentials() throws MalformedEnteredInformation {
        for ( String libraryNumber : invalidLibraryNumbers ) {
            new LoginCredentials(libraryNumber, "1234");
        }
    }

}
