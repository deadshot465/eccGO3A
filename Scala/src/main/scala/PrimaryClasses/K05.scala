package PrimaryClasses
import Golem.Golem
import IExecutable.IExecutable

import scala.util.Random
import scala.util.control.Breaks

class K05 extends IExecutable {
  override def Question1(): Unit = {
    var salary = 19.0f
    var age = 22
    while (salary < 50.0f) {
      salary *= 1.035f
      age += 1
    }

    printf("%d歳で月給%f万円", age, salary)
  }

  override def Question2(): Unit = {
    var choice = 0

    do {
      println("起きろ～")
      print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
      choice = scala.io.StdIn.readInt()
    } while (choice != 1)
    println("よし、学校へ行こう！")
  }

  override def Question3(): Unit = {
    var choice = 0

    do {
      println("起きろ～")
      print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
      choice = scala.io.StdIn.readInt()
      if (choice == 1) {
        println("よし、学校へ行こう！")
      }
    } while (true)
  }

  override def Question4(): Unit = {
    var golem = new Golem(300 + Random.nextInt(201))
    var playerHP = 200 + Random.nextInt(101)

    printf("ゴーレム　（HP:%d　防御力：%d）\n", golem.hp, golem.defense)
    printf("HP：%d\n", golem.hp)

    while (golem.hp > 0) {
      print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞")
      val choice = scala.io.StdIn.readInt()
      var damage = 0
      choice match {
        case 1 => damage = 60 + Random.nextInt(41)
        case 2 => damage = 30 + Random.nextInt(101)
        case 3 => damage = 20 + Random.nextInt(181)
        case _ => Breaks.break()
      }

      printf("基礎攻撃力は%dです。\n", damage)
      damage -= golem.defense

      if (damage <= 0) {
        damage = 0
        println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
        printf("ゴーレムがあなたを攻撃しました！攻撃値：%d\n", golem.attack)
        playerHP -= golem.attack

        if (playerHP <= 0) {
          println("あなたはゴーレムに負けました！ゲームオーバー！")
          return
        }
        println("あなたの残りHPは：" + playerHP)
      }

      printf("ダメージは%dです\n", damage)
      golem.hp -= damage

      if (golem.hp <= 0) {
        golem.hp = 0
      }

      printf("残りのHPは%dです\n", golem.hp)

      if (golem.hp == 0) {
        println("ゴーレムを倒しました！")
      }
    }
  }
}
