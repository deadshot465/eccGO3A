import java.util.*
import java.util.regex.Pattern

class K11 : IExecutable() {
    override fun question_01() {
        val ages = Vector<Int>()
        val max_people = 5

        val reader = Scanner(System.`in`)
        for (i in 0 until max_people) {
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
        print("1つ目の文字列を入力して下さい。＞")
        val reader = Scanner(System.`in`)
        var str1 = reader.nextLine()
        print("2つ目の文字列を入力して下さい。＞")
        val str2 = reader.nextLine()
        str1 += str2
        println("${str1}の文字数は${str1.length}です。")
    }

    override fun question_03() {
        val chr: Char
        print("文字を入力して下さい。＞")
        val reader = Scanner(System.`in`)
        chr = reader.nextLine()[0]
        var applied = false

        if (chr.isDigit()) {
            println("この文字は数字です。")
            applied = true
        }
        if (chr.isUpperCase()) {
            println("この文字は英大文字です。")
            applied = true
        }
        if (chr.isLowerCase()) {
            println("この文字は英小文字です。")
            applied = true
        }
        var pattern = Pattern.compile("^[A-Fa-f0-9]$")
        var matcher = pattern.matcher(chr.toString())
        if (matcher.matches()) {
            println("この文字は16進数として使える文字です。")
            applied = true
        }
        pattern = Pattern.compile("^(.|,|!|\\?|:|;|\"|'|\\|-|\\(|\\))$")
        matcher = pattern.matcher(chr.toString())
        if (matcher.matches()) {
            println("この文字は区切り文字です。")
            applied = true
        }

        if (!applied) {
            println("この文字はよくわからない文字です。")
        }
    }

    override fun question_04() {
        val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val inputString = "I am a STUDENT. I am good at GAME PROGRAMMING."
        var count = 0
        var _count = 0
        println("文字列：${inputString}\n")
        println("文字頻度")
        for (s in alphabets) {
            for (_s in inputString) {
                if (s == _s.toUpperCase())
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