const val GOLEM_HIT = 70
const val GOLEM_FLEE = 20

class Golem(__hp: Int = 300, __defense: Int = 80, __attack: Int = 50) {
    var hp: Int = __hp
    var defense: Int = __defense
    var attack: Int = __attack
}

data class GolemEx(var Hp: Int, val Defense: Int, val Attack: Int, val Hit: Int = GOLEM_HIT, val Flee: Int = GOLEM_FLEE)