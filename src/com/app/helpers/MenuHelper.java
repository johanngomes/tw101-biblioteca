package com.app.helpers;

import com.app.exceptions.ItemNotRegistered;
import com.app.exceptions.OptionNotAvailable;
import com.app.exceptions.InvalidLogin;
import com.app.models.Book;
import com.app.models.Movie;
import com.app.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jgomes on 7/24/15.
 */
public class MenuHelper {

    public enum Action {
        CHECK_OUT, CHECK_IN
    }

    private static Scanner userInput = new Scanner(System.in);
    private static ArrayList<String> mainOptions = new ArrayList(Arrays.asList("LIST BOOKS",
            "RETURN BOOK", "LIST MOVIES", "RETURN MOVIE", "CHECK MY INFORMATION"));

    private static User loggedUser = null;

    public static void buildLoginScreen(String name, String password)
            throws InvalidLogin {
        try {
            loggedUser = UserHelper.loginUser(name, password);
            buildMainOptionsMenu();
        } catch ( Exception UserCredentialsInvalid ) {
            System.out.println("[!] User not identified. Check your username and/or password!");
        }
    }

    public static void buildMainOptionsMenu() throws ItemNotRegistered, OptionNotAvailable{

        int optionNumber = 1;

        for ( String mainOptionsDescription : mainOptions ) {
            System.out.println(String.format("Press %d to: %s", optionNumber, mainOptionsDescription));
            optionNumber++;
        }

        Integer currentInput = Integer.parseInt(userInput.next());

        chooseMainOptionsMenu(currentInput);

    }

    public static void chooseMainOptionsMenu(int currentInput) throws ItemNotRegistered, OptionNotAvailable{

        if (currentInput < 1 || currentInput > mainOptions.size()) {
            throw new OptionNotAvailable("[ERROR] Option not available.");
        } else {
            if (currentInput == 1) {
                buildListBooksMenu(Action.CHECK_OUT);
            } else if (currentInput == 2) {
                buildListBooksMenu(Action.CHECK_IN);
            } else if (currentInput == 4) {
                buildListMoviesMenu(Action.CHECK_OUT);
            } else if (currentInput == 5) {
                buildListMoviesMenu(Action.CHECK_IN);
            } else if (currentInput == 6) {
                buildUserInformationMenu();
            }
        }

    }

    public static void buildListMoviesMenu(Action action) throws ItemNotRegistered, OptionNotAvailable {
        System.out.println("\n\n---------------------------------------------\n" +
                "* Movie Title * Year * Director * Rating * Option *\n" +
                "---------------------------------------------\n");

        if (!MovieHelper.getMovies().isEmpty()) {
            int movieNumber = 1;

            for ( Movie movie : MovieHelper.getMovies() ) {
                if ( action == Action.CHECK_OUT ) {
                    if ( !movie.isCheckedOut() ) {
                        System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK OUT ]",
                                movie.getTitle(), movie.getYear(), movie.getDirector(), movie.getRating(), movieNumber));
                    }
                } else if ( action == Action.CHECK_IN ) {
                    if ( movie.isCheckedOut() ) {
                        System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK IN ]",
                                movie.getTitle(), movie.getYear(), movie.getDirector(), movie.getRating(), movieNumber));
                    }
                }

                movieNumber++;
            }
        } else {
            throw new ItemNotRegistered("No movie(s) registered in the system.");
        }

        Integer currentInput = Integer.parseInt(userInput.next());
        chooseListMoviesMenu(currentInput, action);
    }

    public static void chooseListMoviesMenu(int currentInput, Action action)
            throws ItemNotRegistered, OptionNotAvailable{

        if (currentInput < 1 || (currentInput > MovieHelper.getMovies().size() - 1)) {
            throw new OptionNotAvailable("[ERROR] Option not available.");
        } else {
            String movieSelected = MovieHelper.getMovies().get(currentInput - 1).getTitle();
            if (action == Action.CHECK_OUT) {
                try {
                    ItemHelper.checkOutItem(movieSelected, loggedUser);
                    MenuHelper.buildCheckOutMessage(true, movieSelected);
                } catch (Exception BookIsAlreadyCheckedOut) {
                    MenuHelper.buildCheckOutMessage(false, movieSelected);
                }
            } else if (action == Action.CHECK_IN) {
                try {
                    ItemHelper.checkInItem(movieSelected);
                    MenuHelper.buildCheckInMessage(true, movieSelected);
                } catch (Exception BookIsAlreadyCheckedOut) {
                    MenuHelper.buildCheckInMessage(false, movieSelected);
                }
            }
        }
    }

    public static void buildListBooksMenu(Action action) throws ItemNotRegistered, OptionNotAvailable {

        System.out.println("\n\n---------------------------------------------\n" +
                "* Book Title * Author * Year * Option *\n" +
                "---------------------------------------------\n");

        if (!BookHelper.getBooks().isEmpty()) {
            int bookNumber = 1;

            for ( Book book : BookHelper.getBooks() ) {
                if ( action == Action.CHECK_OUT ) {
                    if ( !book.isCheckedOut() ) {
                        System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK IN ]",
                                book.getTitle(), book.getAuthor(), book.getYear(), bookNumber));
                    }

                } else if ( action == Action.CHECK_IN ) {
                    if ( !book.isCheckedOut() ) {
                        System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK OUT ]",
                                book.getTitle(), book.getAuthor(), book.getYear(), bookNumber));
                    }
                }

                bookNumber++;
            }
        } else {
            throw new ItemNotRegistered("No book(s) registered in the system.");
        }

        Integer currentInput = Integer.parseInt(userInput.next());
        chooseListBooksMenu(currentInput, action);

    }

    public static void chooseListBooksMenu(int currentInput, Action action)
            throws ItemNotRegistered, OptionNotAvailable{

        if (currentInput < 1 || (currentInput > BookHelper.getBooks().size() - 1)) {
            throw new OptionNotAvailable("[ERROR] Option not available.");
        } else {
            String bookSelected = BookHelper.getBooks().get(currentInput - 1).getTitle();
            if (action == Action.CHECK_OUT) {
                try {
                    BookHelper.checkOutBook(bookSelected, loggedUser);
                    MenuHelper.buildCheckOutMessage(true, bookSelected);
                } catch (Exception BookIsAlreadyCheckedOut) {
                    MenuHelper.buildCheckOutMessage(false, bookSelected);
                }
            } else if (action == Action.CHECK_IN) {
                try {
                    BookHelper.checkInBook(bookSelected);
                    MenuHelper.buildCheckInMessage(true, bookSelected);
                } catch (Exception BookIsAlreadyCheckedOut) {
                    MenuHelper.buildCheckInMessage(false, bookSelected);
                }
            }
        }
    }

    public static void buildCheckOutMessage(boolean checkedOut, String bookName) {

        if (checkedOut) {
            System.out.println(String.format("\n\n[OK] THE BOOK %s WAS CHECKED OUT SUCCESSFULLY!\n\n", bookName));
        } else {
            System.out.println(String.format("\n\n[ERROR] THE BOOK %s IS NOT AVAILABLE TO CHECK OUT!\n\n", bookName));
        }
    }

    public static void buildCheckInMessage(boolean checkedIn, String bookName) {

        if (checkedIn) {
            System.out.println(String.format("\n\n[OK] THANK YOU FOR RETURNING THE BOOK %s !\n\n", bookName));
        } else {
            System.out.println(String.format("\n\n[ERROR] THE BOOK %s IS NOT AVAILABLE TO CHECK IN" +
                    "BECAUSE IT WAS NOT CHECKED OUT!\n\n", bookName));
        }

    }

    public static void buildUserInformationMenu() throws ItemNotRegistered, OptionNotAvailable {
        System.out.println("\n\n---------------------------------------------\n" +
                "* Name * Email * Address * Phone Number *\n" +
                "---------------------------------------------\n");
        System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK OUT ]",
                loggedUser.getName(), loggedUser.getEmail(), loggedUser.getAddress(), loggedUser.getPhoneNumber()));
        buildMainOptionsMenu();
    }
}
