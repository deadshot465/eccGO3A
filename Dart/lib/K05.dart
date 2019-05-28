import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';
import 'package:Dart/Golem.dart';

class K05 extends Executable {
  @override
  void Question1() {
    double salary = 19.0;
    int age = 22;

    while (salary < 50.0) {
      salary *= 1.035;
      age++;
    }

    print('$age歳で月給$salary万円');
  }

  @override
  void Question2() {
    try {
      int choice = 0;
      do {
        print('起きろ～');
        stdout.write('1．起きた　2．あと5分…　3．Zzzz…\t入力：');
        choice = int.parse(stdin.readLineSync());
      } while (choice != 1);
      print('よし、学校へ行こう！');
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question3() {
    try {
      int choice = 0;
      do {
        print('起きろ～');
        stdout.write('1．起きた　2．あと5分…　3．Zzzz…\t入力：');
        choice = int.parse(stdin.readLineSync());
        if (choice == 1) {
          print('よし、学校へ行こう！');
        }
      } while (true);
    } on Exception catch (e) {
      print(e.toString());
    }
  }

  @override
  void Question4() {
    try {
      Random rand = Random();
      var golem = Golem(hp: 300 + rand.nextInt(201));
      int playerHp = 200 + rand.nextInt(101);
      print('ゴーレム　（HP:${golem.Hp}　防御力：${golem.Defense}）');

      while (golem.Hp > 0) {
        print('残りHP：${golem.Hp}');
        stdout.write('攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞');
        int damage = 0;

        switch (int.parse(stdin.readLineSync())) {
          case 1:
            damage = 60 + rand.nextInt(41);
            break;
          case 2:
            damage = 30 + rand.nextInt(101);
            break;
          case 3:
            damage = 20 + rand.nextInt(181);
            break;
          default:
            continue;
        }
        print('基礎攻撃力は$damageです。');

        damage -= golem.Defense;
        if (damage <= 0) {
          damage = 0;
          print('ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」');
          print('ゴーレムがあなたを攻撃しました！攻撃値：${golem.Attack}');
          playerHp -= golem.Attack;
          if (playerHp <= 0) {
            playerHp = 0;
            print('あなたはゴーレムに負けました！ゲームオーバー！');
            return;
          }
          print('あなたの残りHPは：$playerHp');
        }
        print('ダメージは$damageです。');
        golem.Hp -= damage;

        if (golem.Hp <= 0) {
          golem.Hp = 0;
        }
        if (golem.Hp == 0) {
          print('ゴーレムを倒しました！');
        }
      }
    } on Exception catch (e) {
      print(e.toString());
    }
  }

}