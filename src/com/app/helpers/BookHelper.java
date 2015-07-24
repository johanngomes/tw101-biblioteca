package com.app.helpers;

import com.app.custom.BookIsAlreadyCheckedIn;
import com.app.custom.BookIsAlreadyCheckedOut;
import com.app.custom.BookNotFound;
import com.app.models.Book;

import java.util.ArrayList;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookHelper {
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static void addBook(Book book){
        books.add(book);
    }

    public static ArrayList<Book> getBooks() {
        return books;
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
                    return;
                }
            }
        }
        throw new BookNotFound(String.format("%s not found in the library!", title.toUpperCase()));
    }

    public static void checkOutBook(String title) throws BookIsAlreadyCheckedOut, BookNotFound{
        System.out.println(title);
        for (Book book : books) {
            if ( book.getTitle().equals(title.toUpperCase()) ) {
                if ( book.isCheckedOut() == true ) {
                    throw new BookIsAlreadyCheckedOut(String.format("%s is already checked out! You can' check out " +
                            "this book.", title.toUpperCase()));
                }
                else {
                    book.setCheckedOut(true);
                    return;
                }
            }
        }
        throw new BookNotFound(String.format("%s not found in the library!", title.toUpperCase()));
    }

    public static void eraseBookList() {
        books.clear();
    }

}
