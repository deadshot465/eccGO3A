package assignments

import shared.{Golem, Question}

import scala.io.StdIn
import scala.util.Random

case class K05()

object K05 extends Question:
  override def question1(): Unit =
    var salary = 19.0f
    var age = 22
    while salary < 50.0f do
      salary *= 1.035f
      age += 1

    println(s"${age}歳で月給${salary}万円")

  override def question2(): Unit =
    var choice = 0
    while choice != 1 do
      println("起きろ～")
      print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
      choice = StdIn.readInt()

    println("よし、学校へ行こう！")

  override def question3(): Unit =
    while true do
      println("起きろ～")
      print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
      val choice = StdIn.readInt()
      if choice == 1 then println("よし、学校へ行こう！") else println()

  override def question4(): Unit =
    val randomNumber = Random.between(0, 201)
    val golem = Golem(300 + randomNumber, 80, 50)
    var playerHp = 200 + Random.between(0, 101)
    println(s"ゴーレム　（HP:${golem.hp}　防御力：${golem.defense}）")
    while golem.hp > 0 do
      println(s"HP：${golem.hp}")
      print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞")
      val choice = StdIn.readInt()
      val damage = choice match
        case 1 => 60 + Random.between(0, 41)
        case 2 => 30 + Random.between(0, 101)
        case 3 => 20 + Random.between(0, 181)
        case _ => 0

      println(s"基礎攻撃力は${damage}です。")
      val actualDamage = if damage - golem.defense < 0 then 0 else damage - golem.defense
      if actualDamage == 0 then
        println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
        println(s"ゴーレムがあなたを攻撃しました！攻撃値：${golem.attack}")
        playerHp -= golem.attack
        if playerHp <= 0 then
          println("あなたはゴーレムに負けました！ゲームオーバー！")
          return

        println(s"あなたの残りHPは：${playerHp}")

      println(s"ダメージは${actualDamage}です。")
      golem.hp -= actualDamage
      if golem.hp <= 0 then
        golem.hp = 0

      println(s"残りのHPは${golem.hp}です。")
      if golem.hp == 0 then
        println("ゴーレムを倒しました！")