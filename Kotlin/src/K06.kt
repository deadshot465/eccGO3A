import java.lang.Exception
import java.util.*

class K06 : IExectuable() {

    override fun question_01() {
        val ages = Vector<Int>()

        val reader = Scanner(System.`in`)
        for (i in 0..4) {
            print("${i + 1}人目の年齢を入力して下さい：")
            ages.add(reader.nextInt())
        }

        val _average = ages.stream().mapToDouble { x -> x.toDouble() }.average()
        var average = 0.0
        if (_average.isPresent) {
            average = _average.asDouble
        }

        println("${ages.size}人の平均年齢は${average}です。")
    }

    override fun question_02() {
        for (i in 0..8) {
            for (j in 0 until i + 1) {
                print("*")
            }
            println()
        }
        println()

        for (i in 9 downTo 1) {
            for (j in 0 until i) {
                print("*")
            }
            println()
        }
        println()

        for (i in 9 downTo 1) {
            for (j in 0 until i - 1) {
                print(" ")
            }

            for (k in 9 downTo i) {
                print("*")
            }
            println()
        }
        println()
    }

    override fun question_03() {
        val total = 370
        var count = 0

        for (i in 0..total / 100) {
            for (j in 0..total / 50) {
                for (k in 0..total / 10) {
                    if (100 * i + 50 * j + 10 * k == total) {
                        println("10円の硬貨${k}枚 50円の硬貨${j}枚 100円の硬貨${i}枚")
                        count++
                    }
                }
            }
        }

        println("\n以上${count}通りを発見しました。")
    }

    override fun question_04() {
        print("\t|\t")
        for (i in 1..9) {
            print("$i\t")
        }
        println()

        for (i in 0..74) {
            print("-")
        }
        println()

        for (i in 1..9) {
            print("$i\t|\t")
            for (j in 1..9) {
                print("${i * j}\t")
            }
            println()
        }
    }
}