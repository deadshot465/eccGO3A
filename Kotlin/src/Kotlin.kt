import java.lang.Exception
import java.util.*

fun showSelection(chapter: Int) {
    if  (chapter < 10) {
        for (i: Int in 1..4) {
            println("\t$i) K0${chapter}_$i")
        }
        if (chapter == 9) {
            println("\t5) K0${chapter}_5")
        }
    } else {
        val addedNumber = if (chapter >= 12) {
            chapter + 3
        } else {
            chapter
        }
        for (i: Int in 1..4) {
            println("\t$i) K${addedNumber}_$i")
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
        K11(), K12(), FileControl()
        )

    println("実行したいプログラムを選択してください。")
    for (i: Int in 1 until executables.size + 1)
    {
        if (i < 10) {
            println("$i) K0$i")
        }
        else {
            val addedNumber = if (i >= 12) {
                i + 3
            } else {
                i
            }
            println("$i) K$addedNumber")
        }
    }
    println("100) Kex")
    println("101) Kex_2")
    println("102) Sort")

    try {
        val reader = Scanner(System.`in`)
        choice = reader.nextInt()

        if (choice == 100) {
            val kex = Kex()
            kex.execute()
            return
        } else if (choice == 101) {
            Kex_2.Execute()
            return
        } else if (choice == 102) {
            val sort = Sort()
            sort.execute()
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