package org.example

const val HERO_NAME = "Madrigal"
var playerLevel = 5

fun main() {
    println("The hero announces her presence to the world.")
    println(HERO_NAME)


    println(playerLevel)

    readBountyBoard()
    println("Time passes...")
    println("The hero returns from her quest.")

    playerLevel += 1
    println(playerLevel)

    readBountyBoard()
    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)
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
    println("The hero approaches bounty board. It reads:")
    println(obtainQuest(playerLevel))
}

fun shouldReturnAString():String{
    TODO("implement the string building functionality here to return a string")
    println("This is unrachable")
}

fun performCombat(){
    println("You see nothing to fight")}
fun performCombat(enemyName: String){
    println("You begin fighting $enemyName")}
fun performCombat(enemyName: String, isBlessed: Boolean){
    val combatMessage = if (isBlessed) "You begin fighting with $enemyName. you are blessed with 2X damage!"
    else "\"You begin fighting $enemyName\""
    println(combatMessage)}

fun `-vibe`(){
    TODO("WH Beavis & BHead")
}
