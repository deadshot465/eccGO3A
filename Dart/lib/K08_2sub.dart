import 'dart:io';
import 'package:Dart/Golem.dart';

int AttackGolem(int lv, int playerHp) {
  var golem = Golem(hp: lv * 50 + 100, defense: lv * 10 + 40, attack: lv * 10 + 30);
  print('ゴーレムLv.${lv + 1}が現れた！');
  while (golem.Hp > 0) {

    print('\n残りHP：${golem.Hp}');
    stdout.write('武器を選択してください（１．攻撃　２．特技　３．魔法）＞');
    int damage= 0;

    switch (int.parse(stdin.readLineSync())) {
      case 1:
        damage = 65;
        break;
      case 2:
        damage = 99;
        break;
      case 3:
        damage = 133;
        break;
    }
    damage -= golem.Defense;
    if (damage <= 0) {
      damage = 0;
      print('ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」');
      print('ゴーレムがあなたを攻撃しました！攻撃値：${golem.Attack}');
      playerHp -= golem.Attack;
      if (playerHp <= 0) {
        playerHp = 0;
        print('あなたはゴーレムに負けました！ゲームオーバー！');
        return playerHp;
      }
      print('あなたの残りHPは：$playerHp');
    }
    print('ダメージは$damageです。');
    golem.Hp -= damage;

    if (golem.Hp <= 0) {
      golem.Hp = 0;
    }
    if (golem.Hp == 0) {
      print('ゴーレムLv.${lv + 1}を倒した！');

    }
  }
  return playerHp;
}