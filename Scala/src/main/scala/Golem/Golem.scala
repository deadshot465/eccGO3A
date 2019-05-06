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
