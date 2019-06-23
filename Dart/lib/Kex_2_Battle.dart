import 'dart:io';
import 'dart:math';
import 'package:Dart/Kex_1sub.dart';

import 'Attack.dart';
import 'Enemy.dart';
import 'Player.dart';

bool AttackEnemy(Player player, Enemy enemy) {
  print('${enemy.Name}Lv.${enemy.Lv + 1}が現れた！');

  while (enemy.Hp > 0) {
    print('${enemy.Name} 残りHP：${enemy.Hp}');

    stdout.write("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
    int choice = int.parse(stdin.readLineSync());
    Random rand = Random();
    var getAttackPower = () => rand.nextInt(41) + 60;
    var getSkillPower = () => rand.nextInt(101) + 30;
    var getMagicPower = () => rand.nextInt(181) + 20;
    var attacks = [Attack(), Attack(), Attack()];
    var getPowers = [getAttackPower, getSkillPower, getMagicPower];
    var getHits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT];
    for (int i = 0; i < attacks.length; i++) {
      attacks[i].Damage = getPowers[i]();
      attacks[i].Hit = getHits[i];
    }
    int damage = 0;
    bool isHit = false;

    switch (choice) {
      case 1:
        damage = attacks[0].Damage;
        isHit = CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
        break;
      case 2:
        damage = attacks[1].Damage;
        isHit = CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
        break;
      case 3:
        damage = attacks[2].Damage;
        isHit = CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
        break;
    }

    if (isHit) {
      damage -= enemy.Defense;
      damage = damage <= 0 ? 0 : damage;
      print('${damage}のダメージ！');
      enemy.Hp -= damage;
    } else {
      print('攻撃を外した！');
    }

    print('${enemy.Name}の攻撃！');
    isHit = CheckHitOrMiss(enemy.Hit);
    if (isHit) {
      int injury = enemy.Attack - player.Defense;
      injury = injury <= 0 ? 0 : injury;
      print('${injury}のダメージ！');
      player.Hp -= injury;
      if (player.Hp <= 0) {
        player.Hp = 0;
        print('あなたは${enemy.Name}に負けました！ゲームオーバー！');
        return false;
      }
    } else {
      print('攻撃を外した！');
    }

    print('プレイヤー残りHP：${player.Hp}');
    enemy.Hp = enemy.Hp <= 0 ? 0 : enemy.Hp;
    if (enemy.Hp == 0) {
      print('${enemy.Name}Lv.${enemy.Lv + 1}を倒した！');
    }
  }
  return true;
}