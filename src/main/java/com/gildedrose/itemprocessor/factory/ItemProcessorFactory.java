package com.gildedrose.itemprocessor.factory;

import com.gildedrose.Item;
import com.gildedrose.itemprocessor.ItemProcessor;

public interface ItemProcessorFactory {

    ItemProcessor createItemProcessor(Item item);

}
