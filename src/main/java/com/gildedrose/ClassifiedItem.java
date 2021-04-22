package com.gildedrose;

import java.util.Objects;

public class ClassifiedItem {

    public static final String ITEM_AGED_BRIE = "Aged Brie";
    public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String ITEM_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ITEM_CONJURED = "Conjured";
    protected final Item item;

    ClassifiedItem(Item item) {
        this.item = item;
        if (this.item.quality > 50) {
            this.item.quality = 50;
        }
    }

    public static ClassifiedItem buildItem(Item item) {
        Objects.requireNonNull(item, "'Item' must be supplied!");
        if (ITEM_AGED_BRIE.equals(item.name)) {
            return new ClassifiedItemAgedBrie(item);
        } else if (ITEM_SULFURAS.equals(item.name)) {
            return new ClassifiedItemSulfuras(item);
        } else if (ITEM_BACKSTAGE.equals(item.name)) {
            return new ClassifiedItemBackstagePass(item);
        } else if (ITEM_CONJURED.equals(item.name)) {
            return new ClassifiedItemConjured(item);
        } else {
            return new ClassifiedItem(item);
        }
    }

    public ClassifiedItem calculateUpdate() {
        return this
                .recalculateSellIn()
                .recalculateQuality();
    }

    protected ClassifiedItem recalculateSellIn() {
        ClassifiedItem calculated = new ClassifiedItem(new Item(item.name, item.sellIn, item.quality));
        Item item = calculated.getItem();
        item.sellIn -= 1;
        return calculated;
    }

    protected ClassifiedItem recalculateQuality() {
        ClassifiedItem calculated = new ClassifiedItem(new Item(item.name, item.sellIn, item.quality));
        Item item = calculated.getItem();
        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
        return calculated;
    }

    public Item getItem() {
        return item;
    }
}
