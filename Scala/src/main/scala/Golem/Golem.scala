package Golem

class Golem(__hp: Int = 300, __defense: Int = 80, __attack: Int = 50) {
  private var _hp: Int = __hp
  private val _defense: Int = __defense
  private val _attack: Int = __attack

  def hp: Int = _hp
  def hp_= (delta: Int): Unit = {
    _hp = delta
  }

  def defense: Int = _defense

  def attack: Int = _attack
}

class GolemEx(__hp: Int, __defense: Int, __attack: Int) {
  private var _hp: Int = __hp
  private val _defense: Int = __defense
  private val _attack: Int = __attack
  private val GOLEM_HIT: Int = 70
  private val GOLEM_FLEE: Int = 20

  def Hp: Int = _hp
  def Hp_= (delta: Int): Unit = {
    _hp = delta
  }

  def Defense: Int = _defense
  def Attack: Int = _attack
  def Hit: Int = GOLEM_HIT
  def Flee: Int = GOLEM_FLEE
}