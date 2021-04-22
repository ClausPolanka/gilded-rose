package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestUtils.assertItemEquals;

public class ClassifiedItemAgedBrieTest {

    @Test
    public void givenAgedBrie_whenUpdateQuality_thenQualityIncreasesByOne() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_AGED_BRIE, 2, 20));

        subject = subject.calculateUpdate();

        Item expected = new Item("Aged Brie", 1, 21);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenAgedBrie_whenUpdateQuality_thenQualityIsCappedAt50() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_AGED_BRIE, 2, 49));

        subject = subject.calculateUpdate();
        Item expected = new Item("Aged Brie", 1, 50);
        assertItemEquals(expected, subject.getItem());

        subject = subject.calculateUpdate();
        expected = new Item("Aged Brie", 0, 50);
        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenAgedBrieWithNegativeSellIn_whenUpdateQuality_thenQualityIsCappedAt50() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_AGED_BRIE, -1, 45));

        subject = subject.calculateUpdate();
        Item expected = new Item("Aged Brie", -2, 47);
        assertItemEquals(expected, subject.getItem());
    }
}