import 'dart:io';
import 'dart:math';
import 'package:Dart/Kex_2_Battle.dart';
import 'package:Dart/Kex_2_Enemy.dart';

import 'Enemy.dart';
import 'Player.dart';

class Kex_2 {
  static void Execute() {
    print('冒険が今始まる！');
    Player player = Player();
    int continueGame = 1;
    int kills = 0;
    Random rand = Random();

    while (continueGame != 0) {
      print('現HP：${player.Hp}');
      stdout.write('奥に進みますか？（１：奥に進む　０．帰る）＞');
      continueGame = int.parse(stdin.readLineSync());
      if (continueGame == 1) {
        EnemyType type;
        switch (rand.nextInt(3)) {
          case 0:
            type = EnemyType.TYPE_GOLEM;
            break;
          case 1:
            type = EnemyType.TYPE_GOBLIN;
            break;
          case 2:
            type = EnemyType.TYPE_SLIME;
            break;
        }
        Enemy enemy = CreateEnemy(type);
        bool result = AttackEnemy(player, enemy);
        kills += 1;

        if (!result) {
          break;
        }
      }
    }
    print('リ〇ミト！\n');
    print('戦闘回数：${kills}回　残りHP：${player.Hp}');
  }
}