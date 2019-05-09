import java.util.*

class K07 : IExecutable() {
    private fun show_text() {
        println("Hello World!")
        println("ようこそ")
        println("Kotlin言語の世界へ！")
    }

    private fun get_max_value(value1: Int, value2: Int, value3: Int): Int {
        var temp = if (value1 >= value2) value1 else value2
        temp = if (temp > value3) temp else value3
        return temp
    }

    private fun get_type(age: Int): Int {
        return when {
            (age <= 0) -> 0
            (age < 3 || age >= 70) -> 1
            (age in 3..15) -> 2
            (age in 60..69) -> 3
            else -> 4
        }
    }

    override fun question_01() {
        var choice: Int
        do {
            print("メッセージを表示しますか？（０：終了する　１：表示する）＞")
            val reader = Scanner(System.`in`)
            choice = reader.nextInt()
            if (choice == 1)
                show_text()
        } while (choice != 0)
        println("終了します。")
    }

    override fun question_02() {
        val numbers = Vector<Int>()
        val reader = Scanner(System.`in`)
        for (i in 1..3) {
            print("${i}つ目の値を入力してください。＞")
            numbers.add(reader.nextInt())
        }
        val max_value = get_max_value(numbers[0], numbers[1], numbers[2])
        println("${numbers.size}つの中で最大値は${max_value}です。")
    }

    override fun question_03() {
        val age: Int
        val no: Int
        print("年齢を入力して下さい。＞")
        val reader = Scanner(System.`in`)
        age = reader.nextInt()

        no = get_type(age)
        when (no) {
            0 -> println("不適切な値が入力されました。")
            1 -> println("入場料金無料です。")
            2 -> println("子供料金で半額です。")
            3 -> println("シニア割引で１割引きです。")
            else -> println("通常料金です。")
        }
    }

    override fun question_04() {
        return
    }
}