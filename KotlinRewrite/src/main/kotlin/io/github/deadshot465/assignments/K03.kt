package io.github.deadshot465.assignments

import io.github.deadshot465.shared.Question
import java.util.*

class K03 : Question {
    override fun question1() {
        print("年齢を入力してください。＞")
        val scanner = Scanner(System.`in`)
        val age = scanner.nextInt()
        if (age < 20) {
            println("未成年なので購入できません。")
        }
    }

    override fun question2() {
        print("身長を入力してください。＞")
        val scanner = Scanner(System.`in`)
        var height = scanner.nextDouble()
        print("体重を入力してください。＞")
        val weight = scanner.nextDouble()
        height /= 100.0
        val standard = height * height * 22.0
        println("あなたの標準体重は${standard}です。")

        if (weight > standard && (weight - standard) / standard * 100.0 > 14.0) {
            println("太り気味です。")
        } else if (weight < standard && (weight - standard) / standard * 100.0 < -14.0) {
            println("痩せ気味です。")
        } else {
            println("普通ですね。")
        }
    }

    override fun question3() {
        val n = kotlin.random.Random.nextInt(0, 100)
        println("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        val scanner = Scanner(System.`in`)
        val guess = scanner.nextInt()
        println("決められた数値は${n}です。")
        println(if (guess > n) {
            "正解です。"
        } else {
            "不正解です。"
        })
    }

    override fun question4() {
        val n = kotlin.random.Random.nextInt(0, 100)
        println("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        val scanner = Scanner(System.`in`)
        val guess = scanner.nextInt()
        println("決められた数値は${n}です。")

        println(when {
            guess !in 0..100 -> "反則です！"
            guess > n && (guess - n) <= 10 -> "大正解！"
            guess < n && (guess - n) >= -10 -> "惜しい！"
            guess == n -> "お見事！"
            else -> {
                if (guess > n) {
                    "正解です。"
                } else {
                    "不正解です。"
                }
            }
        })
    }
}