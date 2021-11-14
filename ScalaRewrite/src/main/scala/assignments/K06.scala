package assignments

import shared.Question

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

case class K06()

object K06 extends Question:
  override def question1(): Unit =
    val ages = ArrayBuffer.empty[Float]
    for
      i <- 0 to 4
    do
      print(s"${i + 1}人目の年齢を入力して下さい：")
      ages += StdIn.readFloat()

    val average = ages.sum / ages.length
    println(s"${ages.length}人の平均年齢は${average}です。")

  override def question2(): Unit =
    for i <- 1 to 8 do
      for _ <- 1 to i do
        print("*")
      println()
    println()

    for i <- 8 to 1 by -1 do
      for _ <- 1 to i do
        print("*")
      println()
    println()

    for i <- 8 to 1 by -1 do
      for _ <- 1 to (i - 1) do
        print(" ")

      for _ <- i to 8 do
        print("*")
      println()

  override def question3(): Unit =
    val total = 370
    var count = 0
    for
      i <- 0 to (total / 100)
      j <- 0 to (total / 50)
      k <- 0 to (total / 10)
    do
      if i * 100 + j * 50 + k * 10 == total then
        println(s"10円の硬貨${k}枚 50円の硬貨${j}枚 100円の硬貨${i}枚")
        count += 1
    println(s"以上${count}通りを発見しました。")

  override def question4(): Unit =
    print("\t|\t")
    for
      i <- 1 to 9
    do
      print(s"${i}\t")
    println()
    println(Seq.fill(75)('-').mkString(""))
    for
      i <- 1 to 9
    do
      print(s"${i}\t|\t")
      for
        j <- 1 to 9
      do
        print(s"${i * j}\t")
      println()