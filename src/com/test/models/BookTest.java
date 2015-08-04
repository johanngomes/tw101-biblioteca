package com.test.models;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.models.Book;
import com.app.models.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public String sampleAuthor = "J.K. ROWLING";
    public int sampleYear = 2001;
    public boolean sampleCheckedOut = false;
    public User sampleUser = null;

    public BookTest() throws MalformedEnteredInformation {
        this.sampleUser = new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234");
    }

    @Test
    public void testCreateBookObject() {
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        Assert.assertEquals(Book.class, book.getClass());
    }

    @Test
    public void testCreateBookWithoutCheckedOut() {
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        Assert.assertEquals(Book.class, book.getClass());
        Assert.assertEquals(book.isCheckedOut(), false);
    }

    @Test
    public void testCreateBookCheckedOutTrue() {
        Boolean checkedOut = true;
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut, sampleUser);
        Assert.assertEquals(Book.class, book.getClass());
        Assert.assertEquals(book.isCheckedOut(), true);
    }
}
