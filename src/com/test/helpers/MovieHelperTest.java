package com.test.helpers;

import com.app.exceptions.*;
import com.app.helpers.MovieHelper;
import com.app.models.Movie;
import com.app.models.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieHelperTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public Integer sampleYear = 2001;
    public String sampleDirector = "J.K. ROWLING";
    public Boolean sampleRated = true;
    public Integer sampleRating = 7;
    public boolean sampleCheckedOut = false;

    public User sampleUser;

    public MovieHelperTest() throws MalformedEnteredInformation {
        this.sampleUser = new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234");
    }

    @Test
    public void testAddMovie() throws IllegalRatingValue, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
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
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, false, sampleRating, sampleCheckedOut);
    }

    @Test(expected = MovieRatedMustReceiveRating.class)
    public void testAddMovieRatedWithoutRating() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, null, sampleCheckedOut);
    }

    @Test
    public void testAddManyMovies() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie3);

        Assert.assertEquals(MovieHelper.getMovies().size(), 3);
        Assert.assertEquals(MovieHelper.getMovies().get(1).getTitle(), "THE SHINNING");
        Assert.assertEquals(MovieHelper.getMovies().get(1).getDirector(), "STANLEY KUBRICK");
    }

    @Test
    public void checkOutMovie() throws IllegalRatingValue, MovieNotFound,
            MovieIsAlreadyCheckedOut, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie3);

        MovieHelper.checkOutMovie("THE SHINNING", this.sampleUser);
    }

    @Test(expected = MovieNotFound.class)
    public void checkOutMovieNotFoundNotEmptyList() throws IllegalRatingValue,
            MovieNotFound, MovieIsAlreadyCheckedOut, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie1);

        MovieHelper.checkOutMovie("THE SHINNING", this.sampleUser);
    }

    @Test(expected = MovieNotFound.class)
    public void checkOutMovieNotFoundEmptyList() throws IllegalRatingValue, MovieNotFound,
            MovieIsAlreadyCheckedOut, MovieNotRatedCantReceiveRating {
        MovieHelper.eraseMovieList();

        MovieHelper.checkOutMovie("THE SHINNING", this.sampleUser);
    }

    @Test
    public void checkInMovie() throws IllegalRatingValue, MovieNotFound,
            MovieIsAlreadyCheckedIn, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie1);
        Movie movie2 = new Movie("THE SHINNING", 1988, "STANLEY KUBRICK", sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie2);
        Movie movie3 = new Movie("PULP FICTION", 1994, "QUENTIN TARANTINO", sampleRated, sampleRating, true);
        MovieHelper.addMovie(movie3);

        MovieHelper.checkInMovie("PULP FICTION");
    }

    @Test(expected = MovieNotFound.class)
    public void checkInMovieNotFoundNotEmptyList()  throws IllegalRatingValue, MovieNotFound,
            MovieIsAlreadyCheckedIn, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        MovieHelper.eraseMovieList();
        Movie movie1 = new Movie(sampleTitle, sampleYear, sampleDirector, sampleRated, sampleRating, sampleCheckedOut);
        MovieHelper.addMovie(movie1);

        MovieHelper.checkInMovie("PULP FICTION");
    }

    @Test(expected = MovieNotFound.class)
    public void checkInMovieNotFoundEmptyList() throws IllegalRatingValue, MovieNotFound, MovieIsAlreadyCheckedIn {
        MovieHelper.eraseMovieList();

        MovieHelper.checkInMovie("PULP FICTION");
    }
}
