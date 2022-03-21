package io.github.deadshot465.assignments

import io.github.deadshot465.shared.Question
import java.util.*

class K04 : Question {
    override fun question1() {
        print("年齢を入力してください。＞")
        val scanner = Scanner(System.`in`)
        val age = scanner.nextInt()
        println(if (age < 3 || age >= 70) {
            "入場料金無料です。"
        } else {
            "通常料金です。"
        })
    }

    override fun question2() {
        print("性別を選択してください。（０：男性　１：女性）＞")
        val scanner = Scanner(System.`in`)
        val gender = scanner.nextInt()
        println(when (gender) {
            0 -> "あら、格好良いですね。"
            1 -> "あら、モデルさんみたいですね。"
            else -> "そんな選択肢はありません。"
        })
    }

    override fun question3() {
        print("年齢を入力してください。＞")
        val scanner = Scanner(System.`in`)
        val age = scanner.nextInt()
        println(if (age < 3 || age >= 70) {
            "入場料金無料です。"
        } else {
            "通常料金です。"
        })
    }

    override fun question4() {
        println("＊＊＊おみくじプログラム＊＊＊")
        print("おみくじを引きますか　（はい：１　いいえ：０）　＞")
        val scanner = Scanner(System.`in`)
        val choice = scanner.nextInt()

        if (choice == 0) {
            return
        }

        val oracle = kotlin.random.Random.nextInt(0, 5)
        println(
            when (oracle) {
                0 -> "大吉　とってもいいことがありそう！！"
                1 -> "中吉　きっといいことあるんじゃないかな"
                2 -> "小吉　少しぐらいはいいことあるかもね"
                3 -> "凶　今日はおとなしくておいた方がいいかも"
                4 -> "大凶　これじゃやばくない？早く家に帰った方がいいかも"
                else -> ""
            }
        )
    }
}