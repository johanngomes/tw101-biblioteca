package com.test.models;

import com.app.models.Item;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jgomes on 7/28/15.
 */
public class ItemTest {
    public String sampleTitle = "HARRY POTTER AND THE CHAMBER OF SECRETS";
    public Integer sampleYear = 2001;
    public boolean sampleCheckedOut = false;

    @Test
    public void testCreateItemObject() {
        Item item = new Item(sampleTitle, sampleYear, sampleCheckedOut);
        Assert.assertEquals(Item.class, item.getClass());
    }

    @Test
    public void testCreateItemWithoutCheckedOut() {
        Item item = new Item(sampleTitle, sampleYear, sampleCheckedOut);
        Assert.assertEquals(Item.class, item.getClass());
        Assert.assertEquals(item.isCheckedOut(), false);
    }
}
