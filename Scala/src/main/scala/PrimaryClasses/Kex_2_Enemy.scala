package PrimaryClasses

import Enemy.Enemy

import scala.util.Random

object EnemyType extends Enumeration {
  type EnemyType = Value

  val TYPE_GOLEM: EnemyType.Value = Value(0)
  val TYPE_GOBLIN: EnemyType.Value = Value(1)
  val TYPE_SLIME: EnemyType.Value = Value(2)
}

object Kex_2_Enemy {
  private val MAX_GOLEM_LEVEL = 5
  private val MAX_GOBLIN_LEVEL = 7
  private val MAX_SLIME_LEVEL = 9
  private val GOLEM_HIT = 70
  private val GOLEM_FLEE = 20
  private val GOBLIN_HIT = 85
  private val GOBLIN_FLEE = 40
  private val SLIME_HIT = 95
  private val SLIME_FLEE = 30

  def CreateEnemy(typeNo: EnemyType.Value): Enemy = {
    var enemy = new Enemy
    typeNo.id match {
      case 0 =>
        val lv = Random.nextInt(MAX_GOLEM_LEVEL)
        enemy = new Enemy(lv, lv * 50 + 100, lv * 10 + 40, lv * 10 + 40, GOLEM_HIT, GOLEM_FLEE, "ゴーレム")
      case 1 =>
        val lv = Random.nextInt(MAX_GOBLIN_LEVEL)
        enemy = new Enemy(lv, lv * 30 + 75, lv * 5 + 20, lv * 5 + 20, GOBLIN_HIT, GOBLIN_FLEE, "ゴブリン")
      case 2 =>
        val lv = Random.nextInt(MAX_SLIME_LEVEL)
        enemy = new Enemy(lv, lv * 10 + 50, lv * 2 + 10, lv * 2 + 10, SLIME_HIT, SLIME_FLEE, "スライム")
    }

    enemy
  }
}
