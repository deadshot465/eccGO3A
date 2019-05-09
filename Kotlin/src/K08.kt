import java.util.*
import kotlin.random.Random

class K08 : IExecutable() {
    override fun question_01() {
        val numbers = Vector<Int>()
        val reader = Scanner(System.`in`)
        try {
            for (i in 1..3) {
                print("${i}つ目の値を入力してください。＞")
                numbers.add(reader.nextInt())
            }
            println("どちらを調べますか？")
            print("（０：最大値　１：最小値）＞")
            val choice = reader.nextInt()
            when (choice) {
                0 -> println("${numbers.size}の中で最大値は${GetMaxValue(numbers[0], numbers[1], numbers[2])}です。")
                1 -> println("${numbers.size}の中で最小値は${GetMinValue(numbers[0], numbers[1], numbers[2])}です。")
            }
        } catch (ex: Exception) {
            System.err.println(ex.message)
        }
    }

    override fun question_02() {
        try {
            println("冒険が今始まる！")
            var playerHp = 200 + Random.nextInt(100)
            var continueGame = 1
            val reader = Scanner(System.`in`)
            while (continueGame != 0) {
                if (playerHp == 0)
                    return
                println("あなたのHP：$playerHp")
                print("奥に進みますか？（１：奥に進む　０．帰る）＞")
                continueGame = reader.nextInt()
                if (continueGame == 1) {
                    val golemLv = Random.nextInt(1, 4)
                    playerHp = AttackGolem(golemLv, playerHp)
                }
            }
            println("リレ〇ト！")
        } catch (ex: java.lang.Exception) {
            System.err.println(ex.message)
        }
    }

    override fun question_03() {
        return
    }

    override fun question_04() {
        return
    }
}