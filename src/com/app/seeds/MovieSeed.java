package com.app.seeds;

import com.app.exceptions.IllegalRatingValue;
import com.app.exceptions.MovieNotRatedCantReceiveRating;
import com.app.exceptions.MovieRatedMustReceiveRating;
import com.app.helpers.MovieHelper;
import com.app.helpers.UserHelper;
import com.app.models.Movie;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieSeed {

    public static void feedMovieHelper() throws IllegalRatingValue,
            MovieRatedMustReceiveRating, MovieNotRatedCantReceiveRating{

        MovieHelper.addMovie(new Movie("Madmax Beyond Thunderstone",
                1985, "George Miller", true, 6, true, UserHelper.getUsers().get(0)));

        MovieHelper.addMovie(new Movie("Nimphomaniac",
                1985, "Lars Von Trier", true, 5, true, UserHelper.getUsers().get(1)));

        MovieHelper.addMovie(new Movie("Melancholia",
                1985, "Lars Von Trier", true, 9, false, null));

        MovieHelper.addMovie(new Movie("Psicosis",
                1985, "Gus Van Sant", true, 8, false, null));

    }

}
