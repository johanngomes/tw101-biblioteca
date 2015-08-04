package com.app.seeds;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.helpers.UserHelper;
import com.app.models.User;

/**
 * Created by jgomes on 7/28/15.
 */
public class UserSeed {

    public static void feedUserHelper() throws MalformedEnteredInformation {

        UserHelper.addUser(new User("JOHANN GOMES", "JGBL@CIN.UFPE.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "996702734", "123-4567", "1234"));

        UserHelper.addUser(new User("LEONARDO SILVEIRA", "CVANALISE@YAHOO.COM.BR",
                "TENENTE JOAO CICERO STREET - BOA VIAGEM", "896702734", "324-5665", "5678"));

        UserHelper.addUser(new User("MATHEUS LANDIM", "MLD@GMAIL.COM",
                "PROF. LUIZ INACIO STREET - VARZEA", "886702734", "921-3421", "3269"));

    }
}
