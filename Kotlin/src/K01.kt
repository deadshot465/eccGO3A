class K01 : IExectuable() {

    override fun question_01() {
        println("Hello World! ようこそKotlin言語の世界へ！")
    }

    override fun question_02() {
        println("Hello World!")
        println("ようこそ")
        println("Kotlin言語の世界へ！")
    }

    override fun question_03() {
        println(String.format("整数：%d", 12345))
        println(String.format("実数：%f", 123.456789))
        println(String.format("文字：%c", 'A'))
        println(String.format("文字列：%s", "ABCdef"))
    }

    override fun question_04() {
        println("              ##")
        println("             #  #")
        println("             #  #")
        println("            #    #")
        println("           #      #")
        println("         ##        ##")
        println("       ##            ##")
        println("    ###                ###")
        println(" ###       ##    ##       ###")
        println("##        #  #  #  #        ##")
        println("##         ##    ##         ##")
        println(" ##     #            #     ##")
        println("  ###     ##########     ###")
        println("     ###              ###")
        println("        ##############")
    }
}