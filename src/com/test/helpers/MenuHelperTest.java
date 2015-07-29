package com.test.helpers;

import com.app.exceptions.NoBookRegisteredInSystem;
import com.app.exceptions.OptionNotAvailable;
import com.app.helpers.BookHelper;
import com.app.helpers.MenuHelper;
import com.app.seeds.BookSeed;
import org.junit.Test;

/**
 * Created by jgomes on 7/24/15.
 */
public class MenuHelperTest {

    private void prepareBookList() {
        BookHelper.eraseBookList();
        BookSeed.feedBookHelper();
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailable() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseMainOptionsMenu(3);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailableNegative() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseMainOptionsMenu(-3);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testMainOptionNotAvailableZero() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseMainOptionsMenu(0);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailable() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseListBooksMenu(6, MenuHelper.Action.CHECK_IN);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailableNegative() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseListBooksMenu(-6, MenuHelper.Action.CHECK_IN);
    }

    @Test(expected = OptionNotAvailable.class)
    public void testChooseListBooksMenuOptionNotAvailableZero() throws NoBookRegisteredInSystem, OptionNotAvailable{
        prepareBookList();
        MenuHelper.chooseListBooksMenu(0, MenuHelper.Action.CHECK_IN);
    }
}
