package com.app.helpers;

import com.app.exceptions.InvalidLogin;
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

    public static ArrayList<User> getUsers() { return users; }

    public static User loginUser(String name, String password) throws
            InvalidLogin {
        for(User user : UserHelper.getUsers()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new InvalidLogin("User or password invalid.");
    }

}
