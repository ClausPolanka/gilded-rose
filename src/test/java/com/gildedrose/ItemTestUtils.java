package com.gildedrose;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTestUtils {

    public static void assertItemEquals(Item[] expected, Item[] actual) {
        assertItemEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    public static void assertItemEquals(List<Item> expected, List<Item> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            try {
                assertItemEquals(expected.get(i), actual.get(i));
            } catch (AssertionError ae) {
                throw new AssertionError("Mismatched Items at Index:" + i + ", expected:'" + expected.get(i) + "', actual:'" + actual.get(i) + "'", ae);
            }
        }
    }

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
