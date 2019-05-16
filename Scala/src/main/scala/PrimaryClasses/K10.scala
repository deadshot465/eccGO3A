package PrimaryClasses
import IExecutable.IExecutable

class K10 extends IExecutable {
  override def Question1(): Unit = {
    print("文字列の入力＞")
    val inputString = scala.io.StdIn.readLine()
    printf("\n入力された文字列の文字数：%d", inputString.length)
  }

  override def Question2(): Unit = {
    val str = "STRINGcopy"
    printf("コピーしたい文字列：%s\n", str)
    val copyStr = str
    printf("コピー後の文字列：%s", copyStr)
  }

  override def Question3(): Unit = {
    val str = Array("abcdef", "GHIJKL", "13579")
    println("連結したい３つの文字列：")
    var strCombined = ""
    for (x <- str) {
      println(x)
      strCombined += x
    }
    printf("連結した文字列：%s", strCombined)
  }

  override def Question4(): Unit = {
    val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."
    var count = 0
    var _count = 0

    printf("文字列：%s\n\n", inputString)
    println("文字頻度")
    for (x <- alphabets) {
      for (y <- inputString) {
        if (x == y)
          count += 1
      }
      printf("%c: %d\t", x, count)
      count = 0
      _count += 1
      if (_count % 4 == 0)
        println()
    }
  }
}
