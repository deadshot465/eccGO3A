package PrimaryClasses

import java.io.{FileOutputStream, IOException}

import IExecutable.IExecutable

class FileControl extends IExecutable {
  override def Question1(): Unit = {
    try {
      val fs = new FileOutputStream("output.txt")
      val outputString = "This is the string to write.\n"
      fs.write(outputString.getBytes)
      fs.close()
      println("Completed.")
    } catch {
      case ex: IOException => println(ex.getMessage)
    }
  }

  override def Question2(): Unit = {

  }

  override def Question3(): Unit = {

  }

  override def Question4(): Unit = {

  }
}
