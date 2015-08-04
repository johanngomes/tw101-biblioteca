package com.app.helpers;

import com.app.exceptions.ItemIsAlreadyCheckedIn;
import com.app.exceptions.ItemIsAlreadyCheckedOut;
import com.app.exceptions.ItemNotFound;
import com.app.models.Book;
import com.app.models.User;

import java.util.ArrayList;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookHelper {
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static void addItem(Book book) {
        books.add(book);
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void eraseBookList() {
        books.clear();
    }

    public static void checkInBook(String title) throws ItemIsAlreadyCheckedIn, ItemNotFound {

        for (Book book : books) {
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

        throw new ItemNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }

    public static void checkOutBook(String title, User user) throws ItemIsAlreadyCheckedOut, ItemNotFound {

        for (Book book : books) {
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

        throw new ItemNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }
}
