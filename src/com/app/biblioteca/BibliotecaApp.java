package com.app.biblioteca;

import com.app.exceptions.BookIsAlreadyCheckedIn;
import com.app.exceptions.BookIsAlreadyCheckedOut;
import com.app.exceptions.BookNotFound;
import com.app.exceptions.NoBookRegisteredInSystem;
import com.app.exceptions.OptionNotAvailable;
import com.app.helpers.MenuHelper;
import com.app.seeds.BookSeed;
import java.util.Scanner;

public class BibliotecaApp {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws BookIsAlreadyCheckedIn, BookIsAlreadyCheckedOut,
            BookNotFound, NoBookRegisteredInSystem, OptionNotAvailable {
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

        MenuHelper.buildMainOptionsMenu();

    }
}
