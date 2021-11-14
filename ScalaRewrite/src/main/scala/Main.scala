import assignments.k08.K08
import assignments.kex2.Kex2
import assignments.{K01, K02, K03, K04, K05, K06, K07, K09, K10}
import shared.Question

import scala.io.StdIn

@main
def main(args: String*) =
  val assignments = Seq(K01, K02, K03, K04, K05, K06, K07, K08, K09, K10)
  println("実行したいプログラムを選択してください。")
  for
    i <- 1 to assignments.length
  do
    println(if i < 10 then s"${i}) K0${i}" else
      val addedNumbers = if i >= 12 then i + 3 else i
      s"${i}) K${addedNumbers}")
  println("100) Kex")
  println("101) Kex_2")
  println("102) Sort")

  val choice = StdIn.readInt()
  choice match
    case 100 | 101 | 102 =>
      choice match
        case 101 => Kex2.run()
        case _ => ()
    case _ =>
      showSelections(choice)
      val choice2 = StdIn.readInt()
      assignments(choice - 1).execute(choice2)

private def showSelections(chapter: Int): Unit =
  if chapter < 10 then
    for
      i <- 1 to 4
    do
      println(s"\t${i}) K0${chapter}_${i}")
    println(if chapter == 9 then s"\t5) K0${chapter}_5" else "")
  else
    val addedNumbers = if chapter >= 12 then chapter + 3 else chapter
    for
      i <- 1 to 4
    do
      println(s"\t${i}) K${chapter}_${i}")