package IExecutable

trait IExecutable {
  def Execute(num: Int): Unit = {
    num match {
      case 1 => Question1()
      case 2 => Question2()
      case 3 => Question3()
      case 4 => Question4()
      case _ => ()
    }
  }

  def Question1()
  def Question2()
  def Question3()
  def Question4()
}
