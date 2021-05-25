package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class SimpleProductItemProcessor implements ItemProcessor{

    @Override
    public void processItem(Item item, int days) {
        item.quality = item.quality - days;
        item.sellIn = item.sellIn - days;
    }

}
