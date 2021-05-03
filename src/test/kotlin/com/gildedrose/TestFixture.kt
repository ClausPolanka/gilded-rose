package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(BasicItem("+5 Dexterity Vest", 10, 20), //
        AgedBrieItem("Aged Brie", 2, 0), //
        BasicItem("Elixir of the Mongoose", 5, 7), //
        SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80), //
        SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80),
        BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        BasicItem("Conjured Mana Cake", 3, 6))

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}