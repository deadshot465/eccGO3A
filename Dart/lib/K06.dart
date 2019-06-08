import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';

class K06 extends Executable {
  @override
  void Question1() {
    try {
      List<double> ages = [];

      for (int i = 0; i < 5; i++) {
        stdout.write('${i + 1}人目の年齢を入力して下さい：');
        ages.add(double.parse(stdin.readLineSync()));
      }

      double average = ages.reduce((double x, double y) => x + y) / ages.length;
      print('${ages.length}人の平均年齢は$averageです。');

    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < i + 1; j++) {
        stdout.write('*');
      }
      print('');
    }

    print('');

    for (int i = 9; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        stdout.write('*');
      }
      print('');
    }

    print('');

    for (int i = 9; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        stdout.write(' ');
      }
      for (int k = 9; k > i - 1; k--) {
        stdout.write('*');
      }
      print('');
    }
  }

  @override
  void Question3() {
    int total = 370;
    int count = 0;

    for (int i = 0; i <= total ~/ 100; i++) {
      for (int j = 0; j <= total ~/ 50; j++) {
        for (int k = 0; k <= total ~/ 10; k++) {
          if (100 * i + 50 * j + 10 * k == total) {
            print('10円の硬貨$k枚 50円の硬貨$j枚 100円の硬貨$i枚');
            count++;
          }
        }
      }
    }

    print('\n以上$count通りを発見しました。');
  }

  @override
  void Question4() {
    stdout.write('\t|\t');
    for (int i = 1; i <= 9; i++) {
      stdout.write('$i\t');
    }
    print('');

    for (int i = 0; i < 75; i++) {
      stdout.write('-');
    }
    print('');

    for (int i = 1; i <= 9; i++) {
      stdout.write('$i\t|\t');
      for (int j = 1; j <= 9; j++) {
        stdout.write('${i * j}\t');
      }
      print('');
    }

  }

}