package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.Test

internal class GildedRoseTest {

    @Test
    fun `basic item should decrease quality by 1 when sellIn is positive`() {
        val items = arrayOf<Item>(Item("Basic Item", 1, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("Item name", "Basic Item", app.items[0].name)
        assertEquals("Item sellIn", 0, app.items[0].sellIn)
        assertEquals("Item quality", 4, app.items[0].quality)
    }

    @Test
    fun `basic item should decrease quality by 2 when sellIn is lte 0`() {
        val items = arrayOf<Item>(Item("Basic Item", 0, 5))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("Item name", "Basic Item", app.items[0].name)
        assertEquals("Item sellIn", -1, app.items[0].sellIn)
        assertEquals("Item quality", 3, app.items[0].quality)
    }

    @Test
    fun `basic item should not change to negative quality when sellIn is positive`() {
        val items = arrayOf<Item>(Item("Basic Item", 1, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("Item name", "Basic Item", app.items[0].name)
        assertEquals("Item sellIn", 0, app.items[0].sellIn)
        assertEquals("Item quality", 0, app.items[0].quality)
    }

    @Test
    fun `basic item should change to negative quality when sellIn is lte 0`() {
        val items = arrayOf<Item>(Item("Basic Item", 0, 1))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("Item name", "Basic Item", app.items[0].name)
        assertEquals("Item sellIn", -1, app.items[0].sellIn)
        assertEquals("Item quality", 0, app.items[0].quality)
    }

    @Test
    fun `basic item should not change quality when quality is min and sellIn is lte 0`() {
        val items = arrayOf<Item>(Item("Basic Item", 0, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals("Item name", "Basic Item", app.items[0].name)
        assertEquals("Item sellIn",-1, app.items[0].sellIn)
        assertEquals("Item quality", 0, app.items[0].quality)
    }

}

