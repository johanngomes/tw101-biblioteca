package com.app.helpers;

import com.app.custom.NoBookRegisteredInSystem;
import com.app.custom.OptionNotAvailable;
import com.app.models.Book;

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
    private static ArrayList<String> mainOptions = new ArrayList(Arrays.asList("LIST BOOKS", "RETURN BOOK"));

    public static void buildMainOptionsMenu() throws NoBookRegisteredInSystem, OptionNotAvailable{

        int optionNumber = 1;

        for ( String mainOptionsDescription : mainOptions ) {
            System.out.println(String.format("Press %d to: %s", optionNumber, mainOptionsDescription));
            optionNumber++;
        }

        Integer currentInput = Integer.parseInt(userInput.next());

        chooseMainOptionsMenu(currentInput);

    }

    public static void chooseMainOptionsMenu(int currentInput) throws NoBookRegisteredInSystem, OptionNotAvailable{

        if (currentInput < 1 || currentInput > mainOptions.size()) {
            throw new OptionNotAvailable("[ERROR] Option not available.");
        } else {
            if (currentInput == 1) {
                buildListBooksMenu(Action.CHECK_OUT);
            } else if (currentInput == 2) {
                buildListBooksMenu(Action.CHECK_IN);
            }
        }

    }

    public static void buildListBooksMenu(Action action) throws NoBookRegisteredInSystem, OptionNotAvailable{

        System.out.println("\n\n---------------------------------------------\n" +
                "* Book Title * Author * Year * Option *\n" +
                "---------------------------------------------\n");

        if (!BookHelper.getBooks().isEmpty()) {
            int bookNumber = 1;

            for ( Book book : BookHelper.getBooks() ) {
                System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK OUT ]",
                        book.getTitle(), book.getAuthor(), book.getYear(), bookNumber));

                bookNumber++;
            }
        } else {
            throw new NoBookRegisteredInSystem("No book(s) registered in the system.");
        }

        Integer currentInput = Integer.parseInt(userInput.next());
        chooseListBooksMenu(currentInput, action);

    }

    public static void chooseListBooksMenu(int currentInput, Action action)
            throws NoBookRegisteredInSystem, OptionNotAvailable{

        if (currentInput < 1 || (currentInput > BookHelper.getBooks().size() - 1)) {
            throw new OptionNotAvailable("[ERROR] Option not available.");
        } else {
            String bookSelected = BookHelper.getBooks().get(currentInput - 1).getTitle();
            if (action == Action.CHECK_OUT) {
                try {
                    BookHelper.checkOutBook(bookSelected);
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
}
