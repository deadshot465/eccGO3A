package assignments

import shared.Question

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

case class K09()

object K09 extends Question:
  override def question1(): Unit =
    val ages = ArrayBuffer.empty[Float]
    for
      i <- 0 to 4
    do
      print(s"${i + 1}人目の年齢を入力して下さい：")
      ages += StdIn.readInt()

    val average = ages.sum / ages.length
    ages.zipWithIndex.foreach(item => println(s"${item._2 + 1}人目：${item._1}歳"))
    println(s"平均年齢：${average}歳")

  override def question2(): Unit =
    val numbers = Seq(8, 3, 12, 7, 9)
    print("元々の配列：")
    numbers.foreach(i => print(s"${i}\t"))
    println()
    print("逆順での表示：")
    numbers.reverse.foreach(i => print(s"${i}\t"))

  override def question3(): Unit =
    println()
    val studentScores = Seq(Seq(52, 71, 61, 47), Seq(6, 84, 81, 20), Seq(73, 98, 94, 95))
    println("\t|\t科目A\t科目B\t科目C\t科目D")
    println(Seq.fill(65)('-').mkString(""))
    studentScores.zipWithIndex.foreach(item => {
      print(s"学生${item._2}\t|\t")
      item._1.foreach(score => print(s"${score}\t"))
      println()
    })

  override def question4(): Unit =
    println()
    val studentScores = Seq(Seq(52, 71, 61, 47), Seq(6, 84, 81, 20), Seq(73, 98, 94, 95))
    val withSum = studentScores.map(item => item :+ item.sum)
    println("\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点")
    println(Seq.fill(65)('-').mkString(""))
    withSum.zipWithIndex.foreach(item => {
      print(s"学生${item._2}\t|\t")
      val lastScore = item._1.last
      item._1.foreach(score => if score == lastScore then print(s"|\t${score}\t") else print(s"${score}\t"))
      println()
    })
    val average = transform(withSum, Seq(0, 0, 0, 0, 0)).map(_.toFloat)
    val lastAverage = average.last
    print("平均点\t|\t")
    average.foreach(score => if score == lastAverage then print(s"|\t${score / 3.0f}\t") else print(s"${score / 3.0f}\t"))

  override def execute(n: Int): Unit =
    n match
      case 1 => question1()
      case 2 => question2()
      case 3 => question3()
      case 4 => question4()
      case 5 => question5()
      case _ => ()

  private def question5(): Unit =
    val input = inputNumbers(1, 0, Seq.empty[Int])
    println("----並び替え後----")
    input.sorted.foreach(i => print(s"${i} "))

  private def transform(withSum: Seq[Seq[Int]], acc: Seq[Int]): Seq[Int] =
    withSum.foldLeft(acc)((acc, student) => acc.zipWithIndex.map(item => item._1 + student(item._2)))

  private def inputNumbers(n: Int, choice: Int, acc: Seq[Int]): Seq[Int] =
    choice match
      case x if x < 0 => acc
      case _ if n == 100 => acc
      case _ =>
        print(s"${n}件目の入力：")
        val number = StdIn.readInt()
        inputNumbers(n + 1, number, acc :+ number)