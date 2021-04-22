package com.gildedrose;

public class ClassifiedItemConjured extends ClassifiedItem {
    ClassifiedItemConjured(Item item) {
        super(item);
    }

    @Override
    public ClassifiedItem calculateUpdate() {
        ClassifiedItem calculated = super.calculateUpdate();
        Item item = calculated.getItem();
        if (item.quality > 0) {
            item.quality -= 1;
            if (item.sellIn <= 0 && item.quality > 0) {
                item.quality -= 1;
            }
        }
        return calculated;
    }
}
