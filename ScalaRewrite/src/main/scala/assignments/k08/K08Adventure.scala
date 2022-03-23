package assignments.k08

import shared.Golem

import scala.annotation.tailrec
import scala.io.StdIn
import scala.util.Random
import scala.util.control.Breaks
import scala.util.control.Breaks.break

enum AttackMethod:
  case Attack(val damage: Int = 65 + Random.between(0, 36))
  case Skill(val damage: Int = 50 + Random.between(0, 101))
  case Magic(val damage: Int = 33 + Random.between(0, 168))

enum ProgressResult:
  case End(val msg: String)
  case Continue(val playerHp: Int)

def gameLoop(playerHp: Int): String =
  var currentPlayerHp = playerHp
  Breaks.breakable {
    while currentPlayerHp > 0 do
      println(s"あなたのHP：$playerHp")
      print("奥に進みますか？（１：奥に進む　０．帰る）＞")
      val choice = StdIn.readInt()
      choice match
        case 0 => return "リレ〇ト！"
        case _ => engageBattle(currentPlayerHp) match
          case ProgressResult.End(s) =>
            println(s)
            break
          case ProgressResult.Continue(hp) => currentPlayerHp = hp
  }
  "ゲームオーバー！"

@tailrec
private def selectAttack(choice: Int): AttackMethod =
  choice match
    case 1 => AttackMethod.Attack()
    case 2 => AttackMethod.Skill()
    case 3 => AttackMethod.Magic()
    case _ => selectAttack(1)

private def damagePlayer(golemAttack: Int, playerHp: Int): Int =
  println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
  println(s"ゴーレムがあなたを攻撃しました！攻撃値：$golemAttack")
  playerHp - golemAttack

private def battleLoop(golemLevel: Int, golem: Golem, playerHp: Int): ProgressResult =
  var newPlayerHp = playerHp
  while golem.hp > 0 do
    println(s"ゴーレムLv.${golemLevel + 1} 残りHP：${golem.hp}")
    print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
    val baseDamage = selectAttack(StdIn.readInt()) match
      case AttackMethod.Attack(dmg) => dmg
      case AttackMethod.Skill(dmg) => dmg
      case AttackMethod.Magic(dmg) => dmg
    println(s"基礎ダメージは${baseDamage}です。")
    val actualDamage = if baseDamage - golem.defense < 0 then 0 else baseDamage - golem.defense
    println(s"実際ダメージは${actualDamage}です。")
    if actualDamage <= 0 then
      newPlayerHp = damagePlayer(golem.attack, newPlayerHp)
      if newPlayerHp <= 0 then
        return ProgressResult.End("あなたはゴーレムに負けました！")
      else
        ()
      println(s"あなたの残りHPは：$newPlayerHp")
    else
      golem.hp = if golem.hp - actualDamage < 0 then 0 else golem.hp - actualDamage

  println(s"ゴーレムLv.${golemLevel + 1}を倒した！")
  ProgressResult.Continue(newPlayerHp)

private def engageBattle(playerHp: Int): ProgressResult =
  val golemLevel = Random.between(0, 10)
  val golem = Golem(golemLevel * 50 + 100, golemLevel * 10 + 40, golemLevel * 10 + 30)
  println(s"ゴーレムLv.${golemLevel + 1}が現れた！")
  battleLoop(golemLevel, golem, playerHp)