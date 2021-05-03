package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (quality > MIN_QUALITY) {
            quality = maxOf(quality - 2, 0)
        }

        sellIn -= 1

        if (sellIn < EXPIRATION_AT) {
            if (quality > MIN_QUALITY) {
                quality = maxOf(quality - 2, 0)
            }
        }
    }
}