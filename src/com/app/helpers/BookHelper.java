package com.app.helpers;

import com.app.exceptions.BookIsAlreadyCheckedIn;
import com.app.exceptions.BookIsAlreadyCheckedOut;
import com.app.exceptions.BookNotFound;
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

    public static void checkInBook(String title) throws BookIsAlreadyCheckedIn, BookNotFound {

        for (Book book : books) {
            if ( book.getTitle().equals(title.toUpperCase()) ) {
                if ( book.isCheckedOut() == false ) {
                    throw new BookIsAlreadyCheckedIn(String.format("%s is already checked in! You can' check in " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    book.setCheckedOut(false);
                    book.setCheckedOutBy(null);
                    return;
                }
            }
        }

        throw new BookNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }

    public static void checkOutBook(String title, User user) throws BookIsAlreadyCheckedOut, BookNotFound{

        for (Book book : books) {
            if ( book.getTitle().equals(title.toUpperCase()) ) {
                if ( book.isCheckedOut() == true ) {
                    throw new BookIsAlreadyCheckedOut(String.format("%s is already checked out! You can' check out " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    book.setCheckedOut(true);
                    book.setCheckedOutBy(user);
                    return;
                }
            }
        }

        throw new BookNotFound(String.format("%s not found in the library!", title.toUpperCase()));

    }
}
