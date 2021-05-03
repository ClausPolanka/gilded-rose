package com.gildedrose

class AgedBrieItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality(){
        if(quality < MAX_QUALITY) {
            quality += 1
        }
        sellIn -= 1

        if (sellIn < EXPIRATION_AT) {
            if (quality < MAX_QUALITY) {
                quality += 1
            }
        }
    }
}