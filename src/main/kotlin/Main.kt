package org.example

const val HERO_NAME = "Madrigal"
var playerLevel = 0

fun main() {
    println("$HERO_NAME announces her presence to the world.")
    println("What level is $HERO_NAME?")
    val playerLevelInput = readLine()!!
    playerLevel = if (playerLevelInput.matches("""\d+""".toRegex())) {playerLevelInput.toInt()}
                    else {1}
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
): String = when (playerLevel) {
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
        else -> "There are no quests right now."
    }

private fun readBountyBoard(){
    println(
        """
            |$HERO_NAME approaches bounty board. It reads:
            |    ${obtainQuest(playerLevel).replace("[Nn]ogartse".toRegex(), "xxxxxxxx")}
        """.trimMargin()
    )
}