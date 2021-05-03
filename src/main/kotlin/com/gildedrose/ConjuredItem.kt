package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (quality > 0) {
            quality = maxOf(quality - 2, 0)
        }

        sellIn -= 1

        if (sellIn < 0) {
            if (quality > 0) {
                quality = maxOf(quality - 2, 0)
            }
        }
    }
}