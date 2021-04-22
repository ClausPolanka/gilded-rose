package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestUtils.assertItemEquals;

public class ClassifiedItemConjuredTest {

    @Test
    public void givenItemConjured_whenCalculateUpdate_thenQualityDecreasesByTwo() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_CONJURED, 5, 20));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_CONJURED, 4, 18);
        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenItemConjuredWithQuality1_whenCalculateUpdate_thenQualityIsCappedAtZero() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_CONJURED, 5, 1));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_CONJURED, 4, 0);
        assertItemEquals(expected, subject.getItem());
    }

}