package PrimaryClasses

import Player.Player

import scala.util.Random
import scala.util.control.Breaks

object Kex_2 {
  def Execute(): Unit = {
    println("冒険が今始まる！")
    var player = new Player
    var continueGame = 1
    var kills = 0

    Breaks.breakable {
      while (continueGame != 0) {
        printf("現HP：%d\n", player.Hp)
        print("奥に進みますか？（１：奥に進む　０．帰る）＞")
        continueGame = scala.io.StdIn.readInt()
        if (continueGame == 1) {
          val typeNo = Random.nextInt(3) match {
            case 0 => EnemyType.TYPE_GOLEM
            case 1 => EnemyType.TYPE_GOBLIN
            case 2 => EnemyType.TYPE_SLIME
          }

          val enemy = Kex_2_Enemy.CreateEnemy(typeNo)
          val result = Kex_2_Battle.AttackEnemy(player, enemy)
          kills += 1
          if (!result) {
            Breaks.break()
          }
        }
      }
      printf("リ〇ミト！\n\n")
      printf("戦闘回数：%d回　残りHP：%d\n", kills, player.Hp)
    }
  }
}
