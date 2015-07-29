package com.app.models;

import com.app.exceptions.IllegalRatingValue;
import com.app.exceptions.MovieNotRatedCantReceiveRating;
import com.app.exceptions.MovieRatedMustReceiveRating;

/**
 * Created by jgomes on 7/27/15.
 */
public class Movie extends Item {
    private String director;

    private Boolean rated = false;
    private Integer rating;

    public Movie(String title, Integer year, String director, Boolean rated, Integer rating, Boolean checkedOut)
            throws IllegalRatingValue, MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating {
        super(title, year, checkedOut);

        this.setDirector(director);
        this.setRated(rated);

        if (getRated() && rating != null) {
            this.setRating(rating);
        } else if (!getRated() && rating != null) {
            throw new MovieNotRatedCantReceiveRating("The rating for a not rated movie must be null.");
        } else {
            throw new MovieRatedMustReceiveRating("null parameter received as rating. Must be an Integer.");
        }
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director.toUpperCase();
    }

    public Boolean getRated() {
        return rated;
    }

    public void setRated(Boolean rated) {
        this.rated = rated;
        this.rating = null;
    }

    public void setRating(Integer rating) throws IllegalRatingValue {
        if (this.getRated() == null) {
            this.setRated(false);
        } else if ( ( rating < 1 ) || (rating > 10) ) {
            throw new IllegalRatingValue("Movie rating must be between 1 and 10.");
        }

        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }
}
