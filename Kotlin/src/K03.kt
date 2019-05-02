import java.lang.Exception
import java.util.*

class K03 : IExectuable() {

    override fun question_01() {
        try {
            print("年齢を入力してください。＞")
            val reader = Scanner(System.`in`)
            val age = reader.nextInt()
            if (age < 20) {
                println("未成年なので購入できません。")
            }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_02() {
        try {
            print("身長を入力してください。＞")
            val reader = Scanner(System.`in`)
            var height = reader.nextDouble()
            print("体重を入力してください。＞")
            val weight = reader.nextDouble()
            height /= 100.0
            val standard = height * height * 22.0
            println("あなたの標準体重は${standard}です。")

            if (weight > standard && (weight - standard) / standard * 100 > 14) {
                println("太り気味です。")
            } else if (weight < standard && (weight - standard) / standard * 100 < -14) {
                println("痩せ気味です。")
            } else {
                println("普通ですね。")
            }
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }

    override fun question_03() {
        try {
            val randomNumber = Random()
            val n = randomNumber.nextInt(100)
            println("０から９９の範囲の数値が決定されました。")
            print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
            val reader = Scanner(System.`in`)
            val guess = reader.nextInt()
            println("決められた数値は${n}です。")

            println(if (guess > n) "正解です。" else "不正解です。")

        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_04() {
        try {
            val randomNumber = Random()
            val n = randomNumber.nextInt(100)
            println("０から９９の範囲の数値が決定されました。")
            print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
            val reader = Scanner(System.`in`)
            val guess = reader.nextInt()
            println("決められた数値は${n}です。")

            if (guess > 100 || guess < 0) {
                println("反則です！")
            } else if (guess > n && guess - n <= 10) {
                println("大正解！")
            } else if (guess < n && guess - n >= -10) {
                println("惜しい！")
            } else if (guess == n) {
                println("お見事！")
            } else {
                println(if (guess > n) "正解です。" else "不正解です。")
            }
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }
}