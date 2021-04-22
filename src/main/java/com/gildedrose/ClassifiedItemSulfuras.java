package com.gildedrose;

public class ClassifiedItemSulfuras extends ClassifiedItem {
    ClassifiedItemSulfuras(Item item) {
        super(item);
        this.item.quality = 80;
    }

    @Override
    public ClassifiedItem calculateUpdate() {
        return new ClassifiedItemSulfuras(new Item(item.name, item.sellIn, item.quality));
    }
}
