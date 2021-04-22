package com.gildedrose;


import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void whenDayPassesBeforeSellInPasses_thenQualityOfNormalItemsDecreaseByOne() {
        Item[] items = new Item[]{
                new Item("default item", 3, 10)
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        assertEquals(1, subject.items.length);
        Item item = subject.items[0];
        assertEquals(9, item.quality);
        assertEquals(2, item.sellIn);
        assertEquals("default item", item.name);
    }

    @Test
    public void whenDayPassesAfterSellInPasses_thenQualityOfNormalItemsDecreasesByTwo() {
        Item[] items = new Item[]{
                new Item("default item", 0, 10)
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        assertEquals(1, subject.items.length);
        Item item = subject.items[0];
        assertEquals(8, item.quality);
        assertEquals(-1, item.sellIn);
        assertEquals("default item", item.name);
    }

    @Test
    public void whenDayPasses_thenQualityIsNeverNegative() {
        Item[] items = new Item[]{
                new Item("default item", 2, 0),
                new Item("older default item", 0, 1),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        assertEquals(2, subject.items.length);
        Item[] expected = new Item[]{
                new Item("default item", 1, 0),
                new Item("older default item", -1, 0),
        };

        assertItemEquals(expected[0], subject.items[0]);
        assertItemEquals(expected[1], subject.items[1]);
    }

    @Test
    public void whenDayPassesWithAgedBrie_thenQualityIsIncreased() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 20),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expected = new Item("Aged Brie", 1, 21);
        assertItemEquals(expected, subject.items[0]);
    }

    @Test
    public void whenDayPassesWithWronglyCasedAgedBrie_thenQualityIsDecreased() {
        Item[] items = new Item[]{
                new Item("Aged brie", 2, 20),
                new Item("aged Brie", 3, 30),
                new Item("aged brie", 4, 30),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item[] expected = new Item[]{
                new Item("Aged brie", 1, 19),
                new Item("aged Brie", 2, 29),
                new Item("aged brie", 3, 29),
        };
        for (int i = 0; i < expected.length; i++) {
            assertItemEquals(expected[i], subject.items[i]);
        }
    }

    @Ignore
    @Test
    public void whenDayPasses_thenQualityOfNormalItemsIsCappedAt50() {
        Item[] items = new Item[]{
                new Item("Upper Capacity", 2, 60),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expected = new Item("Upper Capacity", 1, 50);
        assertItemEquals(expected, subject.items[0]);
    }

    @Test
    public void whenDayPasses_andQualityIncreases_thenQualityIsCappedAt50() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 5, 49),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expectedDay01 = new Item("Aged Brie", 4, 50);
        assertItemEquals(expectedDay01, subject.items[0]);

        subject.updateQuality();

        Item expectedDay02 = new Item("Aged Brie", 3, 50);
        assertItemEquals(expectedDay02, subject.items[0]);
    }

    private static void assertItemEquals(Item expected, Item actual) {
        assertEquals(expected.quality, actual.quality);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.name, actual.name);
    }
}
