package com.app.helpers;

import com.app.custom.NoBookRegisteredInSystem;
import com.app.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jgomes on 7/24/15.
 */
public class MenuHelper {

    private enum Action {
        CHECK_OUT, CHECK_IN
    }

    private static Scanner userInput = new Scanner(System.in);
    private static ArrayList<String> mainOptionsDescriptions =
            new ArrayList(Arrays.asList("LIST BOOKS", "RETURN BOOK"));
    private static ArrayList<Integer> mainOptionsNumber = new ArrayList<Integer>();

    public static void buildMainOptionsMenu() throws NoBookRegisteredInSystem{
        int optionNumber = 1;

        for ( String mainOptionsDescription : mainOptionsDescriptions ) {
            mainOptionsNumber.add(optionNumber);
            System.out.println(String.format("Press %d to: %s", optionNumber, mainOptionsDescription));
            optionNumber++;
        }

        Integer currentInput = Integer.parseInt(userInput.next());

        if (currentInput < 1 || currentInput > mainOptionsNumber.get(mainOptionsNumber.size() - 1)) {
            System.out.println("[ERROR] Option not available.");
            buildMainOptionsMenu();
        } else {
            if (currentInput == 1) {
                buildListBooksMenu(Action.CHECK_OUT);
            } else if (currentInput == 2) {
                buildListBooksMenu(Action.CHECK_IN);
            }
        }
    }

    public static void buildListBooksMenu(Action action) throws NoBookRegisteredInSystem{
        ArrayList<Book> books = BookHelper.getBooks();
        System.out.println("\n\n---------------------------------------------\n" +
                "* Book Title * Author * Year * Option *\n" +
                "---------------------------------------------\n");

        if (!books.isEmpty()) {
            int bookNumber = 1;

            for ( Book book : books ) {
                System.out.println(String.format("* %s * %s * %d * [ Press %d to CHECK OUT ]",
                        book.getTitle(), book.getAuthor(), book.getYear(), bookNumber));

                bookNumber++;
            }
        } else {
            throw new NoBookRegisteredInSystem("No book(s) registered in the system.");
        }

        Integer currentInput = Integer.parseInt(userInput.next());

        if (currentInput < 1 || (currentInput > books.size() - 1)) {
            System.out.println("[ERROR] Option not available.");
            buildListBooksMenu(action);
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

            buildMainOptionsMenu();
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
