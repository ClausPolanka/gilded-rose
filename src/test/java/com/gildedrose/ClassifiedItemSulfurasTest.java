package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestUtils.assertItemEquals;

public class ClassifiedItemSulfurasTest {

    @Test
    public void givenItemSulfuras_whenCalculateUpdate_thenNeitherSellInNorQualityChanges() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_SULFURAS, -1, 80));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_SULFURAS, -1, 80);

        assertItemEquals(expected, subject.getItem());
    }

}