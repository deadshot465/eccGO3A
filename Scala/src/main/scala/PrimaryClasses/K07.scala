package PrimaryClasses
import IExecutable.IExecutable

import scala.collection.mutable

class K07 extends IExecutable {

  def ShowText(): Unit = {
    println("Hello World!")
    println("ようこそ")
    println("Scala言語の世界へ！")
  }

  def GetMaxValue(value1: Int, value2: Int, value3: Int): Int = {
    var temp = if (value1 >= value2) value1 else value2
    temp = if (temp >= value3) temp else value3
    temp
  }

  def GetType(age: Int): Int = {
    age match {
      case x if x <= 0 => 0
      case x if x < 3 || x >= 70 => 1
      case x if x >= 3 && x <= 15 => 2
      case x if x >= 60 && x < 70 => 3
      case _ => 4
    }
  }

  override def Question1(): Unit = {
    var choice = 0
    do {
      print("メッセージを表示しますか？（０：終了する　１：表示する）＞")
      choice = scala.io.StdIn.readInt()
      if (choice == 1) {
        ShowText()
      }
    } while (choice != 0)
    println("終了します。")
  }

  override def Question2(): Unit = {
    var numbers = mutable.MutableList[Int]()
    for (i <- 1 to 3) {
      printf("%dつ目の値を入力してください。＞", i)
      numbers += scala.io.StdIn.readInt()
    }
    val maxValue = GetMaxValue(numbers.head, numbers(1), numbers(2))
    printf("%dつの中で最大値は%dです。\n", numbers.length, maxValue)
  }

  override def Question3(): Unit = {
    var age: Int = 0
    var no: Int = 0
    printf("年齢を入力して下さい。＞")
    age = scala.io.StdIn.readInt()

    no = GetType(age)
    no match {
      case 0 => println("不適切な値が入力されました。")
      case 1 => println("入場料金無料です。")
      case 2 => println("子供料金で半額です。")
      case 3 => println("シニア割引で一割引きです。")
      case _ => println("通常料金です。")
    }
  }

  override def Question4(): Unit = {

  }
}
