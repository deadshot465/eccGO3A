import 'dart:io';
import 'dart:math';
import 'package:Dart/Kex_1sub.dart';
import 'package:Dart/Player.dart';

class Kex {
  void Execute() {
    Random rand = Random();
    print('冒険が今始まる！');
    Player player = Player();
    int continueGame = 1;
    int kills = 0;
    while (continueGame != 0) {
      print('現HP：${player.Hp}');
      stdout.write('奥に進みますか？（１：奥に進む　０．帰る）＞');
      continueGame = int.parse(stdin.readLineSync());
      if (continueGame == 1) {
        int golemLv = rand.nextInt(5);
        player = AttackGolemEx(golemLv, player);
        kills++;
        if (player.Hp == 0) {
          break;
        }
      }
    }
    print('リ〇ミト！\n');
    print('戦闘回数：$kills　残りHP：${player.Hp}');
  }
}