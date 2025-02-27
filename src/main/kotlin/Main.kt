package org.example

const val HERO_NAME = "Madrigal"
const val TAVERN_NAME = "Unicorn horn"

fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)

    var playerLevel = 4
    println(playerLevel)
    println("The hero embarks on her journey to locate the enchanted sword.")
    playerLevel += 1
    println(playerLevel)

    var hasSteed = false
    val menu = mapOf("Mead" to 15, "Vine" to 20,  "Beer" to 10)
    println("We have:")
    println(menu.map { (drink, price) -> "$drink by price $price"})

    println("A quick look in the mirror: " + HERO_NAME.reversed())
}