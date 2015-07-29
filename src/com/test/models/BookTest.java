package com.test.models;

import com.app.models.Book;
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

    @Test
    public void testCreateBookObject() {
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        Assert.assertEquals(Book.class, book.getClass());
    }

    @Test
    public void testCreateBookWithoutCheckedOut() {
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut);
        Assert.assertEquals(Book.class, book.getClass());
        Assert.assertEquals(book.isCheckedOut(), false);
    }

    @Test
    public void testCreateBookCheckedOutTrue() {
        Boolean checkedOut = true;
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, checkedOut);
        Assert.assertEquals(Book.class, book.getClass());
        Assert.assertEquals(book.isCheckedOut(), true);
    }
}
