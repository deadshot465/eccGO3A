import java.lang.Exception
import java.util.*

class K02 : IExecutable() {

    override fun question_01() {
        val seisuu = 3
        val jissuu = 2.6f
        val moji = 'A'

        println("変数seisuuの値は${seisuu}")
        println("変数jissuuの値は${jissuu}")
        println("変数mojiの値は${moji}")
    }

    override fun question_02() {
        try {
            print("一つ目の整数は？")
            val reader = Scanner(System.`in`)
            val a = reader.nextInt()
            print("二つ目の整数は？")
            val b = reader.nextInt()

            println("$a÷$b=${a / b}...${a % b}")
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }

    override fun question_03() {
        try {
            print("一つ目の商品の値段は？")
            val reader = Scanner(System.`in`)
            val priceA = reader.nextInt()
            print("個数は？")
            val amountA = reader.nextInt()
            print("二つ目の商品の値段は？")
            val priceB = reader.nextInt()
            print("個数は？")
            val amountB = reader.nextInt()

            println(String.format("お支払いは税込み￥%dです", ((priceA * amountA + priceB * amountB) * 1.08f).toInt()))

        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_04() {
        try {
            val golem = Golem()

            println("ゴーレム　（HP:${golem.hp}　防御力：${golem.defense}）")
            println("HP：${golem.hp}")
            print("今回の攻撃の値を入力してください＞")
            val reader = Scanner(System.`in`)
            var atk = reader.nextInt()
            atk = if (atk - golem.defense > 0) atk - golem.defense else 0
            println("ダメージは${atk}です。")
            golem.hp -= atk
            println("残りのHPは${golem.hp}です。")
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }
}