package com.test.helpers;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.exceptions.InvalidLogin;
import com.app.helpers.UserHelper;
import com.app.seeds.UserSeed;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jgomes on 8/3/15.
 */
public class UserHelperTest {

    @Before
    public void feedUserHelperWithUsers() throws MalformedEnteredInformation{
        UserSeed.feedUserHelper();
    }

    @Test
    public void loginUserWithSuccess() throws InvalidLogin, MalformedEnteredInformation {
        UserHelper.loginUser("JOHANN GOMES", "1234");
    }

    @Test(expected = InvalidLogin.class )
    public void loginUserWithFailureWrongUser() throws InvalidLogin, MalformedEnteredInformation {
        UserHelper.loginUser("JOHAN22N GOMES", "1234");
    }

    @Test(expected = InvalidLogin.class )
    public void loginUserWithFailureWrongPassword() throws InvalidLogin, MalformedEnteredInformation {
        UserHelper.loginUser("JOHANN GOMES", "ugygdsd");
    }

    @Test(expected = InvalidLogin.class )
    public void loginUserWithFailureWrongUserAndPassword() throws InvalidLogin, MalformedEnteredInformation {
        UserHelper.loginUser("JOdsdHANdsdsS", "ugydgdsd");
    }
}
