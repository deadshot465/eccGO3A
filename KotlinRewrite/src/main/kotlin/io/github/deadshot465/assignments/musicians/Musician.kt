package io.github.deadshot465.assignments.musicians

import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

const val delay: Long = 750

private val firstNames = listOf("Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
    "Janet", "Leo", "Yuhei", "Carson")

private val lastNames = listOf("Frizzle",
    "Perlstein",
    "Ramon",
    "Ann",
    "Franklin",
    "Terese",
    "Tennelli",
    "Jamal",
    "Li",
    "Perlstein",
    "Fujioka",
    "Ito",
    "Hage")

private fun pickName(): String {
    val firstName = firstNames[Random.nextInt(0, firstNames.size)]
    val lastName = lastNames[Random.nextInt(0, lastNames.size)]
    return "$firstName $lastName"
}

data class Musician(val role: String, val skillLevel: SkillLevel, val receiver: Channel<Int>) {
    private val name: String = pickName()

    init {
        println("Musician ${name}, playing the $role entered the room.")
    }

    fun playSound(): Boolean {
        val receiveResult = receiver.tryReceive()
        if (receiveResult.isSuccess) {
            println("$name just got back to playing in the subway.")
            return false
        }

        return when (skillLevel) {
            SkillLevel.Good -> {
                println("$name produced sound!")
                true
            }
            SkillLevel.Bad -> {
                val failed = Random.nextInt(0, 5) == 0
                if (failed) {
                    println("$name played a false note. Uh oh.")
                    println("$name sucks! kicked that member out of the band! ($role)")
                } else {
                    println("$name produced sound!")
                }
                !failed
            }
        }
    }
}
