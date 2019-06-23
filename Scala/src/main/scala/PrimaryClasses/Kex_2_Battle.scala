package PrimaryClasses

import Attack.Attack
import Enemy.Enemy
import Player.Player

import scala.util.Random

object Kex_2_Battle {
  private val ATTACK_HIT = 110
  private val SKILL_HIT = 100
  private val MAGIC_HIT = 70

  def AttackEnemy(player: Player, enemy: Enemy): Boolean = {
    printf("%sLv.%dが現れた！\n", enemy.Name, enemy.Lv + 1)

    while (enemy.Hp > 0) {
      printf("%s 残りHP：%d\n", enemy.Name, enemy.Hp)
      print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
      val choice = scala.io.StdIn.readInt()
      val getAttackPower = () => { Random.nextInt(40) + 60 }
      val getSkillPower = () => { Random.nextInt(100) + 30 }
      val getMagicPower = () => { Random.nextInt(180) + 20 }
      val attacks = Array(new Attack, new Attack, new Attack)
      val getPowers = Array(getAttackPower, getSkillPower, getMagicPower)
      val getHits = Array(ATTACK_HIT, SKILL_HIT, MAGIC_HIT)
      for (x <- attacks.indices) {
        attacks(x).Damage = getPowers(x)()
        attacks(x).Hit = getHits(x)
      }
      var damage = 0
      var isHit = false

      choice match {
        case 1 =>
          damage = attacks(0).Damage
          isHit = Kex_1sub.CheckHitOrMiss(attacks(0).Hit - enemy.Flee)
        case 2 =>
          damage = attacks(1).Damage
          isHit = Kex_1sub.CheckHitOrMiss(attacks(1).Hit - enemy.Flee)
        case 3 =>
          damage = attacks(2).Damage
          isHit = Kex_1sub.CheckHitOrMiss(attacks(2).Hit - enemy.Flee)
      }

      if (isHit) {
        damage -= enemy.Defense
        damage = if (damage <= 0) 0 else damage
        printf("%dのダメージ！\n", damage)
        enemy.Hp -= damage
      } else {
        println("攻撃を外した！")
      }

      printf("%sの攻撃！\n", enemy.Name)
      isHit = Kex_1sub.CheckHitOrMiss(enemy.Hit)
      if (isHit) {
        var injury = enemy.Attack - player.Defense
        injury = if (injury <= 0) 0 else injury
        printf("%dのダメージ！\n", injury)
        player.Hp -= injury
        if (player.Hp <= 0) {
          player.Hp = 0
          printf("あなたは%sに負けました！ゲームオーバー！\n", enemy.Name)
          return false
        }
      } else {
        println("攻撃を外した！")
      }

      printf("プレイヤー残りHP：%d\n", player.Hp)
      enemy.Hp = if (enemy.Hp <= 0) 0 else enemy.Hp
      if (enemy.Hp == 0) {
        printf("%sLv.%dを倒した！\n", enemy.Name, enemy.Lv + 1)
      }
    }
    true
  }
}
