package Attack

class Attack(_damage: Int = 0, _hit: Int = 0) {
  private var damage = _damage
  private var hit = _hit

  def Damage: Int = damage
  def Damage_= (delta: Int): Unit = {
    damage = delta
  }

  def Hit: Int = hit
  def Hit_= (delta: Int): Unit = {
    hit = delta
  }
}
