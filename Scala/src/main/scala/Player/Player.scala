package Player

class Player() {
  private val PLAYER_HP = 500
  private val PLAYER_DEFENSE = 30
  private var _hp: Int = PLAYER_HP
  private val _defense: Int = PLAYER_DEFENSE

  def Hp: Int = _hp
  def Hp_= (delta: Int): Unit = {
    _hp = delta
  }

  def Defense: Int = _defense
}
