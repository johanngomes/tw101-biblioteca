package com.test.helpers;

import com.app.exceptions.BookIsAlreadyCheckedIn;
import com.app.exceptions.BookIsAlreadyCheckedOut;
import com.app.exceptions.BookNotFound;
import com.app.exceptions.MalformedEnteredInformation;
import com.app.helpers.BookHelper;
import com.app.models.Book;
import com.app.models.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookHelperTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public String sampleAuthor = "J.K. ROWLING";
    public Integer sampleYear = 2001;
    public boolean sampleCheckedOut = false;
    public User sampleUser;


    public BookHelperTest() throws MalformedEnteredInformation {
        this.sampleUser = new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234");
    }

    @Test
    public void testAddBook() {
        BookHelper.eraseBookList();
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book);
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
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, sampleCheckedOut);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut);
        BookHelper.addItem(book3);

        Assert.assertEquals(BookHelper.getBooks().size(), 3);
        Assert.assertEquals(BookHelper.getBooks().get(1).getTitle(), "CRIME AND PUNISHMENT");
        Assert.assertEquals(BookHelper.getBooks().get(1).getAuthor(), "FIODOR DOSTOIEVSKI");
    }

    @Test
    public void checkOutBook() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, false);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut);
        BookHelper.addItem(book3);

        BookHelper.checkOutBook("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test(expected = BookNotFound.class)
    public void checkOutBookNotFoundNotEmptyList() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book1);

        BookHelper.checkOutBook("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test(expected = BookNotFound.class)
    public void checkOutBookNotFoundEmptyList() throws BookNotFound, BookIsAlreadyCheckedOut {
        BookHelper.eraseBookList();

        BookHelper.checkOutBook("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test
    public void checkInBook() throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, true);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut);
        BookHelper.addItem(book3);

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }

    @Test(expected = BookNotFound.class)
    public void checkInBookNotFoundNotEmptyList()  throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        BookHelper.addItem(book1);

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }

    @Test(expected = BookNotFound.class)
    public void checkInBookNotFoundEmptyList() throws BookNotFound, BookIsAlreadyCheckedIn {
        BookHelper.eraseBookList();

        BookHelper.checkInBook("CRIME AND PUNISHMENT");
    }
}