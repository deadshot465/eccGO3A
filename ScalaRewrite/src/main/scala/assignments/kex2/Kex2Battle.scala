package assignments.kex2

import shared.{ATTACK_HIT, Enemy, EnemyType, MAGIC_HIT, Player, SKILL_HIT, mkEnemy}

import scala.annotation.tailrec
import scala.io.StdIn
import scala.util.Random
import scala.util.control.Breaks

enum AttackMethod:
  case Attack(val damage: Int = 60 + Random.between(0, 41), val hit: Int = ATTACK_HIT)
  case Skill(val damage: Int = 30 + Random.between(0, 101), val hit: Int = SKILL_HIT)
  case Magic(val damage: Int = 20 + Random.between(0, 181), val hit: Int = MAGIC_HIT)

enum ProgressResult:
  case End(val msg: String)
  case Continue(val player: Player)

def checkHitOrMiss(hit: Int): Boolean =
  Random.between(0, 101) < hit

def gameLoop(player: Player): String =
  var kills = 0
  Breaks.breakable {
    while player.hp > 0 do
      println(s"\n現HP：${player.hp}")
      print("奥に進みますか？（１：奥に進む　０．帰る）＞")
      val continueGame = StdIn.readInt()
      if continueGame == 0 then
        Breaks.break
      else
        val ordinal = Random.between(0, 3)
        val enemy = mkEnemy(ordinal)
        engageBattle(enemy, player) match
          case ProgressResult.End(s) => println(s)
          case ProgressResult.Continue(p) =>
            player.hp = p.hp
            kills += 1
  }
  s"リ〇ミト！\n戦闘回数：${kills}回　残りHP：${player.hp}"

@tailrec
private def selectAttack(choice: Int): AttackMethod =
  choice match
    case 1 => AttackMethod.Attack()
    case 2 => AttackMethod.Skill()
    case 3 => AttackMethod.Magic()
    case _ => selectAttack(1)

private def battleLoop(enemy: Enemy, player: Player): ProgressResult =
  while enemy.hp > 0 do
    println(s"${enemy.name} 残りHP：${enemy.hp}")
    print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
    val (damage, hit) = selectAttack(StdIn.readInt()) match
      case AttackMethod.Attack(dmg, h) => (dmg, h)
      case AttackMethod.Skill(dmg, h) => (dmg, h)
      case AttackMethod.Magic(dmg, h) => (dmg, h)
    if checkHitOrMiss(hit) then
      val actualDamage = if damage - enemy.defense < 0 then 0 else damage - enemy.defense
      println(s"${actualDamage}のダメージ！")
      enemy.hp -= actualDamage
    else
      println("攻撃を外した！")
    println(s"${enemy.name}の攻撃！")
    if checkHitOrMiss(enemy.hit) then
      val actualDamage = if enemy.attack - player.defense < 0 then 0 else enemy.attack - player.defense
      println(s"${actualDamage}のダメージ！")
      player.hp -= actualDamage
      if player.hp <= 0 then
        player.hp = 0
        println(s"あなたは${enemy.name}に負けました！")
        return ProgressResult.End("ゲームオーバー！")
      else
        ()
    else
      println("攻撃を外した！")
    println(s"プレイヤー残りHP：${player.hp}")
    if enemy.hp <= 0 then
      enemy.hp = 0
      println(s"${enemy.name}Lv.${enemy.level + 1}を倒した！")
  ProgressResult.Continue(player)

private def engageBattle(enemy: EnemyType, player: Player): ProgressResult =
  val enemyData = enemy match
    case EnemyType.Goblin(e) => e
    case EnemyType.Golem(e) => e
    case EnemyType.Slime(e) => e
  println(s"${enemyData.name}Lv.${enemyData.level + 1}が現れた！")
  battleLoop(enemyData, player)
