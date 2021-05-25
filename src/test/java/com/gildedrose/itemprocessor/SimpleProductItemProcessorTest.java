package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleProductItemProcessorTest {

    @Test
    void processItem() {
        //arrange
        ItemProcessor itemProcessor = new SimpleProductItemProcessor();
        Item simpleItem = new Item("simpleItem", 5, 6);

        //act
        itemProcessor.processItem(simpleItem, 1);

        //assert
        Assertions.assertEquals("simpleItem", simpleItem.name);
        Assertions.assertEquals(4, simpleItem.sellIn);
        Assertions.assertEquals(5, simpleItem.quality);
    }
}