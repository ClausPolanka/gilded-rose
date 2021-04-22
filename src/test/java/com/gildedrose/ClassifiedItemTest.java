package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestUtils.assertItemEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ClassifiedItemTest {

    @Test
    public void givenGivenNonSpecialItem_whenBuildItem_thenDefaultClassifiedItemBehaviourIsReturned() {
        ClassifiedItem defaultItem = ClassifiedItem.buildItem(new Item("default item", 29, 30));

        ClassifiedItem expected = new ClassifiedItem(new Item("default item", 29, 30));

        assertItemEquals(expected, defaultItem);
    }

    @Test
    public void givenGivenAgedBrie_whenBuildItem_thenSpecializedClassifiedItemBehaviourIsReturned() {
        ClassifiedItem defaultItem = ClassifiedItem.buildItem(new Item("Aged Brie", 29, 30));

        ClassifiedItemAgedBrie expected = new ClassifiedItemAgedBrie(new Item("Aged Brie", 29, 30));

        assertItemEquals(expected, defaultItem);
    }

    @Test
    public void givenGivenSulfuras_whenBuildItem_thenSpecializedClassifiedItemBehaviourIsReturned() {
        ClassifiedItem defaultItem = ClassifiedItem.buildItem(new Item("Sulfuras, Hand of Ragnaros", 29, 30));

        ClassifiedItemSulfuras expected = new ClassifiedItemSulfuras(new Item("Sulfuras, Hand of Ragnaros", 29, 30));

        assertItemEquals(expected, defaultItem);
    }

    @Test
    public void givenGivenBackstagePass_whenBuildItem_thenSpecializedClassifiedItemBehaviourIsReturned() {
        ClassifiedItem defaultItem = ClassifiedItem.buildItem(new Item("Backstage passes to a TAFKAL80ETC concert", 29, 30));

        ClassifiedItemBackstagePass expected = new ClassifiedItemBackstagePass(new Item("Backstage passes to a TAFKAL80ETC concert", 29, 30));

        assertItemEquals(expected, defaultItem);
    }

    @Test
    public void givenGivenConjured_whenBuildItem_thenSpecializedClassifiedItemBehaviourIsReturned() {
        ClassifiedItem defaultItem = ClassifiedItem.buildItem(new Item("Conjured", 29, 30));

        ClassifiedItemConjured expected = new ClassifiedItemConjured(new Item("Conjured", 29, 30));

        assertItemEquals(expected, defaultItem);
    }

    @Test
    public void givenNull_whenBuildItem_thenDetailedNullPointerExceptionIsThrown() {
        try {
            ClassifiedItem.buildItem(null);
            fail();
        } catch (NullPointerException npe) {
            assertTrue(npe.getMessage().contains("'Item'"));
        }
    }

    @Test
    public void givenDefaultClassifiedItem_whenCalculateUpdate_thenDecreaseQualityAndSellIn() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item("default item", 3, 20));

        subject = subject.calculateUpdate();

        Item expected = new Item("default item", 2, 19);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenDefaultClassifiedItemWithZeroQuality_whenCalculateUpdate_thenQualityDoesNotGetNegativeAndSellInDecreases() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item("default item", 3, 0));

        subject = subject.calculateUpdate();

        Item expected = new Item("default item", 2, 0);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenDefaultClassifiedItemWithQualityGt50_whenCalculateUpdate_thenQualityIsCappedAt49AndSellInDecreases() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item("default item", 3, 60));

        subject = subject.calculateUpdate();

        Item expected = new Item("default item", 2, 49);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenDefaultClassifiedItemAnyQualityZeroSellIn_whenCalculateUpdate_thenQualityIsDecreasedAndSellInDecreasesFurther() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item("default item", 0, 35));

        subject = subject.calculateUpdate();

        Item expected = new Item("default item", -1, 33);

        assertItemEquals(expected, subject.getItem());
    }

    @Test
    public void givenDefaultClassifiedItemZeroQualityZeroSellIn_whenCalculateUpdate_thenQualityIsZeroAndSellInDecreasesFurther() {
        ClassifiedItem subject = ClassifiedItem.buildItem(new Item("default item", 0, 0));

        subject = subject.calculateUpdate();

        Item expected = new Item("default item", -1, 0);

        assertItemEquals(expected, subject.getItem());
    }
}