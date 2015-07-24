package com.test.helpers;

import com.app.custom.BookIsAlreadyCheckedIn;
import com.app.custom.BookIsAlreadyCheckedOut;
import com.app.custom.BookNotFound;
import com.app.helpers.BookHelper;
import com.app.models.Book;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookHelperTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public String sampleAuthor = "J.K. ROWLING";
    public int sampleYear = 2001;
    public boolean checkedOut = false;

    @Test
    public void testAddBook() {
        BookHelper.eraseBookList();
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book);
        Assert.assertEquals(BookHelper.getBooks().size(), 1);
        Assert.assertEquals(BookHelper.getBooks().get(0).getTitle(), sampleTitle);
    }

    @Test
    public void eraseBookList() {
        BookHelper.eraseBookList();
        Assert.assertEquals(BookHelper.getBooks().isEmpty(), true);
    }

    @Test
    public void testAddManyBooks() {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888);
        BookHelper.addBook(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007);
        BookHelper.addBook(book3);

        Assert.assertEquals(BookHelper.getBooks().size(), 3);
        Assert.assertEquals(BookHelper.getBooks().get(1).getTitle(), "CRIME AND PUNISHMENT");
        Assert.assertEquals(BookHelper.getBooks().get(1).getAuthor(), "FIODOR DOSTOIEVSKI");
        Assert.assertEquals(BookHelper.getBooks().get(2).getYear(), 2007);
    }

    @Test
    public void checkOutBook() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, false);
        BookHelper.addBook(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007);
        BookHelper.addBook(book3);

        BookHelper.checkOutBook("CRIME AND PUNISHMENT");
    }

    @Test(expected=BookNotFound.class)
    public void checkOutBookNotFoundNotEmptyList() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book1);

        BookHelper.checkOutBook("CRIME AND PUNISHMENT");
    }

    @Test(expected=BookNotFound.class)
    public void checkOutBookNotFoundEmptyList() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();

        BookHelper.checkOutBook("CRIME AND PUNISHMENT");
    }

    @Test
    public void checkInBook()  throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, true);
        BookHelper.addBook(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007);
        BookHelper.addBook(book3);

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }

    @Test(expected=BookNotFound.class)
    public void checkInBookNotFoundNotEmptyList()  throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        BookHelper.addBook(book1);

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }

    @Test(expected=BookNotFound.class)
    public void checkInBookNotFoundEmptyList() throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }
}