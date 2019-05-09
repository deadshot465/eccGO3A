package PrimaryClasses
import IExecutable.IExecutable
import K08_1sub.GetMaxValue
import K08_1sub.GetMinValue
import K08_2sub.AttackGolem

import scala.collection.mutable
import scala.util.Random

class K08 extends IExecutable {
  override def Question1(): Unit = {
    var numbers = mutable.MutableList[Int]()
    try {
      for (i <- 1 to 3) {
        printf("%dつ目の値を入力してください。＞", i)
        numbers += scala.io.StdIn.readInt()
      }
      println("どちらを調べますか？")
      print("（０：最大値　１：最小値）＞")
      val choice = scala.io.StdIn.readInt()
      choice match {
        case 0 => printf("%dの中で最大値は%dです。", numbers.length, GetMaxValue(numbers.head, numbers(1), numbers(2)))
        case 1 => printf("%dの中で最小値は%dです。", numbers.length, GetMinValue(numbers.head, numbers(1), numbers(2)))
        case _ => ()
      }
    } catch {
      case ex: Exception => System.err.println(ex.getMessage)
    }
  }

  override def Question2(): Unit = {
    try {
      println("冒険が今始まる！")
      var playerHp = 200 + Random.nextInt(101)
      var continueGame = 1
      while (continueGame != 0) {
        if (playerHp == 0)
          return

        printf("あなたのHP：%d\n", playerHp)
        print("奥に進みますか？（１：奥に進む　０．帰る）＞")
        continueGame = scala.io.StdIn.readInt()
        if (continueGame == 1) {
          val golemLv = Random.nextInt(5)
          playerHp = AttackGolem(golemLv, playerHp)
        }
      }
      println("リレ〇ト！")
    } catch {
      case ex: Exception => System.err.println(ex.getMessage)
    }
  }

  override def Question3(): Unit = {

  }

  override def Question4(): Unit = {

  }
}
