import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';
import 'package:Dart/K08_1sub.dart';
import 'package:Dart/K08_2sub.dart';

class K08 extends Executable {
  @override
  void Question1() {
    try {
      List<int> numbers = [];
      for (int i = 0; i < 3; i++) {
        stdout.write('${i + 1}つ目の値を入力してください。＞');
        numbers.add(int.parse(stdin.readLineSync()));
      }

      print('どちらを調べますか？');
      stdout.write('（０：最大値　１：最小値）＞');

      int choice = int.parse(stdin.readLineSync());

      switch (choice) {
        case 0:
          {
            int maxValue = GetMaxValue(numbers[0], numbers[1], numbers[2]);
            print('${numbers.length}の中で最大値は$maxValueです。');
            break;
          }
        case 1:
          {
            int minValue = GetMinValue(numbers[0], numbers[1], numbers[2]);
            print('${numbers.length}の中で最大値は$minValueです。');
            break;
          }
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {

    print('冒険が今始まる！');
    Random rand = Random();
    int playerHp = 200 + rand.nextInt(101);
    int continueGame = 1;

    try {
      while (continueGame != 0) {
        print('あなたのHP：$playerHp');
        stdout.write('奥に進みますか？（１：奥に進む　０．帰る）＞');
        continueGame = int.parse(stdin.readLineSync());
        if (continueGame >= 1) {
          int golemLv = rand.nextInt(5);
          playerHp = AttackGolem(golemLv, playerHp);
          if (playerHp == 0) {
            break;
          }
        }
      }
      print('リレ〇ト！');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {

  }

  @override
  void Question4() {
    // TODO: implement Question4
  }
}