package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQulaityWithFooProduct() {
        //arrange
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("foo", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateQulaityWithAgedBrie() {
        //arrange
        Item[] items = new Item[]{new Item("Aged Brie", 4, 6)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(3, app.items[0].sellIn);
        Assertions.assertEquals(7, app.items[0].quality);
    }

    @Test
    void updateQulaityWithSulfuras() {
        //arrange
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 4, 6)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        Assertions.assertEquals(4, app.items[0].sellIn);
        Assertions.assertEquals(6, app.items[0].quality);
    }

    @Test
    @DisplayName("Test for wrong BackstagePasses. Acting like usual product")
    void updateQulaityWithWrongBackstagePasses() {
        //arrange
        Item[] items = new Item[]{new Item("Backstage passes", 8, 50)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Backstage passes", app.items[0].name);
        Assertions.assertEquals(7, app.items[0].sellIn);
        Assertions.assertEquals(49, app.items[0].quality);
    }

    @Test
    @DisplayName("Test for corrrect BackstagePasses, when less than 10 days to sell")
    void updateQulaityWithCorrectBackstagePassesIncreaseByTwo() {
        //arrange
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        Assertions.assertEquals(7, app.items[0].sellIn);
        Assertions.assertEquals(42, app.items[0].quality);
    }

    @Test
    @DisplayName("Test for corrrect BackstagePasses, when less than 5 days to sell")
    void updateQulaityWithBackstagePassesIncreseByThree() {
        //arrange
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        Assertions.assertEquals(2, app.items[0].sellIn);
        Assertions.assertEquals(43, app.items[0].quality);
    }

    @Test
    @DisplayName("Test for corrrect BackstagePasses, when more than 10 days to sell")
    void updateQulaityWithBackstagePassesIncreseByOne() {
        //arrange
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        Assertions.assertEquals(19, app.items[0].sellIn);
        Assertions.assertEquals(41, app.items[0].quality);
    }

    @Test
    void updateQulaityNoDaysLeft() {
        //arrange
        Item[] items = new Item[]{new Item("Some ITEM", 0, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Some ITEM", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(38, app.items[0].quality);
    }

    @Test
    void updateQulaityAgedBrieWithMaxQuality() {
        //arrange
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(4, app.items[0].sellIn);
        Assertions.assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateQulaityAgedBrieWithNoDaysLeft() {
        //arrange
        Item[] items = new Item[]{new Item("Aged Brie", 0, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(42, app.items[0].quality);
    }

    @Test
    void updateQulaityAgedBrieWithLessThanFiveDays() {
        //arrange
        Item[] items = new Item[]{new Item("Aged Brie", 4, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(3, app.items[0].sellIn);
        Assertions.assertEquals(41, app.items[0].quality);
    }

    @Test
    void updateQulaityBackstagePassesWithNoDays() {
        //arrange
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40)};
        GildedRose app = new GildedRose(items);

        //act
        app.updateQuality();

        //assert
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(0, app.items[0].quality);
    }


}
