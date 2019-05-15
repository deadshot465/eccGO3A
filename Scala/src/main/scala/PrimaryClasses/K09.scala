package PrimaryClasses

import IExecutable.IExecutable
import scala.util.control.Breaks

class K09 extends IExecutable {
  override def Execute(num: Int): Unit = {
    num match {
      case 1 => Question1()
      case 2 => Question2()
      case 3 => Question3()
      case 4 => Question4()
      case 5 => Question5()
    }
  }

  override def Question1(): Unit = {
    val ages = new Array[Int](3)
    for (i <- 0 to 2) {
      printf("%d人目の年齢を入力＞", i + 1)
      ages(i) = scala.io.StdIn.readInt()
    }

    for (_ <- 1 to 20) {
      print("-")
    }
    println()

    for (i <- ages.indices) {
      printf("%d人目：%d歳。\n", i + 1, ages(i))
    }

    printf("平均年齢：%.1f歳。\n", ages.sum / ages.length.toFloat)
  }

  override def Question2(): Unit = {
    val numbers = Array(8, 3, 12, 7, 9)
    print("元々の配列：")
    for (num <- numbers) {
      printf("%d ", num)
    }
    println()

    print("逆順での表示：")
    for (num <- numbers.reverse) {
      printf("%d ", num)
    }
  }

  override def Question3(): Unit = {
    val studentScores = Array(Array(52, 71, 61, 47), Array(6, 84, 81, 20), Array(73, 98, 94, 95))
    println("\t\t|\t科目A\t科目B\t科目C\t科目D")

    for (_ <- 1 to 45) {
      print("-")
    }
    println()

    for (i <- studentScores.indices) {
      printf("学生%d\t|\t", i + 1)
      for (score <- studentScores(i)) {
        printf("%d\t\t", score)
      }
      println()
    }
  }

  override def Question4(): Unit = {
    val studentScores = Array(Array(52, 71, 61, 47), Array(6, 84, 81, 20), Array(73, 98, 94, 95))
    println("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点")

    var total = 0
    var average = Array(0.0f, 0.0f, 0.0f, 0.0f)

    for (_ <- 1 to 65) {
      print("-")
    }
    println()

    for (i <- studentScores.indices) {
      printf("学生%d\t|\t", i + 1)
      for (j <- studentScores(i).indices) {
        printf("%d\t\t", studentScores(i)(j))
        total += studentScores(i)(j)
        average(j) += studentScores(i)(j)
      }
      printf("|\t%d", total)
      total = 0
      println()
    }
    printf("平均点\t|\t")
    for (score <- average) {
      printf("%.1f\t", score / 3.0f)
    }
    println("|")
  }

  def Question5() : Unit = {
    var count = 0
    var numbers = new Array[Int](100)
    Breaks.breakable {
      for (i <- numbers.indices) {
        printf("%d件目の入力：", i + 1)
        numbers(i) = scala.io.StdIn.readInt()
        if (numbers(i) < 0) {
          Breaks.break
        }
        count += 1
      }
    }

    println("----並び替え後----")

    for (num <- numbers.take(count).sorted) {
      println(num)
    }
  }
}
