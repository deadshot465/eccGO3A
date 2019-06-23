enum class EnemyType(val typeNumber: Int) {
    TYPE_GOLEM(0),
    TYPE_GOBLIN(1),
    TYPE_SLIME(2)
}

const val MAX_GOLEM_LEVEL = 4
const val MAX_GOBLIN_LEVEL = 6
const val MAX_SLIME_LEVEL = 8
const val GOBLIN_HIT = 85
const val GOBLIN_FLEE = 40
const val SLIME_HIT = 95
const val SLIME_FLEE = 30

fun CreateEnemy(type: EnemyType): Enemy {
    val enemy: Enemy
    enemy = when (type) {
        EnemyType.TYPE_GOLEM -> {
            val lv = (0..MAX_GOLEM_LEVEL).random()
            Enemy(lv, lv * 50 + 100, lv * 10 + 40, lv * 10 + 40, GOLEM_HIT, GOLEM_FLEE, "ゴーレム")
        }
        EnemyType.TYPE_GOBLIN -> {
            val lv = (0..MAX_GOBLIN_LEVEL).random()
            Enemy(lv, lv * 30 + 75, lv * 5 + 20, lv * 5 + 20, GOBLIN_HIT, GOBLIN_FLEE, "ゴブリン")
        }
        EnemyType.TYPE_SLIME -> {
            val lv = (0..MAX_SLIME_LEVEL).random()
            Enemy(lv, lv * 10 + 50, lv * 2 + 10, lv * 2 + 10, SLIME_HIT, SLIME_FLEE, "スライム")
        }
    }
    return enemy
}