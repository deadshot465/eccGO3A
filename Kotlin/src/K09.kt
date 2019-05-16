import java.util.*

class K09 : IExecutable() {
    override fun execute(num: Int) {
        when (num) {
            1 -> question_01()
            2 -> question_02()
            3 -> question_03()
            4 -> question_04()
            5 -> question_05()
        }
    }

    override fun question_01() {
        val ages = IntArray(3)
        val reader = Scanner(System.`in`)
        for (i in 0..2) {
            print("${i + 1}人目の年齢を入力＞")
            ages[i] = reader.nextInt()
        }

        for (i in 1..20) {
            print("-")
        }
        println()

        for ((index, value) in ages.withIndex()) {
            println("${index + 1}人目：${value}歳。")
        }

        println("平均年齢：%.1f歳。".format(ages.average()))
    }

    override fun question_02() {
        val numbers: IntArray = intArrayOf(8, 3, 12, 7, 9)
        print("元々の配列：")
        for (num in numbers) {
            print("$num ")
        }
        println()
        print("逆順での表示：")
        for (num in numbers.reversedArray()) {
            print("$num ")
        }
    }

    override fun question_03() {
        val studentScores = arrayOf(arrayOf(52, 71, 61, 47), arrayOf(6, 84, 81, 20), arrayOf(73, 98, 94, 95))
        println("\t\t|\t科目A\t科目B\t科目C\t科目D")

        for (i in 1..45) {
            print("-")
        }
        println()

        for ((index, student) in studentScores.withIndex()) {
            print("学生${index + 1}\t|\t")
            for (score in student) {
                print("$score\t\t")
            }
            println()
        }
    }

    override fun question_04() {
        val studentScores = arrayOf(arrayOf(52, 71, 61, 47), arrayOf(6, 84, 81, 20), arrayOf(73, 98, 94, 95))
        println("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点")
        var total = 0
        val average = FloatArray(4)

        for (i in 1..65) {
            print("-")
        }
        println()

        for ((index, student) in studentScores.withIndex()) {
            print("学生${index + 1}\t|\t")
            for ((index2, score) in student.withIndex()) {
                print("$score\t\t")
                total += score
                average[index2] = average[index2] + score
            }
            print("|\t$total")
            total = 0
            println()
        }
        print("平均点\t|\t")
        for (num in average) {
            print("%.1f\t".format(num / 3.0))
        }
        println("|")
    }

    fun question_05() {
        var count = 0
        var numbers = IntArray(100)
        val reader = Scanner(System.`in`)
        for (i in 0 until numbers.size) {
            print("${i + 1}件目の入力：")
            numbers[i] = reader.nextInt()
            if (numbers[i] < 0)
                break
            count++
        }

        println("----並び替え後----")

        for (num in numbers.take(count).sorted()) {
            println(num)
        }
    }
}