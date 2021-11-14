package assignments.k08

import shared.Question

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random

case class K08()

object K08 extends Question:
  override def question1(): Unit =
    val numbers = ArrayBuffer.empty[Int]
    for
      i <- 1 to 3
    do
      print(s"${i}つ目の値を入力してください。＞")
      numbers += StdIn.readInt()

    println("どちらを調べますか？")
    print("（０：最大値　１：最小値）＞")
    val choice = StdIn.readInt()
    val result = choice match
      case 0 => s"${numbers.length}の中で最大値は${numbers.max}です。"
      case 1 => s"${numbers.length}の中で最小値は${numbers.min}です。"
      case _ => ""
    println(result)

  override def question2(): Unit =
    println("冒険が今始まる！")
    val playerHp = 200 + Random.between(0, 101)
    println(gameLoop(playerHp))

  override def question3(): Unit =
    ()

  override def question4(): Unit =
    ()