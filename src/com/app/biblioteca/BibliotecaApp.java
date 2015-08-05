package com.app.biblioteca;

import com.app.exceptions.*;
import com.app.helpers.MenuHelper;
import com.app.seeds.BookSeed;
import com.app.seeds.MovieSeed;
import com.app.seeds.UserSeed;

import java.util.Scanner;

public class BibliotecaApp {

    private static Scanner userInput = new Scanner(System.in);

    private static void feedAppWithData() throws MalformedEnteredInformation,
            IllegalRatingValue, MovieRatedMustReceiveRating,
            MovieNotRatedCantReceiveRating {

        UserSeed.feedUserHelper();
        BookSeed.feedBookHelper();
        MovieSeed.feedMovieHelper();

    }

    public static void main(String[] args) throws ItemIsAlreadyCheckedIn, ItemIsAlreadyCheckedOut,
            ItemNotFound, ItemNotRegistered, OptionNotAvailable, MalformedEnteredInformation,
            MovieNotRatedCantReceiveRating, MovieRatedMustReceiveRating, IllegalRatingValue
    {
        BookSeed.feedBookHelper();

        System.out.println("" +
                        "██████╗ ██████╗ ██╗     ███╗   ███╗███████╗\n" +
                        "██╔══██╗██╔══██╗██║     ████╗ ████║██╔════╝\n" +
                        "██████╔╝██████╔╝██║     ██╔████╔██║███████╗\n" +
                        "██╔══██╗██╔═══╝ ██║     ██║╚██╔╝██║╚════██║\n" +
                        "██████╔╝██║     ███████╗██║ ╚═╝ ██║███████║\n" +
                        "╚═════╝ ╚═╝     ╚══════╝╚═╝     ╚═╝╚══════╝\n" +
                        "BANGALORE PUBLIC LIBRARY MANAGEMENT SYSTEM"
        );

        System.out.println("\n\n** Welcome! **\n\n");

        feedAppWithData();

        while ( true ) {
            MenuHelper.buildMainOptionsMenu();
        }


    }
}
