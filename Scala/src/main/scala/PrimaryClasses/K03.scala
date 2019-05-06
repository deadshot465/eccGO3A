package PrimaryClasses
import IExecutable.IExecutable

import scala.util.Random

class K03 extends IExecutable {
  override def Question1(): Unit = {
    print("年齢を入力してください。＞")
    val age = scala.io.StdIn.readInt
    if (age < 20) {
      println("未成年なので購入できません。")
    }
  }

  override def Question2(): Unit = {
    print("身長を入力してください。＞")
    var height = scala.io.StdIn.readFloat()
    height /= 100.0f
    print("体重を入力してください。＞")
    val weight = scala.io.StdIn.readFloat()
    val standard = height * height * 22.0f
    printf("あなたの標準体重は%fです。\n", standard)

    if (weight > standard && (weight - standard) / standard * 100.0f > 14.0f) {
      println("太り気味です。")
    }
    else if (weight < standard && (weight - standard) / standard * 100.0f < -14.0f) {
      println("痩せ気味です。")
    }
    else {
      println("普通ですね。")
    }
  }

  override def Question3(): Unit = {
    val randNum = Random.nextInt(100)
    println("０から９９の範囲の数値が決定されました。")
    print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
    val guess = scala.io.StdIn.readInt()
    printf("決められた数値は%dです。\n", randNum)

    println(if (guess > randNum) "正解です。" else "不正解です。")
  }

  override def Question4(): Unit = {
    val randNum = Random.nextInt(100)
    println("０から９９の範囲の数値が決定されました。")
    print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
    val guess = scala.io.StdIn.readInt()
    printf("決められた数値は%dです。\n", randNum)

    if (guess > 100 || guess < 0) {
      println("反則です！")
    } else if (guess > randNum && guess - randNum <= 10) {
      println("大正解！")
    } else if (guess < randNum && guess - randNum >= -10) {
      println("惜しい！")
    } else if (guess == randNum) {
      println("お見事！")
    } else {
      println(if (guess > randNum) "正解です。" else "不正解です。")
    }
  }
}
