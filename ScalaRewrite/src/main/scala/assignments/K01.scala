package assignments

import shared.Question

case class K01()

object K01 extends Question:
  override def question1(): Unit =
    println("Hello World!　ようこそScala 3言語の世界へ！")

  override def question2(): Unit =
    println("Hello World!")
    println("ようこそ")
    println("Scala 3言語の世界へ！")

  override def question3(): Unit =
    println(s"整数：${12345}")
    println(s"実数：${123.456789}")
    println(s"文字：${'A'}")
    println(s"文字列：${"ABCdef"}")

  override def question4(): Unit =
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