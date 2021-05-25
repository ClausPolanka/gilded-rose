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

    @Test
    void processItemLessThanZeroDaysLeft(){
        //arrange
        Item item = new Item("Some ITEM", 0, 40);
        ItemProcessor itemProcessor = new SimpleProductItemProcessor();

        //act
        itemProcessor.processItem(item, 3);

        //assert
        Assertions.assertEquals("Some ITEM", item.name);
        Assertions.assertEquals(-3, item.sellIn);
        Assertions.assertEquals(34, item.quality);
    }

    @Test
    void processItemWithMixedDicrease(){
        //arrange
        Item item = new Item("Some ITEM", 1, 40);
        ItemProcessor itemProcessor = new SimpleProductItemProcessor();

        //act
        itemProcessor.processItem(item, 3);

        //assert
        Assertions.assertEquals("Some ITEM", item.name);
        Assertions.assertEquals(-2, item.sellIn);
        Assertions.assertEquals(35, item.quality);
    }
}