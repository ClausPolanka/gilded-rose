package com.gildedrose;

public class ClassifiedItemBackstagePass extends ClassifiedItem {
    ClassifiedItemBackstagePass(Item item) {
        super(item);
    }

    @Override
    public ClassifiedItem calculateUpdate() {
        ClassifiedItemAgedBrie calculated = new ClassifiedItemAgedBrie(new Item(item.name, item.sellIn, item.quality));
        Item item = calculated.getItem();
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn -= 1;
        if (item.sellIn < 0) {
            // replace with quality = 0; will keep it for tracing original logic
            item.quality = item.quality - item.quality;
        }

        return calculated;
    }
}
