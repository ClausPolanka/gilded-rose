package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.exp

internal class GildedRoseTest {

    @Test
    fun `basic item should decrease quality by 1 when sellIn is positive`() {
        whenUpdatingQuality(arrayOf(BasicItem("Basic Item", 1, 5)))
                .expectChanges(Item("Basic Item", 0, 4))
    }

    @Test
    fun `basic item should decrease quality by 2 when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(BasicItem("Basic Item", 0, 5)))
                .expectChanges(Item("Basic Item", -1, 3))
    }

    @Test
    fun `basic item should not change to negative quality when sellIn is positive`() {
        whenUpdatingQuality(arrayOf(BasicItem("Basic Item", 1, 0)))
                .expectChanges(Item("Basic Item", 0, 0))
    }

    @Test
    fun `basic item should change to negative quality when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(BasicItem("Basic Item", 0, 1)))
                .expectChanges(Item("Basic Item", -1, 0))
    }

    @Test
    fun `basic item should not change quality when quality is min and sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(BasicItem("Basic Item", 0, 0)))
                .expectChanges(Item("Basic Item", -1, 0))
    }

    @Test
    fun `aged brie item should increase quality by 1 when sellIn is gt 0`() {
        whenUpdatingQuality(arrayOf(AgedBrieItem("Aged Brie", 1, 3)))
                .expectChanges(Item("Aged Brie", 0, 4))
    }

    @Test
    fun `aged brie item should increase quality by 2 when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(AgedBrieItem("Aged Brie", 0, 3)))
                .expectChanges(Item("Aged Brie", -1, 5))
    }

    @Test
    fun `aged brie item should not increase quality more than max when sellIn is gt 0`() {
        whenUpdatingQuality(arrayOf(AgedBrieItem("Aged Brie", 1, 50)))
                .expectChanges(Item("Aged Brie", 0, 50))
    }

    @Test
    fun `aged brie item should not increase quality more than max when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(AgedBrieItem("Aged Brie", 0, 49)))
                .expectChanges(Item("Aged Brie", -1, 50))
    }

    @Test
    fun `aged brie item should not increase quality when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(AgedBrieItem("Aged Brie", 0, 50)))
                .expectChanges(Item("Aged Brie", -1, 50))
    }

    @Test
    fun `sulfuras item should not change quality nor sellIn`() {
        whenUpdatingQuality(arrayOf(SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80)))
                .expectChanges(Item("Sulfuras, Hand of Ragnaros", 0, 80))
    }

    @Test
    fun `backstage passes should increase quality by 1 when sellIn gt 10`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 11, 5)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 10, 6))
    }

    @Test
    fun `backstage passes should increase quality by 2 when sellIn lte 10 and gt 5`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 5)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 9, 7))
    }

    @Test
    fun `backstage passes should increase quality by 3 when sellIn lte 5 and gt 0`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 5)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 4, 8))
    }

    @Test
    fun `backstage passes should make quality 0 when sellIn is 0`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 5)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", -1, 0))
    }

    @Test
    fun `backstage passes should not increase quality when quality is max and sellIn gt 10`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 11, 50)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 10, 50))
    }

    @Test
    fun `backstage passes should not increase quality more than max and sellIn lte 10 and gt 5`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 49)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 9, 50))
    }

    @Test
    fun `backstage passes should not increase quality when quality is max and sellIn lte 10 and gt 5`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 50)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 9, 50))
    }

    @Test
    fun `backstage passes should not increase quality when quality is max and sellIn lte 5 and gt 0`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 50)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50))
    }

    @Test
    fun `backstage passes should not increase quality not more than max when sellIn lte 5 and gt 0`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 49)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50))
    }

    @Test
    fun `backstage passes should not increase quality not more than max when sellIn lte 5 and gt 0 and quality is max - 2`() {
        whenUpdatingQuality(arrayOf(BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 48)))
                .expectChanges(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50))
    }

    @Test
    fun `conjured items should decrease quality by 2 when sellIn is positive`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 5, 5)))
                .expectChanges(Item("Conjured Mana Cake", 4, 3))
    }

    @Test
    fun `conjured items should decrease quality by 4 when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 0, 5)))
                .expectChanges(Item("Conjured Mana Cake", -1, 1))
    }

    @Test
    fun `conjured items should not decrease quality more than min when sellIn is positive`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 5, 1)))
                .expectChanges(Item("Conjured Mana Cake", 4, 0))
    }

    @Test
    fun `conjured items should not decrease quality when quality is min and sellIn is positive`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 5, 0)))
                .expectChanges(Item("Conjured Mana Cake", 4, 0))
    }

    @Test
    fun `conjured items should not decrease quality more than min when sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 0, 3)))
                .expectChanges(Item("Conjured Mana Cake", -1, 0))
    }

    @Test
    fun `conjured items should not decrease quality when quality is min and sellIn is lte 0`() {
        whenUpdatingQuality(arrayOf(ConjuredItem("Conjured Mana Cake", 0, 0)))
                .expectChanges(Item("Conjured Mana Cake", -1, 0))
    }

    private fun whenUpdatingQuality(items: Array<BasicItem>): Array<out Item> {
        GildedRose(items).updateQuality()
        return items
    }

    private fun Array<out Item>.expectChanges(vararg expectedItems: Item) {
        assertEquals(this.size, expectedItems.size)

        this.zip(expectedItems).forEach { (actual, expected) ->
            assertEqualsItems(actual, expected)
        }
    }

    private fun assertEqualsItems(actual: Item, expected: Item) {
        assertEquals("Item name", expected.name, actual.name)
        assertEquals("Item sellIn", expected.sellIn, actual.sellIn)
        assertEquals("Item quality", expected.quality, actual.quality)
    }
}

