package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class SimpleProductItemProcessor implements ItemProcessor{

    public static final int DEFAULT_QUALITY_FACTOR = 1;
    public static final int INCREASED_QUALITY_FACTOR = 2;

    @Override
    public void processItem(Item item, int days) {
        if(days < 0 || item == null){
            throw new IllegalArgumentException("Arguments are not correct!");
        }

        int sellInBeforeUpdate = item.sellIn;
        item.sellIn = item.sellIn - days;

        int qualityDecrease = calculateQualityDecrease(item.sellIn, item.sellIn + days, days);

        item.quality = item.quality - qualityDecrease;

        //item quality should not be less than zero
        if(item.quality < 0){
            item.quality = 0;
        }
    }

    //After 0 days quality will be decreased by 2
    private int calculateQualityDecrease(int sellInAfterUpdate, int sellInBeforeUpdate, int daysCount) {
        int qualityDecrease = 0;

        if(sellInAfterUpdate < 0) {
            qualityDecrease = INCREASED_QUALITY_FACTOR * sellInAfterUpdate * (-1);
        }

        if(sellInBeforeUpdate < 0) {
            qualityDecrease += DEFAULT_QUALITY_FACTOR * sellInBeforeUpdate * (-1);
        } else {
            qualityDecrease += DEFAULT_QUALITY_FACTOR * daysCount ;
        }


        return qualityDecrease;
    }

}
