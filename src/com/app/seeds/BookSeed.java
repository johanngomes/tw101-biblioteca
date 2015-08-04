package com.app.seeds;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.helpers.BookHelper;
import com.app.helpers.UserHelper;
import com.app.models.Book;
import com.app.models.User;

/**
 * Created by jgomes on 7/23/15.
 */
public class BookSeed {

    public static void feedBookHelper() throws MalformedEnteredInformation{

        BookHelper.addItem(new Book("HARRY POTTER AND THE CHAMBER OF SECRETS", "J.K. ROWLING", 2001, false,
                new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                        "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234")));

        BookHelper.addItem(new Book("CRIME AND PUNISHMENT", "FIODOR DOSTOIEVSKI", 1921, false,
                new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                    "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234")));

        BookHelper.addItem(new Book("PAPER CITIES", "JOHN GREEN", 2007, false,
                new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                        "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234")));

        BookHelper.addItem(new Book("THE DA VINCI CODE", "DAN BROWN", 1999, false,
                new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                        "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234")));
    }

}
