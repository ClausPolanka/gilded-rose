package com.gildedrose;


import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.Stream;

import static com.gildedrose.ItemTestUtils.assertItemEquals;
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

    /**
     * FIXME: after refactoring this behavior should FAIL!
     */
    @Test
    public void incorrectBehaviour_itemsCanBeCreatedAboveTheLimit() {
        Item[] items = new Item[]{
                new Item("Upper Capacity", 2, 60),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expected = new Item("Upper Capacity", 1, 59);
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

    @Test
    public void whenDayPasses_andBriIsAlreadyPassedSellIn_thenQualityIsCappedAt50() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 0, 49),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expectedDay01 = new Item("Aged Brie", -1, 50);
        assertItemEquals(expectedDay01, subject.items[0]);

        subject.updateQuality();

        Item expectedDay02 = new Item("Aged Brie", -2, 50);
        assertItemEquals(expectedDay02, subject.items[0]);
    }

    @Test
    public void whenDayPasses_andItemIsSulfuras_thenNeitherSellInNorQualityChanges() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 1, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item[] expected = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", 1, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        for(int i = 0; i < expected.length; i++) {
            assertItemEquals(expected[i], subject.items[i]);
        }
    }

    @Test
    public void whenDayPasses_andItemIsABackstagePassTAFKAL80ETCWithSellInGt11_thenQualityIncreasesByOne() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expected = new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21);
        assertItemEquals(expected, subject.items[0]);
    }

    @Ignore
    @Test
    public void whenDayPasses_andItemIsABackstagePassTAFKAL90ETCWithSellInGt11_thenQualityIncreasesByOne() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL90ETC concert", 15, 20),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item expected = new Item("Backstage passes to a TAFKAL90ETC concert", 14, 21);
        assertItemEquals(expected, subject.items[0]);
    }

    @Test
    public void whenDayPasses_andItemIsABackstagePassTAFKAL80ETCWithSellInBetween10And6_thenQualityIncreasesByTwo() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 35),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item[] expected = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 32),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 37),
        };
        for(int i = 0; i < expected.length; i++) {
            assertItemEquals(expected[i], subject.items[i]);
        }
    }

    @Test
    public void whenDayPasses_andItemIsABackstagePassTAFKAL80ETCWithSellInBetween5And1_thenQualityIncreasesByThree() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 35),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item[] expected = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 33),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 38),
        };
        for(int i = 0; i < expected.length; i++) {
            assertItemEquals(expected[i], subject.items[i]);
        }
    }

    @Test
    public void whenDayPasses_andItemIsABackstagePassTAFKAL80ETCWithSellInLE0_thenQualitySetToZero() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 38),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 42),
        };
        GildedRose subject = new GildedRose(items);

        subject.updateQuality();

        Item[] expected = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0),
        };
        for(int i = 0; i < expected.length; i++) {
            assertItemEquals(expected[i], subject.items[i]);
        }
    }
}
