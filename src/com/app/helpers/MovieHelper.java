package com.app.helpers;

import com.app.exceptions.*;
import com.app.models.Movie;
import com.app.models.User;

import java.util.ArrayList;

/**
 * Created by jgomes on 7/28/15.
 */
public class MovieHelper {
    private static ArrayList<Movie> movies = new ArrayList<Movie>();

    public static void addMovie(Movie movie) {
        movies.add(movie);
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static void eraseMovieList() {
        movies.clear();
    }

//    public static void checkInMovie(String title) throws MovieIsAlreadyCheckedIn, MovieNotFound {
//
//        for (Movie movie : movies) {
//            if ( movie.getTitle().equals(title.toUpperCase()) ) {
//                if ( movie.isCheckedOut() == false ) {
//                    throw new MovieIsAlreadyCheckedIn(String.format("%s is already checked in! You can' check in " +
//                            "this movie.", title.toUpperCase()));
//                }
//                else {
//                    movie.setCheckedOut(false);
//                    movie.setCheckedOutBy(null);
//                    return;
//                }
//            }
//        }
//
//        throw new MovieNotFound(String.format("%s not found in the library!", title.toUpperCase()));
//
//    }
//
//    public static void checkOutMovie(String title, User user) throws MovieIsAlreadyCheckedOut, MovieNotFound{
//
//        for (Movie movie : movies) {
//            if ( movie.getTitle().equals(title.toUpperCase()) ) {
//                if ( movie.isCheckedOut() == true ) {
//                    throw new MovieIsAlreadyCheckedOut(String.format("%s is already checked out! You can' check out " +
//                            "this book.", title.toUpperCase()));
//                }
//                else {
//                    movie.setCheckedOut(true);
//                    movie.setCheckedOutBy(user);
//                    return;
//                }
//            }
//        }
//
//        throw new MovieNotFound(String.format("%s not found in the library!", title.toUpperCase()));
//
//    }
}
