import java.lang.Exception
import java.util.*

class K04 : IExecutable() {

    override fun question_01() {
        try {
            print("年齢を入力してください。＞")
            val reader = Scanner(System.`in`)
            val age = reader.nextInt()

            if (age < 3 || age >= 70) {
                println("入場料金無料です。")
            } else {
                println("通常料金です。")
            }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_02() {
        try {
            print("性別を選択してください。（０：男性　１：女性）＞")
            val reader = Scanner(System.`in`)
            val gender = reader.nextInt()

            when (gender) {
                0 -> println("あら、格好良いですね。")
                1 -> println("あら、モデルさんみたいですね。")
                else -> println("そんな選択肢はありません。")
            }
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }

    override fun question_03() {
        try {
            print("年齢を入力してください。＞")
            val reader = Scanner(System.`in`)
            val age = reader.nextInt()

            if (age < 3 || age >= 70) {
                println("入場料金無料です。")
            } else if (age in 3..15) {
                println("子供料金で半額です。")
            } else if (age in 60..69) {
                println("シニア割引で一割引きです。")
            } else {
                println("通常料金です。")
            }

        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_04() {
        try {
            println("＊＊＊おみくじプログラム＊＊＊")
            print("おみくじを引きますか　（はい：１　いいえ：０）　＞")
            val reader = Scanner(System.`in`)
            val choice = reader.nextInt()

            if (choice >= 1) {
                val oracle = (0..4).random()
                when (oracle) {
                    0 -> println("大吉　とってもいいことがありそう！！")
                    1 -> println("中吉　きっといいことあるんじゃないかな")
                    2 -> println("小吉　少しぐらいはいいことあるかもね")
                    3 -> println("凶　今日はおとなしくておいた方がいいかも")
                    4 -> println("大凶　これじゃやばくない？早く家に帰った方がいいかも")
                    else -> {
                    }
                }
            }
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }
}