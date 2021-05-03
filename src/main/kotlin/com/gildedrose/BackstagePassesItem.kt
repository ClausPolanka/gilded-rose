package com.gildedrose

class BackstagePassesItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (quality < MAX_QUALITY) {
            quality += 1

            if (sellIn <= 10) {
                if (quality < MAX_QUALITY) {
                    quality += 1
                }
            }
            if (sellIn <= 5) {
                if (quality < MAX_QUALITY) {
                    quality += 1
                }
            }
        }

        sellIn -= 1

        if(sellIn < EXPIRATION_AT) {
            quality = 0
        }

    }
}