package com.test.models;

import com.app.exceptions.IllegalRatingValue;
import com.app.exceptions.MovieNotRatedCantReceiveRating;
import com.app.exceptions.MovieRatedMustReceiveRating;
import com.app.models.Movie;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieTest {
    public String sampleTitle = "WALL-E";
    public Integer sampleYear = 2006;
    public String sampleDirector = "ANDREW STANTON";

    @Test
    public void testCreateMovieObject() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, true, 7, false);
        Assert.assertEquals(Movie.class, movie.getClass());
    }

    @Test(expected = IllegalRatingValue.class)
    public void testCreateMovieWithIllegalRatingNumber() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, true, -2, false);
    }

    @Test(expected = MovieRatedMustReceiveRating.class)
    public void testCreateMovieNotRated() throws IllegalRatingValue,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        Movie movie = new Movie(sampleTitle, sampleYear, sampleDirector, false, null, false);
    }
}
