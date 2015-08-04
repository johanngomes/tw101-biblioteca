package com.test.helpers;

import com.app.exceptions.*;
import com.app.helpers.BookHelper;
import com.app.helpers.ItemHelper;
import com.app.helpers.MovieHelper;
import com.app.models.Book;
import com.app.models.Movie;
import com.app.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jgomes on 8/3/15.
 */
public class ItemHelperTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public String sampleAuthor = "J.K. ROWLING";
    public Integer sampleYear = 2001;
    public boolean sampleCheckedOut = false;
    public User sampleUser;

    public String sampleDirector = "Steven Spielberg";
    public Boolean sampleRated = true;
    public Integer sampleRating = 7;

    @Before
    public void feedItemHelper() throws MalformedEnteredInformation {
        this.sampleUser = new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234");
    }

    @Test
    public void testAddBook() {
        BookHelper.eraseBookList();
        Book book = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
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
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book3);

        Assert.assertEquals(BookHelper.getBooks().size(), 3);
        Assert.assertEquals(BookHelper.getBooks().get(1).getTitle(), "CRIME AND PUNISHMENT");
        Assert.assertEquals(BookHelper.getBooks().get(1).getAuthor(), "FIODOR DOSTOIEVSKI");
    }

    @Test
    public void checkOutBook() throws ItemNotFound, ItemIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, false, sampleUser);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book3);

        ItemHelper.checkOutItem("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test(expected = ItemNotFound.class)
    public void checkOutBookNotFoundNotEmptyList() throws ItemNotFound, ItemIsAlreadyCheckedOut {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book1);

        ItemHelper.checkOutItem("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test(expected = ItemNotFound.class)
    public void checkOutBookNotFoundEmptyList() throws ItemNotFound, ItemIsAlreadyCheckedOut {
        BookHelper.eraseBookList();

        ItemHelper.checkOutItem("CRIME AND PUNISHMENT", this.sampleUser);
    }

    @Test
    public void checkInBook() throws ItemNotFound, ItemIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book1);
        Book book2 = new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1888, true, sampleUser);
        BookHelper.addItem(book2);
        Book book3 = new Book("LEITE DERRAMADO", "CHICO BUARQUE", 2007, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book3);

        ItemHelper.checkInItem("CRIME AND PUNISHMENT");
    }

    @Test(expected = ItemNotFound.class)
    public void checkInBookNotFoundNotEmptyList()  throws ItemNotFound, ItemIsAlreadyCheckedIn {
        BookHelper.eraseBookList();
        Book book1 = new Book(sampleTitle, sampleAuthor, sampleYear, sampleCheckedOut, sampleUser);
        BookHelper.addItem(book1);

        ItemHelper.checkInItem("CRIME AND PUNISHMENT");
    }

    @Test(expected = ItemNotFound.class)
    public void checkInBookNotFoundEmptyList() throws ItemNotFound, ItemIsAlreadyCheckedIn {
        BookHelper.eraseBookList();

        ItemHelper.checkInItem("CRIME AND PUNISHMENT");
    }

    @Test
    public void testAddMovie() throws IllegalRatingValue, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie);
        Assert.assertEquals(MovieHelper.getMovies().size(), 1);
        Assert.assertEquals(MovieHelper.getMovies().get(0).getTitle(), sampleTitle);
    }

    @Test
    public void eraseMovieList() {
        MovieHelper.eraseMovieList();
        Assert.assertEquals(MovieHelper.getMovies().isEmpty(), true);
    }

    @Test(expected = MovieNotRatedCantReceiveRating.class)
    public void testAddMovieNotRatedWithRating() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, false,
                sampleRating, sampleCheckedOut, sampleUser);
    }

    @Test(expected = MovieRatedMustReceiveRating.class)
    public void testAddMovieRatedWithoutRating() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                null, sampleCheckedOut, sampleUser);
    }

    @Test
    public void testAddManyMovies() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated,

                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie3);

        Assert.assertEquals(MovieHelper.getMovies().size(), 3);
        Assert.assertEquals(MovieHelper.getMovies().get(1).getTitle(), "THE SHINNING");
        Assert.assertEquals(MovieHelper.getMovies().get(1).getDirector(), "STANLEY KUBRICK");
    }

    @Test
    public void checkOutMovie() throws IllegalRatingValue, ItemNotFound,
            ItemIsAlreadyCheckedOut, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie3);

        ItemHelper.checkOutItem("THE SHINNING", this.sampleUser);
    }

    @Test(expected = ItemNotFound.class)
    public void checkOutMovieNotFoundNotEmptyList() throws IllegalRatingValue,
            ItemNotFound, ItemIsAlreadyCheckedOut, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie1);

        ItemHelper.checkOutItem("THE SHINNING", this.sampleUser);
    }

    @Test(expected = ItemNotFound.class)
    public void checkOutMovieNotFoundEmptyList() throws IllegalRatingValue,
            ItemNotFound, ItemIsAlreadyCheckedOut {
        MovieHelper.eraseMovieList();

        ItemHelper.checkOutItem("THE SHINNING", this.sampleUser);
    }

    @Test
    public void checkInMovie() throws IllegalRatingValue,
            ItemNotFound, ItemIsAlreadyCheckedIn, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated,
                sampleRating, true, sampleUser);
        MovieHelper.addMovie(movie3);

        ItemHelper.checkInItem("PULP FICTION");
    }

    @Test(expected = ItemNotFound.class)
    public void checkInMovieNotFoundNotEmptyList()  throws IllegalRatingValue,
            ItemNotFound, ItemIsAlreadyCheckedIn, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated,
                sampleRating, sampleCheckedOut, sampleUser);
        MovieHelper.addMovie(movie1);

        ItemHelper.checkInItem("PULP FICTION");
    }

    @Test(expected = ItemNotFound.class)
    public void checkInMovieNotFoundEmptyList() throws ItemNotFound, ItemIsAlreadyCheckedIn,
            IllegalRatingValue {
        MovieHelper.eraseMovieList();

        ItemHelper.checkInItem("PULP FICTION");
    }
}