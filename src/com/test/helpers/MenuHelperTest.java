package com.test.helpers;

import com.app.exceptions.MalformedEnteredInformation;
import com.app.exceptions.ItemNotRegistered;
import com.app.exceptions.OptionNotAvailable;
import com.app.helpers.BookHelper;
import com.app.helpers.MenuHelper;
import com.app.seeds.BookSeed;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jgomes on 7/24/15.
 */
public class MenuHelperTest {

    @Before
    public void prepareBookList() throws MalformedEnteredInformation{
        BookHelper.eraseBookList();
        BookSeed.feedBookHelper();
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailable() throws ItemNotRegistered, OptionNotAvailable,
            MalformedEnteredInformation{
        MenuHelper.chooseMainOptionsMenu(299);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailableNegative() throws ItemNotRegistered, OptionNotAvailable,
            MalformedEnteredInformation{
        MenuHelper.chooseMainOptionsMenu(-3);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailableZero() throws ItemNotRegistered, OptionNotAvailable,
            MalformedEnteredInformation{
        MenuHelper.chooseMainOptionsMenu(0);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailable() throws ItemNotRegistered, OptionNotAvailable,
            MalformedEnteredInformation{
        MenuHelper.chooseListBooksMenu(6, MenuHelper.Action.CHECK_IN);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailableNegative() throws ItemNotRegistered,
            MalformedEnteredInformation, OptionNotAvailable{
        MenuHelper.chooseListBooksMenu(-6, MenuHelper.Action.CHECK_IN);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailableZero() throws ItemNotRegistered, OptionNotAvailable,
            MalformedEnteredInformation{
        MenuHelper.chooseListBooksMenu(0, MenuHelper.Action.CHECK_IN);
    }
}
