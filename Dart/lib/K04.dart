import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';

class K04 extends Executable {
  @override
  void Question1() {
    try {
      stdout.write("年齢を入力してください。＞");
      int age = int.parse(stdin.readLineSync());
      if (age < 3 || age >= 70) {
        print("入場料金無料です。");
      } else {
        print("通常料金です。");
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    try {
      stdout.write("性別を選択してください。（０：男性　１：女性）＞");
      int choice = int.parse(stdin.readLineSync());
      switch (choice) {
        case 0:
          print("あら、格好良いですね。");
          break;
        case 1:
          print("あら、モデルさんみたいですね。");
          break;
        default:
          print("そんな選択肢はありません。");
          break;
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      stdout.write("年齢を入力してください。＞");
      int age = int.parse(stdin.readLineSync());

      if (age < 3 || age >= 70) {
        print("入場料金無料です。");
      } else if (age >= 3 && age <= 15) {
        print("子供料金で半額です。");
      } else if (age >= 60 && age < 70) {
        print("シニア割引で一割引きです。");
      } else {
        print("通常料金です。");
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    try {
      print("＊＊＊おみくじプログラム＊＊＊");
      stdout.write("おみくじを引きますか　（はい：１　いいえ：０）　＞");
      int choice = int.parse(stdin.readLineSync());

      if (choice >= 1) {
        Random rand = Random();
        int oracle = rand.nextInt(5);
        switch (oracle) {
          case 0:
            print("大吉　とってもいいことがありそう！！");
            break;
          case 1:
            print("中吉　きっといいことあるんじゃないかな");
            break;
          case 2:
            print("小吉　少しぐらいはいいことあるかもね");
            break;
          case 3:
            print("凶　今日はおとなしくておいた方がいいかも");
            break;
          case 4:
            print("大凶　これじゃやばくない？早く家に帰った方がいいかも");
            break;
          default:
            break;
        }
      }

    } on Exception catch (e) {
      print(e.toString());
    }
  }

}