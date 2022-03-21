package io.github.deadshot465

import io.github.deadshot465.assignments.K01
import io.github.deadshot465.assignments.K02
import io.github.deadshot465.assignments.K03
import io.github.deadshot465.assignments.K04
import io.github.deadshot465.assignments.musicians.startBand
import java.util.*

suspend fun main() {
    val questions = listOf(K01(), K02(), K03(), K04())
    println("実行したいプログラムを選択してください。")
    for (i in questions.indices) {
        if (i < 10) {
            println("$i) K0${i}")
        } else {
            val addedNumber = if (i >= 12) { i + 3 } else { i }
            println("$i) K$addedNumber")
        }
    }

    println("100) Kex_1")
    println("101) Kex_2")
    println("102) Sort")
    println("103) Band Supervisor")
    val scanner = Scanner(System.`in`)

    when (val choice = scanner.nextInt()) {
        in 100..102 -> {}
        103 -> {
            startBand(5)
        }
        else -> {
            showSelection(choice)
            val choice2 = scanner.nextInt()
            questions[choice - 1].execute(choice2)
        }
    }
}

private fun showSelection(chapter: Int) {
    for (i in 1..4) {
        if (chapter < 10) {
            println("\t${i}) K0${chapter}_${i}")
        } else {
            println("\t${i}) K${chapter}_${i}")
        }
    }

    if (chapter == 9) {
        println("\t5) K0${chapter}_5")
    }
}