package assignments

import shared.Question

import scala.io.StdIn

case class K10()

object K10 extends Question:
  override def question1(): Unit =
    print("文字列の入力＞")
    val str = StdIn.readLine().trim
    println(s"入力された文字列の文字数：${str.length}")

  override def question2(): Unit =
    val str = "STRINGcopy"
    println(s"コピーしたい文字列：$str")
    val str2 = str
    println(s"コピー後の文字列：$str2")

  override def question3(): Unit =
    val strs = Seq("abcdef", "GHIJKL", "13579")
    println("連結したい３つの文字列：")
    strs.foreach(s => print(s"${s} "))
    println()
    println("連結した文字列：")
    println(strs.mkString(""))

  override def question4(): Unit =
    val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."
    println(s"文字列：$inputString")
    println("文字頻度")
    val frequencies = alphabets
      .map(c => (c, inputString.count(i => i == c)))
      .foreach(item => println(s"${item._1}: ${item._2}"))