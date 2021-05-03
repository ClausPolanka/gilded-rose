package com.gildedrose

class AgedBrieItem(name: String, sellIn: Int, quality: Int) : BasicItem(name, sellIn, quality) {
    override fun updateQuality(){
        if(quality < 50) {
            quality += 1
        }
        sellIn -= 1

        if (sellIn < 0) {
            quality += 1
        }
    }
}