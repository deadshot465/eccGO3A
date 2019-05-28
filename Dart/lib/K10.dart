import 'dart:io';
import 'package:Dart/Executable.dart';

class K10 extends Executable {
  @override
  void Question1() {
    try {
      stdout.write('文字列の入力＞');
      var inputString = stdin.readLineSync();
      print('入力された文字列の文字数：${inputString.length}');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question2() {
    var str = 'STRINGcopy';
    print('コピーしたい文字列：$str');
    var copyStr = str;
    print('コピー後の文字列：$copyStr');
  }

  @override
  void Question3() {
    var str = [
      'abcdef', 'GHIJKL', '13579'
    ];
    String strCombined = '';
    print('連結したい３つの文字列：');
    for (var s in str) {
      print(s);
      strCombined += s;
    }
    print('連結した文字列：$strCombined');
  }

  @override
  void Question4() {
    var alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var inputString = 'I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.';

    int count = 0;
    int _count = 0;

    print('文字列：$inputString');
    print('\n文字頻度');
    for (int i = 0; i < alphabets.length; i++) {
      for (int j = 0; j < inputString.length; j++) {
        if (alphabets[i] == inputString[j]) {
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