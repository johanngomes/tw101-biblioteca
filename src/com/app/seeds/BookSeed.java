package com.app.seeds;

import com.app.helpers.BookHelper;
import com.app.models.Book;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookSeed {

    public static void feedBookHelper() {
        BookHelper.addBook(new Book("HARRY POTTER AND THE CHAMBER OF SECRETS", "J.K. ROWLING", 2001));
        BookHelper.addBook(new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1921));
        BookHelper.addBook(new Book("PAPER CITIES", "JOHN GREEN", 2007));
        BookHelper.addBook(new Book("THE DA VINCI CODE", "DAN BROWN", 1999));
    }

}
