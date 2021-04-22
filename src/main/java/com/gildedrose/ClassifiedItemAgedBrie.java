package com.gildedrose;

public class ClassifiedItemAgedBrie extends ClassifiedItem {
    ClassifiedItemAgedBrie(Item item) {
        super(item);
    }

    @Override
    public ClassifiedItem calculateUpdate() {
        ClassifiedItemAgedBrie calculated = new ClassifiedItemAgedBrie(new Item(item.name, item.sellIn, item.quality));
        Item item = calculated.getItem();
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        return calculated;
    }
}
