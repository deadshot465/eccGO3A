import java.lang.Exception
import java.util.*

fun showSelection(chapter: Int) {
    for (i: Int in 1..4)
    {
        println("\t$i) K0${chapter}_$i")
    }
}

fun main()
{
    var choice: Int
    var choice2: Int

    val executables = Vector<IExectuable>()
    executables.add(K01())
    executables.add(K02())
    executables.add(K03())
    executables.add(K04())
    executables.add(K05())
    executables.add(K06())

    println("実行したいプログラムを選択してください。")
    for (i: Int in 1..6)
    {
        println("$i) K0$i")
    }

    try {
        val reader = Scanner(System.`in`)
        choice = reader.nextInt()

        if (choice < 1 || choice > 6)
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