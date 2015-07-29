package com.test.models;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.models.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jgomes on 7/29/15.
 */
public class UserTest {

    ArrayList<String> invalidPhoneNumbers = new ArrayList(
            Arrays.asList("dddsdsds", "", "122-9999", "116h2f652", "21gh21g-bdd6", "jjjj-yyy", ""));

    @Test
    public void createUserWithValidPhoneNumber() throws MalformedEnteredInformation {
        User user = new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234");
        Assert.assertEquals(user.getName(), "JOHANN GOMES");
        Assert.assertEquals(user.getEmail(), "JGBL@CIN.UFPE.BR");
        Assert.assertEquals(user.getAddress(), "TENENTE JOAO CICERO STREET - BOA VIAGEM");
        Assert.assertEquals(user.getPhoneNumber(), "996702734");
        Assert.assertEquals(user.getLibraryNumber(), "123-4567");
        Assert.assertEquals(user.getPassword(), "1234");
    }

    @Test(expected = MalformedEnteredInformation.class)
    public void tryToCreateUserWithInvalidPhoneNumber() throws MalformedEnteredInformation{
        for(String invalidPhoneNumber : invalidPhoneNumbers) {
            new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR", "TENENTE JOAO CICERO STREET - BOA VIAGEM",
                    invalidPhoneNumber, "123-4567", "1234");
        }
    }

 }
