package PrimaryClasses
import IExecutable.IExecutable

class K01 extends IExecutable {
  override def Question1(): Unit = {
    println("Hello World!　ようこそScala言語の世界へ！")
  }

  override def Question2(): Unit = {
    println("Hello World!")
    println("ようこそ")
    println("Scala言語の世界へ！")
  }

  override def Question3(): Unit = {
    printf("整数：%d\n", 12345)
    printf("実数：%f\n", 123.456789)
    printf("文字：%c\n", 'A')
    printf("文字列：%s\n", "ABCdef")
  }

  override def Question4(): Unit = {
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
