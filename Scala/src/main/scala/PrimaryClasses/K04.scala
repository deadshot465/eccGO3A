package PrimaryClasses
import IExecutable.IExecutable

import scala.util.Random

class K04 extends IExecutable {
  override def Question1(): Unit = {
    print("年齢を入力してください。＞")
    val age = scala.io.StdIn.readInt()

    if (age < 3 || age >= 70) {
      println("入場料金無料です。")
    } else {
      println("通常料金です。")
    }
  }

  override def Question2(): Unit = {
    print("性別を選択してください。（０：男性　１：女性）＞")
    val gender = scala.io.StdIn.readInt()

    gender match {
      case 0 => println("あら、格好良いですね。")
      case 1 => println("あら、モデルさんみたいですね。")
      case _ => println("そんな選択肢はありません。")
    }
  }

  override def Question3(): Unit = {
    print("年齢を入力してください。＞")
    val age = scala.io.StdIn.readInt()

    if (age < 3 || age >= 70) {
      println("入場料金無料です。")
    } else if (age >= 3 && age <= 15) {
      println("子供料金で半額です。")
    } else if (age >= 60 && age < 70) {
      println("シニア割引で一割引きです。")
    } else {
      println("通常料金です。")
    }
  }

  override def Question4(): Unit = {
    println("＊＊＊おみくじプログラム＊＊＊")
    print("おみくじを引きますか　（はい：１　いいえ：０）　＞")
    val choice = scala.io.StdIn.readInt()

    if (choice >= 1) {
      val oracle = Random.nextInt(5)
      oracle match {
        case 0 => println("大吉　とってもいいことがありそう！！")
        case 1 => println("中吉　きっといいことあるんじゃないかな")
        case 2 => println("小吉　少しぐらいはいいことあるかもね")
        case 3 => println("凶　今日はおとなしくておいた方がいいかも")
        case 4 => println("大凶　これじゃやばくない？早く家に帰った方がいいかも")
        case _ => ()
      }
    }
  }
}
