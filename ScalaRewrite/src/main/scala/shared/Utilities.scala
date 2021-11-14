package shared

import scala.util.Random

def calculateGolemAttack(level: Int): Int =
  level * 10 + 40

def mkEnemy(ordinal: Int): EnemyType =
  ordinal match
    case 0 =>
      val level = Random.between(0, MAX_GOLEM_LEVEL)
      EnemyType.Golem(Enemy(
        level,
        hp = level * 50 + 100,
        defense = level * 10 + 40,
        attack = calculateGolemAttack(level),
        hit = GOLEM_HIT,
        flee = GOLEM_FLEE,
        name = "ゴーレム"
      ))
    case 1 =>
      val level = Random.between(0, MAX_GOBLIN_LEVEL)
      EnemyType.Goblin(Enemy(
        level,
        hp = level * 30 + 75,
        defense = level * 5 + 20,
        attack = level * 5 + 20,
        hit = GOBLIN_HIT,
        flee = GOBLIN_FLEE,
        name = "ゴブリン"
      ))
    case 2 =>
      val level = Random.between(0, MAX_SLIME_LEVEL)
      EnemyType.Slime(Enemy(
        level,
        hp = level * 10 + 50,
        defense = level * 2 + 10,
        attack = level * 2 + 10,
        hit = SLIME_HIT,
        flee = SLIME_FLEE,
        name = "スライム"
      ))
    case _ => mkEnemy(Random.between(0, 3))