package com.gildedrose;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items = Stream.of(items)
                .map(ClassifiedItem::buildItem)
                .map(ClassifiedItem::calculateUpdate)
                .map(ClassifiedItem::getItem)
                .toArray(Item[]::new);
    }
}
