package com.test;

import com.test.helpers.BookHelperTest;
import com.test.helpers.MenuHelperTest;
import com.test.helpers.MovieHelperTest;
import com.test.models.*;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

/**
 * Created by jgomes on 7/28/15.
 */
public class TestsRunner {
    private JUnitCore junit = new JUnitCore();

    public static void main(String[] args) {
        TestsRunner testsRunner = new TestsRunner();
        testsRunner.junit.addListener(new TextListener(System.out));

        testsRunner.junit.run(BookTest.class);
        testsRunner.junit.run(MovieTest.class);
        testsRunner.junit.run(ItemTest.class);
        testsRunner.junit.run(LoginCredentialsTest.class);
        testsRunner.junit.run(UserTest.class);

        testsRunner.junit.run(BookHelperTest.class);
        testsRunner.junit.run(MovieHelperTest.class);
        testsRunner.junit.run(MenuHelperTest.class);
    }
}

