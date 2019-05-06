package PrimaryClasses
import IExecutable.IExecutable
import scala.collection.mutable


class K06 extends IExecutable {
  override def Question1(): Unit = {
    var ages = mutable.MutableList[Float]()
    for (i <- 0 to 4) {
      printf("%d人目の年齢を入力して下さい：", i + 1)
      ages += scala.io.StdIn.readFloat()
    }

    val average = ages.sum / ages.length.toFloat
    printf("%d人の平均年齢は%f", ages.length, average)
  }

  override def Question2(): Unit = {
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        print("*")
      }
      println()
    }
    println()

    for (i <- 9 to 1 by -1) {
      for (j <- 1 to i) {
        print("*")
      }
      println()
    }
    println()

    for (i <- 9 to 1 by -1) {
      for (j <- 1 until i) {
        print(" ")
      }
      for (k <- 9 to i by -1) {
        print("*")
      }
      println()
    }
  }

  override def Question3(): Unit = {
    val total = 370
    var count = 0
    for {
      i <- 0 to total / 100
      j <- 0 to total / 50
      k <- 0 to total / 10
    } {
      if (100 * i + 50 * j + 10 * k == total) {
        printf("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚\n", k, j, i)
        count += 1
      }
    }

    printf("\n以上%d通りを発見しました。", count)
  }

  override def Question4(): Unit = {
    print("\t|\t")
    for (i <- 1 to 9) {
      printf("%d\t", i)
    }
    println("")

    for (i <- 1 to 75) {
      print("-")
    }
    println("")

    for (i <- 1 to 9) {
      printf("%d\t|\t", i)
      for (j <- 1 to 9) {
        printf("%d\t", i * j)
      }
      println("")
    }
  }
}
