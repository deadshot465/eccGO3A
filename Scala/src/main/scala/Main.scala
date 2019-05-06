import IExecutable.IExecutable
import PrimaryClasses.K01
import PrimaryClasses.K02
import PrimaryClasses.K03
import PrimaryClasses.K04
import PrimaryClasses.K05
import PrimaryClasses.K06

object Main {

  def ShowSelections(chapter: Int): Unit = {
    for (i <- 1 to 4) {
      printf("\t%d) K0%d_%d\n", i, chapter, i)
    }
  }

  def main(Args: Array[String]): Unit = {
    val executables: Vector[IExecutable] =
      Vector[IExecutable](new K01, new K02, new K03,
        new K04, new K05, new K06)

    println("実行したいプログラムを選択してください。")
    for (i <- 1 to 6) {
      printf("%d) K0%d\n", i, i)
    }
    val choice = scala.io.StdIn.readInt
    ShowSelections(choice)
    val choice2 = scala.io.StdIn.readInt

    executables(choice - 1).Execute(choice2)
  }
}
