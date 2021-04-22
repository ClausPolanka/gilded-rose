package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestUtils.assertItemEquals;
import static org.junit.Assert.*;

public class ClassifiedItemBackstagePassTest {

    @Test
    public void givenItemBackstagePassWithSellInGt11_whenUpdateQuality_thenQualityIncreasesByOne() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_BACKSTAGE, 15, 20));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_BACKSTAGE, 14, 21);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenItemBackstagePassWithSellInBetween10And6_whenUpdateQuality_thenQualityIncreasesByTwo() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_BACKSTAGE, 10, 30));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_BACKSTAGE, 9, 32);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenItemBackstagePassWithSellInBetween5And1_whenUpdateQuality_thenQualityIncreasesByThree() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_BACKSTAGE, 5, 30));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_BACKSTAGE, 4, 33);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenItemBackstagePassWithSellLessEqual0_whenUpdateQuality_thenQualityIsSetToZero() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item(ClassifiedItem.ITEM_BACKSTAGE, 0, 38));

        subject = subject.calculateUpdate();

        Item expected = new Item(ClassifiedItem.ITEM_BACKSTAGE, -1, 0);

        assertItemEquals(expected, subject.getItem());
    }

}