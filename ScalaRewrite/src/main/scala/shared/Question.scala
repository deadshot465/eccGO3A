package shared

trait Question:
  def question1(): Unit
  def question2(): Unit
  def question3(): Unit
  def question4(): Unit
  
  def execute(n: Int): Unit =
    n match
      case 1 => question1()
      case 2 => question2()
      case 3 => question3()
      case 4 => question4()