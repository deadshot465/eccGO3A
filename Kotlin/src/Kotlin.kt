import java.lang.Exception
import java.util.*

fun showSelection(chapter: Int) {
    for (i: Int in 1..4)
    {
        if (chapter < 10) {
            println("\t$i) K0${chapter}_$i")
            if (chapter == 9) {
                println("\t5) K0${chapter}_5")
            }
        }
        else {
            println("\t$i) K${chapter}_$i")
        }
    }
}

fun main()
{
    val choice: Int
    val choice2: Int

    val executables = arrayOf(
        K01(), K02(), K03(), K04(), K05(),
        K06(), K07(), K08(), K09(), K10(),
        K11(), FileControl()
        )

    println("実行したいプログラムを選択してください。")
    for (i: Int in 1 until executables.size + 1)
    {
        if (i < 10) {
            println("$i) K0$i")
        }
        else {
            println("$i) K$i")
        }
    }
    println("100) Kex")

    try {
        val reader = Scanner(System.`in`)
        choice = reader.nextInt()

        if (choice == 100) {
            val kex = Kex()
            kex.execute()
            return
        }

        if (choice < 1 || choice > executables.size)
        {
            throw Exception("無効の選択です。")
        }

        showSelection(choice)

        choice2 = reader.nextInt()
        executables[choice - 1].execute(choice2)
    }
    catch (ex: Exception)
    {
        println(ex.message)
    }
}