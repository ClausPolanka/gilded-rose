package com.gildedrose;

import java.util.Objects;

public class ClassifiedItem {

    public static final String ITEM_AGED_BRIE = "Aged Brie";
    public static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String ITEM_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final Item item;

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
        } else {
            return new ClassifiedItem(item);
        }
    }

    public ClassifiedItem calculateUpdate() {
        throw new UnsupportedOperationException();
    }

    public Item getItem() {
        return item;
    }
}
