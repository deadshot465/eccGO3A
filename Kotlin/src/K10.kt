import java.lang.StringBuilder
import java.util.*

class K10 : IExecutable() {
    override fun question_01() {
        print("文字列の入力＞")
        val reader = Scanner(System.`in`)
        val inputString = reader.nextLine()
        println("入力された文字列の文字数：${inputString.length}")
    }

    override fun question_02() {
        val str = "STRINGcopy"
        println("コピーしたい文字列：$str")
        val copyStr = str
        println("コピー後の文字列：$copyStr")
    }

    override fun question_03() {
        val str = arrayOf("abcdef", "GHIJKL", "13579")
        val builder = StringBuilder()
        println("連結したい３つの文字列：")
        for (s in str) {
            println(s)
            builder.append(s)
        }

        println("連結した文字列：$builder")
    }

    override fun question_04() {
        val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."
        var count = 0
        var _count = 0
        println("文字列：${inputString}\n")
        println("文字頻度")
        for (s in alphabets) {
            for (_s in inputString) {
                if (s == _s)
                    count++
            }
            print("${s}: ${count}\t")
            count = 0
            _count++
            if (_count % 4 == 0)
                println()
        }
    }

}