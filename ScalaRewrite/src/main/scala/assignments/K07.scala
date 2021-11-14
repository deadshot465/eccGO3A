package assignments

import shared.Question

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

enum AgeTier(val msg: String):
  case Invalid extends AgeTier("不適切な値が入力されました。")
  case Free extends AgeTier("入場料金無料です。")
  case Half extends AgeTier("子供料金で半額です。")
  case TenPercentOff extends AgeTier("シニア割引で一割引きです。")
  case Normal extends AgeTier("通常料金です。")

case class K07()

object K07 extends Question:
  override def question1(): Unit =
    var choice = 1
    while choice != 0 do
      print("メッセージを表示しますか？（０：終了する　１：表示する）＞")
      choice = StdIn.readInt()
      if choice == 1 then
        showText()
      else
        ()
    println("終了します。")

  override def question2(): Unit =
    val numbers = ArrayBuffer.empty[Int]
    for
      i <- 1 to 3
    do
      print(s"${i}つ目の値を入力してください。＞")
      numbers += StdIn.readInt()
    val maxValue = numbers.max
    println(s"${numbers.length}つの中で最大値は${maxValue}です。")

  override def question3(): Unit =
    print("年齢を入力して下さい。＞")
    val age = StdIn.readInt()
    println(getAgeTier(age).msg)

  override def question4(): Unit =
    ()

  private def showText(): Unit =
    println("Hello World!");
    println("ようこそ");
    println("Scala 3言語の世界へ！");

  private def getAgeTier(age: Int): AgeTier =
    age match
      case x if x <= 0 => AgeTier.Invalid
      case x if x < 3 || x >= 70 => AgeTier.Free
      case x if x >= 3 && x <= 15 => AgeTier.Half
      case x if x >= 60 && x < 70 => AgeTier.TenPercentOff
      case _ => AgeTier.Normal