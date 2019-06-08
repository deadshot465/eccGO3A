package PrimaryClasses

import Golem.GolemEx
import Player.Player

import scala.util.Random

object Kex_1sub {
  private val AttackHit: Int = 110
  private val SkillHit: Int = 100
  private val MagicHit: Int = 70

  def CheckHitOrMiss(hit: Int): Boolean = {
    val value = Random.nextInt(100)
    value <= hit - 1
  }

  def AttackGolem(lv: Int, player: Player): Player = {

    var golem = new GolemEx(
      lv * 50 + 100,
      lv * 10 + 40,
      lv * 10 + 40
    )
    printf("ゴーレムLv.%dが現れた！\n", lv + 1)
    while (golem.Hp > 0) {
      printf("ゴーレム 残りHP：%d\n", golem.Hp)
      print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
      val choice = scala.io.StdIn.readInt()
      var damage = 0
      var is_hit = false

      choice match {
        case 1 =>
          damage = 60 + Random.nextInt(41)
          is_hit = CheckHitOrMiss(AttackHit - golem.Flee)
        case 2 =>
          damage = 30 + Random.nextInt(101)
          is_hit = CheckHitOrMiss(SkillHit - golem.Flee)
        case 3 =>
          damage = 20 + Random.nextInt(181)
          is_hit = CheckHitOrMiss(MagicHit - golem.Flee)
        case _ =>
          damage = 0
      }

      if (is_hit) {
        damage -= golem.Defense
        if (damage <= 0) {
          damage = 0
        }
        printf("%dのダメージ！\n", damage)
        golem.Hp -= damage
      } else {
        println("攻撃を外した！")
      }

      println("ゴーレムの攻撃！")
      is_hit = CheckHitOrMiss(golem.Hit)
      if (is_hit) {
        val injury = golem.Attack - player.Defense
        printf("%dのダメージ！\n", injury)
        player.Hp -= injury
        if (player.Hp <= 0) {
          player.Hp = 0
          println("あなたはゴーレムに負けました！ゲームオーバー！")
          return player
        }
      } else {
        println("攻撃を外した！")
      }

      printf("プレイヤー残りHP：%d\n", player.Hp)
      if (golem.Hp <= 0)
        golem.Hp = 0
      if (golem.Hp == 0)
        printf("ゴーレムLv.%dを倒した！\n", lv + 1)
    }
    player
  }
}
