import 'dart:io';
import 'dart:math';
import 'package:Dart/Golem.dart';
import 'package:Dart/Player.dart';

const int ATTACK_HIT = 110;
const int SKILL_HIT = 100;
const int MAGIC_HIT = 70;

bool CheckHitOrMiss(int hit) {
  Random rand = Random();
  int val = rand.nextInt(100);
  return val <= hit - 1;
}

void AttackGolemEx(int lv, Player player) {

  GolemEx golem = GolemEx(lv * 50 + 100, lv * 10 + 40, lv * 10 + 40);
  print('ゴーレムLv.${lv + 1}が現れた！');
  while (golem.Hp > 0) {
    print('ゴーレム 残りHP：${golem.Hp}');
    stdout.write('武器を選択してください（１．攻撃　２．特技　３．魔法）＞');
    Random rand = Random();
    int damage = 0;
    bool is_hit = false;

    switch (int.parse(stdin.readLineSync())) {
      case 1:
        damage = 60 + rand.nextInt(41);
        is_hit = CheckHitOrMiss(ATTACK_HIT - golem.Flee);
        break;
      case 2:
        damage = 30 + rand.nextInt(101);
        is_hit = CheckHitOrMiss(SKILL_HIT - golem.Flee);
        break;
      case 3:
        damage = 20 + rand.nextInt(181);
        is_hit = CheckHitOrMiss(MAGIC_HIT - golem.Flee);
        break;
      default:
        break;
    }

    if (is_hit) {
      damage -= golem.Defense;
      if (damage <= 0) {
        damage = 0;
      }
      print('$damageのダメージ！');
      golem.Hp -= damage;
    } else {
      print('攻撃を外した！');
    }

    print('ゴーレムの攻撃！');
    is_hit = CheckHitOrMiss(golem.Hit);
    if (is_hit) {
      int injury = golem.Attack - player.Defense;
      print('$injuryのダメージ！');
      player.Hp -= injury;
      if (player.Hp <= 0) {
        player.Hp = 0;
        print('あなたはゴーレムに負けました！ゲームオーバー！');
        return;
      }
    } else {
      print('攻撃を外した！');
    }

    print('プレイヤー残りHP：${player.Hp}');
    if (golem.Hp <= 0) {
      golem.Hp = 0;
    }
    if (golem.Hp == 0) {
      print('ゴーレムLv.${lv + 1}を倒した！');
    }
  }
  return;
}