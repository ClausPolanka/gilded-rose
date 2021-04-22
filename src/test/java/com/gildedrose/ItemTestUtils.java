package com.gildedrose;

import static org.junit.Assert.assertEquals;

public class ItemTestUtils {
    public static void assertItemEquals(Item expected, Item actual) {
        assertEquals(expected.quality, actual.quality);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.name, actual.name);
    }

    public static void assertItemEquals(ClassifiedItem expected, ClassifiedItem actual) {
        assertItemEquals(expected.getItem(), actual.getItem());
        assertEquals(expected.getClass(), actual.getClass());
    }
}
