package com.gildedrose

class GildedRose(var items: Array<BasicItem>) {

    fun updateQuality() {
        items.forEach { it.updateQuality() }
    }

}
