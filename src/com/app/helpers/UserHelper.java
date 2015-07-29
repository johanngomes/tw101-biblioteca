package com.app.helpers;

import com.app.models.User;

import java.util.ArrayList;

/**
 * Created by jgomes on 7/28/15.
 */
public class UserHelper {
    private static ArrayList<User> users = new ArrayList<User>();

    public static void addUser(User user) {
        users.add(user);
    }

}
