package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

/**
 * An interface for item processing
 */
public interface ItemProcessor {

    void processItem(Item item, int days);

}
