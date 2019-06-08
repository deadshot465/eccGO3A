package PrimaryClasses

import IExecutable.IExecutable

import scala.util.Random

class Person(name: String = "", birthYear: Int = 0, height: Float = 0.0f, weight: Float = 0.0f) {
  var Name: String = name
  var BirthYear: Int = birthYear
  var Height: Float = height
  var Weight: Float = weight
}

class Staff(name: String, gender: Char, age: Int) {
  val Name: String = name
  val Gender: Char = gender
  val Age: Int = age
}

class Position(x: Int, y: Int, distance: Double = 0.0) {
  var X: Int = x
  var Y: Int = y
  var Distance: Double = distance
}

class K12 extends IExecutable{
  override def Question1(): Unit = {
    val person = new Person
    print("名前を入力してください＞")
    person.Name = scala.io.StdIn.readLine()
    print("生年（西暦）を入力してください＞")
    person.BirthYear = scala.io.StdIn.readInt()
    print("身長を入力してください＞")
    person.Height = scala.io.StdIn.readFloat()
    print("体重を入力してください＞")
    person.Weight = scala.io.StdIn.readFloat()

    println("プロファイル")
    printf("名前：%s\n", person.Name)
    printf("生年：%d\n", person.BirthYear)
    printf("身長：%.1f\n", person.Height)
    printf("体重：%.1f\n", person.Weight)
  }

  override def Question2(): Unit = {
    val staffs = Array(
      new Staff("神木隆之介", 'M', 23),
      new Staff("上白石萌音", 'F', 18),
      new Staff("長澤まさみ", 'F', 28)
    )
    println("名前\t\t性別\t年齢")
    for (_ <- 1 to 35) {
      print('-')
    }
    println()

    for (i <- staffs.indices) {
      printf("%s\t%c\t%d\n", staffs(i).Name, staffs(i).Gender, staffs(i).Age)
    }
  }

  def GetDistance(playerPos: Position, enemyPos: Position): Double = {
    val diffX = playerPos.X - enemyPos.X
    val diffY = playerPos.Y - enemyPos.Y
    scala.math.sqrt((diffX * diffX + diffY * diffY).toDouble)
  }

  override def Question3(): Unit = {
    val getRandomNumber = () => Random.nextInt(101) - 50
    val playerPos = new Position(getRandomNumber(), getRandomNumber())
    val enemyPos = new Array[Position](5)
    for (i <- enemyPos.indices) {
      enemyPos(i) = new Position(
        getRandomNumber(),
        getRandomNumber(),
      )

      enemyPos(i).Distance = GetDistance(playerPos, enemyPos(i))
    }

    printf("プレーヤーの座標：x= %d\t\ty= %d\n", playerPos.X, playerPos.Y)
    for (i <- enemyPos.indices) {
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
        i, enemyPos(i).X.toFloat, enemyPos(i).Y.toFloat, enemyPos(i).Distance)
    }
  }

  override def Question4(): Unit = {
    val getRandomNumber = () => Random.nextInt(101) - 50
    val playerPos = new Position(getRandomNumber(), getRandomNumber())
    val enemyPos = new Array[Position](5)
    for (i <- enemyPos.indices) {
      enemyPos(i) = new Position(
        getRandomNumber(),
        getRandomNumber(),
      )

      enemyPos(i).Distance = GetDistance(playerPos, enemyPos(i))
    }

    printf("プレーヤーの座標：x= %d\t\ty= %d\n", playerPos.X, playerPos.Y)
    for (i <- enemyPos.indices) {
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
        i, enemyPos(i).X.toFloat, enemyPos(i).Y.toFloat, enemyPos(i).Distance)
    }

    println("\n並び替え後")
    val sortedPos = enemyPos.sortBy((pos: Position) => pos.Distance)
    for (i <- sortedPos.indices) {
      printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
        i, sortedPos(i).X.toFloat, sortedPos(i).Y.toFloat, sortedPos(i).Distance)
    }
  }
}
