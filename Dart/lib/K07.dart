import 'dart:io';
import 'package:Dart/Executable.dart';

class K07 extends Executable {

  void ShowTexts() {
    print("Hello World!");
    print("ようこそ");
    print("Dart言語の世界へ！");
  }

  int GetMaxValue(int v1, int v2, int v3) {
    int temp = v1 >= v2 ? v1 : v2;
    temp = temp >= v3 ? temp : v3;
    return temp;
  }

  int GetType(int age) {
    if (age <= 0) {
      return 0;
    } else if (age < 3 || age >= 70) {
      return 1;
    } else if (age >= 3 && age <= 15) {
      return 2;
    } else if (age >= 60 && age < 70) {
      return 3;
    } else {
      return 4;
    }
  }

  @override
  void Question1() {
    try {
      int choice = 1;
      while (choice != 0) {
        stdout.write('メッセージを表示しますか？（０：終了する　１：表示する）＞');
        choice = int.parse(stdin.readLineSync());
        if (choice == 1) {
          ShowTexts();
        }
      }
      print('終了します。');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    try {
      List<int> numbers = [];

      for (int i = 0; i < 3; i++) {
        stdout.write('${i + 1}つ目の値を入力してください。＞');
        numbers.add(int.parse(stdin.readLineSync()));
      }

      int maxValue = GetMaxValue(numbers[0], numbers[1], numbers[2]);
      print('${numbers.length}つの中で最大値は$maxValueです。');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      int age = 0;
      int no = 0;
      stdout.write('年齢を入力して下さい。＞');
      age = int.parse(stdin.readLineSync());

      no = GetType(age);
      switch (no) {
        case 0:
          print('不適切な値が入力されました。');
          break;
        case 1:
          print('入場料金無料です。');
          break;
        case 2:
          print('子供料金で半額です。');
          break;
        case 3:
          print('シニア割引で１割引きです。');
          break;
        default:
          print('通常料金です。');
          break;
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    // TODO: implement Question4
  }

}