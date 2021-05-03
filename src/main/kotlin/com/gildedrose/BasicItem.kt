package com.gildedrose

open class BasicItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
     open fun updateQuality() {
        if (quality > 0) {
            quality -= 1
        }
        sellIn -= 1

        if (sellIn < 0) {
            if(quality > 0) {
                quality -= 1
            }
        }
    }
}