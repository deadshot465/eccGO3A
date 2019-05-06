package PrimaryClasses
import Golem.Golem
import IExecutable.IExecutable

class K02 extends IExecutable {
  override def Question1(): Unit = {
    val seisuu = 3
    val jissuu: Float = 2.6f
    val moji = 'A'

    printf("変数seisuuの値は%d\n", seisuu)
    printf("変数jissuuの値は%f\n", jissuu)
    printf("変数mojiの値は%c\n", moji)
  }

  override def Question2(): Unit = {
    print("一つ目の整数は？")
    val firstNumber = scala.io.StdIn.readInt
    print("二つ目の整数は？")
    val secondNumber = scala.io.StdIn.readInt

    printf("%d÷%d=%d...%d", firstNumber, secondNumber, firstNumber / secondNumber, firstNumber % secondNumber)
  }

  override def Question3(): Unit = {
    print("一つ目の商品の値段は？")
    val priceA = scala.io.StdIn.readInt
    print("個数は？")
    val amountA = scala.io.StdIn.readInt
    print("二つ目の商品の値段は？")
    val priceB = scala.io.StdIn.readInt
    print("個数は？")
    val amountB = scala.io.StdIn.readInt

    val total: Float = (priceA * amountA + priceB * amountB) * 1.08f
    printf("お支払いは税込み￥%fです", total)
  }

  override def Question4(): Unit = {
    var golem = new Golem

    printf("ゴーレム　（HP:%d　防御力：%d）\n", golem.hp, golem.defense)
    printf("HP：%d\n", golem.hp)
    print("今回の攻撃の値を入力してください＞")
    var damage = scala.io.StdIn.readInt()
    damage = if (damage - golem.defense > 0) damage - golem.defense else 0
    printf("ダメージは%dです。\n", damage)
    golem.hp -= damage
    printf("残りのHPは%dです。\n", golem.hp)
  }
}
