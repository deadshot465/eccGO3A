import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

data class Person(var Name: String = "", var BirthYear: Int = 0, var Height: Float = 0.0f, var Weight: Float = 0.0f)
data class Staff(val Name: String, val Gender: Char, val Age: Int)
data class Position(var X: Int, var Y: Int, var Distance: Double = 0.0)

class K12 : IExecutable() {
    override fun question_01() {
        val person = Person()
        print("名前を入力してください＞")
        val reader = Scanner(System.`in`)
        person.Name = reader.nextLine()
        print("生年（西暦）を入力してください＞")
        person.BirthYear = reader.nextInt()
        print("身長を入力してください＞")
        person.Height = reader.nextFloat()
        print("体重を入力してください＞")
        person.Weight = reader.nextFloat()

        println("プロファイル")
        println("名前：${person.Name}")
        println("生年：${person.BirthYear}")
        println("身長：${person.Height}")
        println("体重：${person.Weight}")
    }

    override fun question_02() {
        val staffs = arrayOf(
            Staff("神木隆之介", 'M', 23),
            Staff("上白石萌音", 'F', 18),
            Staff("長澤まさみ", 'F', 28)
            )

        println("名前\t\t性別\t年齢")
        for (x in 1..35) {
            print('-')
        }
        println()

        for (staff in staffs) {
            println("${staff.Name}\t${staff.Gender}\t${staff.Age}歳")
        }
    }

    fun getDistance(playerPos: Position, enemyPos: Position): Double {
        val diffX = playerPos.X - enemyPos.X
        val diffY = playerPos.Y - enemyPos.Y
        return sqrt((diffX * diffX + diffY * diffY).toDouble())
    }

    override fun question_03() {
        val getRandomNumber: () -> Int = { Random.nextInt(100) - 50 }
        val playerPos = Position(getRandomNumber(), getRandomNumber())
        val enemyPos = arrayOfNulls<Position>(5)
        for (x in 0..4) {
            enemyPos[x] = Position(
                getRandomNumber(),
                getRandomNumber()
            )
            enemyPos[x]!!.Distance = getDistance(playerPos, enemyPos[x]!!)
        }

        println("プレーヤーの座標：x= ${playerPos.X}\t\ty= ${playerPos.Y}")
        for ((i, pos) in enemyPos.requireNoNulls().withIndex()) {
            val str = String.format("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f",
                i, pos.X.toFloat(), pos.Y.toFloat(), pos.Distance)
            println(str)
        }

    }

    override fun question_04() {
        val getRandomNumber: () -> Int = { Random.nextInt(100) - 50 }
        val playerPos = Position(getRandomNumber(), getRandomNumber())
        val enemyPos = arrayOfNulls<Position>(5)
        for (x in 0..4) {
            enemyPos[x] = Position(
                getRandomNumber(),
                getRandomNumber()
            )
            enemyPos[x]!!.Distance = getDistance(playerPos, enemyPos[x]!!)
        }

        println("プレーヤーの座標：x= ${playerPos.X}\t\ty= ${playerPos.Y}")
        for ((i, pos) in enemyPos.requireNoNulls().withIndex()) {
            val str = String.format("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f",
                i, pos.X.toFloat(), pos.Y.toFloat(), pos.Distance)
            println(str)
        }

        println("\n並び替え後")
        enemyPos.requireNoNulls().sortBy {
            it.Distance
        }
        for ((i, pos) in enemyPos.requireNoNulls().withIndex()) {
            val str = String.format("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f",
                i, pos.X.toFloat(), pos.Y.toFloat(), pos.Distance)
            println(str)
        }
    }

}