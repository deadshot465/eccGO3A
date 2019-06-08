import 'dart:io';
import 'package:Dart/Executable.dart';

class K09 extends Executable {
  @override
  void Execute(int num) {
    switch (num) {
      case 1:
        Question1();
        break;
      case 2:
        Question2();
        break;
      case 3:
        Question3();
        break;
      case 4:
        Question4();
        break;
      case 5:
        Question5();
        break;
    }
  }

  @override
  void Question1() {
    List<int> ages = [];
    for (int i = 0; i < 3; i++) {
      stdout.write('${i + 1}人目の年齢を入力＞');
      ages.add(int.parse(stdin.readLineSync()));
    }
    for (int i = 0; i < 21; i++) {
      stdout.write('-');
    }
    print('');

    for (int i = 0; i < ages.length; i++) {
      print('${i + 1}人目：${ages[i]}歳');
    }

    double average = ages.reduce((int x, int y) => x + y).toDouble() / ages.length;
    average = (average * 10.0).round() / 10.0;
    print('平均年齢：$average');
  }

  @override
  void Question2() {
    var numbers = [8, 3, 12, 7, 9];
    stdout.write('元々の配列：');
    for (var num in numbers) {
      stdout.write('$num ');
    }
    print('');
    stdout.write('逆順での表示：');
    for (var num in numbers.reversed) {
      stdout.write('$num ');
    }
    print('');
  }

  @override
  void Question3() {
    var studentsScores = [
      [52, 71, 61, 47],
      [6, 84, 81, 20],
      [73, 98, 94, 95]
    ];

    print('\t\t|\t科目A\t科目B\t科目C\t科目D');
    for (int i = 0; i < 46; i++) {
      stdout.write('-');
    }

    print('');

    for (int i = 0; i < studentsScores.length; i++) {
      stdout.write('学生${i + 1}\t|\t');
      for (var score in studentsScores[i]) {
        stdout.write('$score\t\t');
      }
      print('');
    }
  }

  @override
  void Question4() {
    var studentsScores = [
      [52, 71, 61, 47],
      [6, 84, 81, 20],
      [73, 98, 94, 95]
    ];

    int total = 0;
    List<double> average = [0.0, 0.0, 0.0, 0.0];

    print('\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点');
    for (int i = 0; i < 66; i++) {
      stdout.write('-');
    }

    print('');

    for (int i = 0; i < studentsScores.length; i++) {
      stdout.write('学生${i + 1}\t|\t');
      for (int j = 0; j < studentsScores[i].length; j++) {
        stdout.write('${studentsScores[i][j]}\t\t');
        total += studentsScores[i][j];
        average[j] += studentsScores[i][j];
      }
      print('|\t$total');
      total = 0;
    }

    stdout.write('平均点\t|\t');
    for (var score in average) {
      stdout.write('${(score / 3.0 * 10.0).round() / 10.0}\t');
    }
    print('');
  }

  void Question5() {
    List<int> numbers = [];
    for (int i = 0; i < 100; i++) {
      stdout.write('${i + 1}件目の入力：');
      numbers.add(int.parse(stdin.readLineSync()));
      if (numbers[i] < 0) {
        break;
      }
    }
    print('----並び替え後----');
    numbers.removeLast();
    numbers.sort();
    for (var num in numbers) {
      print('$num');
    }
  }

}