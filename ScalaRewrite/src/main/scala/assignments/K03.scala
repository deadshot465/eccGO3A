package assignments

import shared.Question

import scala.io.StdIn
import scala.util.Random

case class K03()

object K03 extends Question:
  override def question1(): Unit =
    print("年齢を入力してください。＞")
    val age = StdIn.readInt()
    println(if age < 20 then "未成年なので購入できません。" else "")

  override def question2(): Unit =
    print("身長を入力してください。＞")
    val height = StdIn.readFloat() * 0.01
    print("体重を入力してください。＞")
    val weight = StdIn.readFloat()
    val standard = height * height * 22.0f
    println(s"あなたの標準体重は${standard}です。")
    val diff = (weight - standard) / standard * 100.0f
    println(if weight > standard && diff > 14.0f then "太り気味です。"
    else if weight < standard && diff < -14.0f then "痩せ気味です。"
    else "普通ですね。")

  override def question3(): Unit =
    val randomNumber = Random.between(0, 100)
    println("０から９９の範囲の数値が決定されました。")
    print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
    val guess = StdIn.readInt()
    println(s"決められた数値は${randomNumber}です。")
    println(if guess > randomNumber then "正解です。" else "不正解です。")

  override def question4(): Unit =
    val randomNumber = Random.between(0, 100)
    println("０から９９の範囲の数値が決定されました。")
    print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
    val guess = StdIn.readInt()
    println(s"決められた数値は${randomNumber}です。")
    println(guessMessage(guess, randomNumber))

  private def guessMessage(guess: Int, n: Int): String =
    guess match
      case g if g < 0 || g > 99 => "反則です！"
      case g if g > n && g - n <= 10 => "大正解です！"
      case g if g < n && n - g <= 10 => "惜しい！"
      case g if g == n => "お見事！"
      case _ => if guess > n then "正解です。" else "不正解です。"