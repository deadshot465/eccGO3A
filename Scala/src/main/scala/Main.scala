import IExecutable.IExecutable
import PrimaryClasses.{FileControl, K01, K02, K03, K04, K05, K06, K07, K08, K09, K10}

object Main {

  def ShowSelections(chapter: Int): Unit = {
    for (i <- 1 to 4) {
      printf("\t%d) K0%d_%d\n", i, chapter, i)
    }
    if (chapter == 9) {
      printf("\t5) K0%d_5\n", chapter)
    }
  }

  def main(Args: Array[String]): Unit = {
    val executables: Vector[IExecutable] =
      Vector[IExecutable](new K01, new K02, new K03,
        new K04, new K05, new K06,
        new K07, new K08, new K09,
        new K10, new FileControl)

    println("実行したいプログラムを選択してください。")
    for (i <- 1 to executables.length) {
      printf("%d) K0%d\n", i, i)
    }
    val choice = scala.io.StdIn.readInt
    ShowSelections(choice)
    val choice2 = scala.io.StdIn.readInt

    executables(choice - 1).Execute(choice2)
  }
}
