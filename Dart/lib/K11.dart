import 'dart:io';
import 'package:Dart/Executable.dart';

const int MAX_PEOPLE = 5;

class K11 extends Executable {
  @override
  void Question1() {
    try {
      List<int> ages = [];
      for (int i = 0; i < MAX_PEOPLE; i++) {
        stdout.write('${i + 1}人目の年齢を入力して下さい：');
        ages.add(int.parse(stdin.readLineSync()));
      }

      double average = ages.reduce((x, y) => x + y).toDouble() /
          MAX_PEOPLE.toDouble();
      average = (average * 10.0).round() / 10.0;
      print('$MAX_PEOPLE人の平均年齢は$averageです。');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    try {
      stdout.write('1つ目の文字列を入力して下さい。＞');
      var str1 = stdin.readLineSync();
      stdout.write('2つ目の文字列を入力して下さい。＞');
      var str2 = stdin.readLineSync();
      str1 += str2;
      print('$str1の文字数は${str1.length}です。');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      stdout.write('文字を入力して下さい。＞');
      bool applied = false;
      var chr = stdin.readLineSync()[0];
      RegExp rx = RegExp(r'[0-9]');

      if (rx.hasMatch(chr)) {
        print('この文字は数字です。');
        applied = true;
      }
      rx = RegExp(r'[A-Z]');
      if (rx.hasMatch(chr)) {
        print('この文字は英大文字です。');
        applied = true;
      }
      rx = RegExp(r'[a-z]');
      if (rx.hasMatch(chr)) {
        print('この文字は英小文字です。');
        applied = true;
      }
      rx = RegExp(r'[A-Fa-f0-9]');
      if (rx.hasMatch(chr)) {
        print('この文字は16進数として使える文字です。');
        applied = true;
      }
      rx = RegExp(r"(.|,|!?|:|;|'|-|\(|\))");
      if (rx.hasMatch(chr)) {
        print('この文字は区切り文字です。');
        applied = true;
      }
      if (!applied) {
        print('この文字はよくわからない文字です。');
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    var alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var inputString = 'I am a STUDENT. I am good at GAME PROGRAMMING.';

    int count = 0;
    int _count = 0;

    print('文字列：$inputString');
    print('\n文字頻度');
    for (int i = 0; i < alphabets.length; i++) {
      for (int j = 0; j < inputString.length; j++) {
        if (alphabets[i] == inputString[j].toUpperCase()) {
          count++;
        }
      }
      stdout.write('${alphabets[i]}: $count\t');
      count = 0;
      _count++;
      if (_count % 4 == 0) {
        print('');
      }
    }
  }
}
