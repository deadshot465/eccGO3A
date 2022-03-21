package io.github.deadshot465.assignments

import io.github.deadshot465.shared.Golem
import io.github.deadshot465.shared.Question
import java.util.*
import kotlin.math.max


class K02 : Question {
    override fun question1() {
        val seisuu = 3
        val jissuu = 2.6f
        val moji = 'A'
        println("変数seisuuの値は$seisuu")
        println("変数jissuuの値は$jissuu")
        println("変数mojiの値は$moji")
    }

    override fun question2() {
        print("一つ目の整数は？")
        val scanner = Scanner(System.`in`)
        val a = scanner.nextInt()
        print("二つ目の整数は？")
        val b = scanner.nextInt()
        println("${a}÷${b}=${a / b}...${a % b}")
    }

    override fun question3() {
        print("一つ目の商品の値段は？")
        val scanner = Scanner(System.`in`)
        val priceA = scanner.nextInt()
        print("個数は？")
        val amountA = scanner.nextInt()
        print("二つ目の商品の値段は？")
        val priceB = scanner.nextInt()
        print("個数は？")
        val amountB = scanner.nextInt()

        System.out.printf("お支払いは税込み￥%dです\n", ((priceA * amountA + priceB * amountB) * 1.1f).toInt())
    }

    override fun question4() {
        val golem = Golem(300, 80, 50)
        println("ゴーレム　（HP:${golem.hp}　防御力：${golem.defense}）")
        println("HP：" + golem.hp)
        print("今回の攻撃の値を入力してください＞")
        val scanner = Scanner(System.`in`)
        var atk = scanner.nextInt()
        atk = max(atk - golem.defense, 0)
        println("ダメージは${atk}です")

        golem.hp -= atk
        println("残りのHPは${golem.hp}です")
    }
}