import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';

class K03 extends Executable {
  @override
  void Question1() {
    try {
      stdout.write("年齢を入力してください。＞");
      int age = int.parse(stdin.readLineSync());
      if (age < 20) {
        print("未成年なので購入できません。");
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    try {
      stdout.write("身長を入力してください。＞");
      double height = double.parse(stdin.readLineSync());
      height /= 100.0;
      stdout.write("体重を入力してください。＞");
      double weight = double.parse(stdin.readLineSync());
      double standard = height * height * 22.0;
      print("あなたの標準体重は$standardです。");

      if (weight > standard && (weight - standard) / standard * 100.0 > 14.0) {
        print("太り気味です。");
      } else if (weight < standard && (weight - standard) / standard * 100.0 < -14.0) {
        print("痩せ気味です。");
      } else {
        print("普通ですね。");
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      Random rand = Random();
      int number = rand.nextInt(100);
      print("０から９９の範囲の数値が決定されました。");
      stdout.write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");

      int guess = int.parse(stdin.readLineSync());
      print("決められた数値は$numberです。");
      print(guess > number ? "正解です。" : "不正解です。");
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    try {
      Random rand = Random();
      int number = rand.nextInt(100);
      print("０から９９の範囲の数値が決定されました。");
      stdout.write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");

      int guess = int.parse(stdin.readLineSync());
      print("決められた数値は$numberです。");
      if (guess > 100 || guess < 0) {
        print("反則です！");
      } else if (guess > number && guess - number <= 10) {
        print("大正解！");
      } else if (guess < number && guess - number >= -10) {
        print("惜しい！");
      } else if (guess == number) {
        print("お見事！");
      } else {
        print(guess > number ? "正解です。" : "不正解です。");
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

}