package org.example

const val HERO_NAME = "Madrigal"

fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)

    var playerLevel = 4
    println(playerLevel)

    val hasBefrendedBarbarians = true
    val hasAngeredBarbarians = false
    val playerClass = "paladin"
    val quest: String = when (playerLevel){
        1 -> "Meet Mr. Bubbles in the land of soft things."
        in 2..5 -> {
            val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefrendedBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarians) {
                "Convince the barbarians to call off their invasion."
            }else {
                "Save the town from the barbarians invasions."
            }
        }
        6 -> "Locate the enchanted sword."
        7 -> "Recover the long lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eater of the world."
        else -> "There are no quests right now."
    }

    println("The hero approaches bounty board. It reads:")
    println(quest)
    println("Time passes...")
    println("The hero returns from her quest.")

    playerLevel += 1
    println(playerLevel)
}