package com.gildedrose

class AgedBrieItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality(){
        if(quality < MAX_QUALITY) {
            quality += 1
        }
        sellIn -= 1

        if (sellIn < 0) {
            if (quality < MAX_QUALITY) {
                quality += 1
            }
        }
    }
}