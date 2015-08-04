package com.app.helpers;

import com.app.exceptions.*;
import com.app.models.Book;
import com.app.models.Movie;
import com.app.models.User;

/**
 * Created by jgomes on 8/3/15.
 */
public class ItemHelper {

    public static void checkInItem(String title) throws ItemIsAlreadyCheckedIn, ItemNotFound {

        for (Book book : BookHelper.getBooks()) {
            if ( book.getTitle().equals(title.toUpperCase()) ) {
                if ( book.isCheckedOut() == false ) {
                    throw new ItemIsAlreadyCheckedIn(String.format("%s is already checked in! You can' check in " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy(null);
                    return;
                }
            }
        }

        for (Movie movie : MovieHelper.getMovies()) {
            if ( movie.getTitle().equals(title.toUpperCase()) ) {
                if ( movie.isCheckedOut() == false ) {
                    throw new ItemIsAlreadyCheckedIn(String.format("%s is already checked in! You can' check in " +
                            "this movie.", title.toUpperCase()));
                }
                else {
                    movie.setCheckedOut(false);
                    movie.setCheckedOutBy(null);
                    return;
                }
            }
        }

        throw new ItemNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }

    public static void checkOutItem(String title, User user) throws ItemIsAlreadyCheckedOut, ItemNotFound {

        for (Book book : BookHelper.getBooks()) {
            if ( book.getTitle().equals(title.toUpperCase()) ) {
                if ( book.isCheckedOut() == true ) {
                    throw new ItemIsAlreadyCheckedOut(String.format("%s is already checked out! You can' check out " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    book.setCheckedOut(true);
                    book.setCheckedOutBy(user);
                    return;
                }
            }
        }

        for (Movie movie : MovieHelper.getMovies()) {
            if ( movie.getTitle().equals(title.toUpperCase()) ) {
                if ( movie.isCheckedOut() == true ) {
                    throw new ItemIsAlreadyCheckedOut(String.format("%s is already checked out! You can' check out " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    movie.setCheckedOut(true);
                    movie.setCheckedOutBy(user);
                    return;
                }
            }
        }

        throw new ItemNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }
}
