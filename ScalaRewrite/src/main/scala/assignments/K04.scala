package assignments

import shared.Question

import scala.io.StdIn
import scala.util.Random

case class K04()

object K04 extends Question:
  override def question1(): Unit =
    print("年齢を入力してください。＞")
    val age = StdIn.readInt()
    println(if age < 3 || age >= 70 then "入場料金無料です。" else "通常料金です。")

  override def question2(): Unit =
    print("性別を選択してください。（０：男性　１：女性）＞")
    val gender = StdIn.readInt()
    println(gender match
      case 0 => "あら、格好良いですね。"
      case 1 => "あら、モデルさんみたいですね。"
      case _ => "そんな選択肢はありません。")

  override def question3(): Unit =
    print("年齢を入力してください。＞")
    val age = StdIn.readInt()
    println(getAgeMessage(age))

  override def question4(): Unit =
    println("＊＊＊おみくじプログラム＊＊＊")
    print("おみくじを引きますか　（はい：１　いいえ：０）＞")
    val choice = StdIn.readInt()
    val oracle = Random.between(0, 5)
    println(if choice <= 0 then "" else oracle match
      case 0 => "大吉　とってもいいことがありそう！！"
      case 1 => "中吉　きっといいことあるんじゃないかな"
      case 2 => "小吉　少しぐらいはいいことあるかもね"
      case 3 => "凶　今日はおとなしくておいた方がいいかも"
      case 4 => "大凶　これじゃやばくない？早く家に帰った方がいいかも"
      case _ => "")

  private def getAgeMessage(age: Int): String =
    age match
      case a if a < 3 || a >= 70 => "入場料金無料です。"
      case a if a >= 3 && a <= 15 => "子供料金で半額です。"
      case a if a >= 60 && a < 70 => "シニア割引で一割引きです。"
      case _ => "通常料金です。"