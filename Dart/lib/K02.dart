import 'dart:io';
import 'package:Dart/Executable.dart';
import 'package:Dart/Golem.dart';

class K02 extends Executable {
  @override
  void Question1() {
    var seisuu = 3;
    var jissuu = 2.6;
    var moji = 'A';

    print("変数seisuuの値は$seisuu");
    print("変数jissuuの値は$jissuu");
    print("変数mojiの値は$moji");
  }

  @override
  void Question2() {
    try {
      stdout.write("一つ目の整数は？");
      int numA = int.parse(stdin.readLineSync());
      stdout.write("二つ目の整数は？");
      int numB = int.parse(stdin.readLineSync());
      print("$numA÷$numB=${numA ~/ numB}...${numA % numB}");
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      stdout.write("一つ目の商品の値段は？");
      int priceA = int.parse(stdin.readLineSync());
      stdout.write("個数は？");
      int amountA = int.parse(stdin.readLineSync());
      stdout.write("二つ目の商品の値段は？");
      int priceB = int.parse(stdin.readLineSync());
      stdout.write("個数は？");
      int amountB = int.parse(stdin.readLineSync());

      double total = (priceA * amountA + priceB * amountB) * 1.08;
      print("お支払いは税込み￥$totalです");
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    try {
      var golem = Golem();
      print("ゴーレム　（HP：${golem.Hp}　防御力：${golem.Defense}）");
      print("HP：${golem.Hp}");
      stdout.write("今回の攻撃の値を入力してください＞");
      int damage = int.parse(stdin.readLineSync());
      damage = damage - golem.Defense > 0 ? damage - golem.Defense : 0;
      print("ダメージは$damageです。");
      golem.Hp -= damage;
      print("残りのHPは${golem.Hp}です。");
    } on Exception catch (e) {
      print(e.toString());
    }
  }

}