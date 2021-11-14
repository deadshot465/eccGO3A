package assignments

import shared.{Golem, Question}

import scala.io.StdIn

case class K02()

object K02 extends Question:
  override def question1(): Unit =
    val seisuu = 3
    val jissuu = 2.6f
    val moji = 'A'
    println(s"変数seisuuの値は$seisuu")
    println(s"変数jissuuの値は$jissuu")
    println(s"変数mojiの値は$moji")

  override def question2(): Unit =
    print("一つ目の整数は？")
    val number1 = StdIn.readInt()
    print("二つ目の整数は？")
    val number2 = StdIn.readInt()
    println(s"$number1 ÷ $number2 = ${number1 / number2}...${number1 % number2}")

  override def question3(): Unit =
    print("一つ目の商品の値段は？")
    val priceA = StdIn.readFloat()
    print("個数は？")
    val amountA = StdIn.readFloat()
    print("二つ目の商品の値段は？")
    val priceB = StdIn.readFloat()
    print("個数は？")
    val amountB = StdIn.readFloat()
    val total = (priceA * amountA + priceB * amountB) * 1.1f
    println(s"お支払いは税込み￥$total")

  override def question4(): Unit =
    val golem = Golem(300, 80, 50)
    println(s"ゴーレム　（HP：${golem.hp}　防御力：${golem.defense}）")
    println(s"HP：${golem.hp}")
    print("今回の攻撃の値を入力してください＞")
    val damage = StdIn.readInt()
    val actualDamage = if damage - golem.defense < 0 then 0 else damage - golem.defense
    println(s"ダメージは${actualDamage}です。")
    val newGolem = golem.copy(hp = golem.hp - actualDamage)
    println(s"残りのHPは${newGolem.hp}です。")