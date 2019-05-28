package PrimaryClasses

import IExecutable.IExecutable

import scala.collection.mutable
import scala.util.matching.Regex

class K11 extends IExecutable {
  override def Question1(): Unit = {
    var ages = mutable.MutableList[Float]()
    val MAX_PEOPLE = 5

    for (i <- 0 until MAX_PEOPLE) {
      printf("%d人目の年齢を入力して下さい：", i + 1)
      ages += scala.io.StdIn.readFloat()
    }

    val average = ages.sum / ages.length.toFloat
    printf("%d人の平均年齢は%f", ages.length, average)
  }

  override def Question2(): Unit = {
    print("1つ目の文字列を入力して下さい。＞")
    var str1 = scala.io.StdIn.readLine()
    print("2つ目の文字列を入力して下さい。＞")
    val str2 = scala.io.StdIn.readLine()
    str1 += str2
    printf("%sの文字数は%dです。\n", str1, str1.length)
  }

  override def Question3(): Unit = {
    print("文字を入力して下さい。＞")
    val chr = scala.io.StdIn.readChar()
    var applied = false
    if (chr.isDigit) {
      println("この文字は数字です。")
      applied = true
    }
    if (chr.isUpper) {
      println("この文字は英大文字です。")
      applied = true
    }
    if (chr.isLower) {
      println("この文字は英小文字です。")
      applied = true
    }
    var rx = raw"[A-Fa-f0-9]".r
    var result: Unit = rx.findFirstMatchIn(chr.toString) match {
      case Some(_) => {
        println("この文字は16進数として使える文字です。")
        applied = true
      }
      case None => ()
    }

    rx = new Regex("^(|.|,|!|\\?|:|;|\"|'|\\|-|(|))$")
    result = rx.findFirstMatchIn(chr.toString) match {
      case Some(_) => {
        println("この文字は区切り文字です。")
        applied = true
      }
      case None => ()
    }

    if (!applied) {
      println("この文字はよくわからない文字です。")
    }
  }

  override def Question4(): Unit = {
    val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val inputString = "I am a STUDENT. I am good at GAME PROGRAMMING."
    var count = 0
    var _count = 0

    printf("文字列：%s\n\n", inputString)
    println("文字頻度")
    for (x <- alphabets) {
      for (y <- inputString) {
        if (x == y.toUpper)
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
