package org.example

const val HERO_NAME = "Madrigal"
var playerLevel = 0

fun main() {
    println("$HERO_NAME announces her presence to the world.")
    println("What level is $HERO_NAME?")
    val playerLevelInput = readLine()!!.toInt()
    playerLevel = playerLevelInput
    println("$HERO_NAME's level is $playerLevel.")

    readBountyBoard()
    println("Time passes...")
    println("$HERO_NAME returns from her quest.")

    playerLevel += 1
    println(playerLevel)

    readBountyBoard()
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    hasBefrendedBarbarians: Boolean = true,
    hasAngeredBarbarians: Boolean = false
): String? {
    if (playerLevel <= 0) {
        throw InvalidPlayerLevelException()
    }
    return when (playerLevel) {
        1 -> "Meet Mr. Bubbles in the land of soft things."
        in 2..5 -> {
            val canTalkToBarbarians = !hasAngeredBarbarians && (hasBefrendedBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarians) {
                "Convince the barbarians to call off their invasion."
            } else {
                "Save the town from the barbarians invasions."
            }
        }

        6 -> "Locate the enchanted sword."
        7 -> "Recover the long lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eater of the world."
        else -> null
    }
}

private fun readBountyBoard() {
    val message = try {
        val quest: String? = obtainQuest(playerLevel)
        quest?.replace("[Nn]ogartse".toRegex(), "xxxxxxxx")
            ?.let { censoredQuest ->
                """
            |$HERO_NAME approaches the bounty board. It reads:
            |    "$censoredQuest"
        """.trimMargin()
            }
    } catch (e: Exception) {
        "$HERO_NAME approaches the bounty board, but it is blank."
    }
    println(message)
}

class InvalidPlayerLevelException() : IllegalArgumentException("Invalid player level (must be at least 1).")