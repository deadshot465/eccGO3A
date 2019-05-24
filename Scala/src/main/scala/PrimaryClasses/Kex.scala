package PrimaryClasses

import Kex_1sub.AttackGolem
import Player.Player

import scala.util.Random
import scala.util.control.Breaks

object Kex {
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
        if (continueGame != 0) {
          val golemLv = Random.nextInt(5)
          player = AttackGolem(golemLv, player)
          kills += 1
          if (player.Hp == 0)
            Breaks.break()
        }
      }
    }

    println("リ〇ミト！\n")
    printf("戦闘回数：%d　残りHP：%d", kills, player.Hp)
  }
}
