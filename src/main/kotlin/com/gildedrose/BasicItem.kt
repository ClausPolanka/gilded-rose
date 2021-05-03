package com.gildedrose

const val MAX_QUALITY = 50
const val MIN_QUALITY = 0
const val EXPIRATION_AT = 0

open class BasicItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
     open fun updateQuality() {
        if (quality > MIN_QUALITY) {
            quality -= 1
        }
        sellIn -= 1

        if (sellIn < 0) {
            if(quality > MIN_QUALITY) {
                quality -= 1
            }
        }
    }
}