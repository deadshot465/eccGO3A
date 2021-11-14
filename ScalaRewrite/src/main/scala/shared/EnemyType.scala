package shared

import scala.util.Random

enum EnemyType:
  case Golem(val enemy: Enemy)
  case Goblin(val enemy: Enemy)
  case Slime(val enemy: Enemy)