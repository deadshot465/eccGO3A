package Enemy

class Enemy(_lv: Int = 0, _hp: Int = 0, _defense: Int = 0, _attack: Int = 0, _hit: Int = 0, _flee: Int = 0, _name: String = "") {
  private var lv = _lv
  private var hp = _hp
  private var defense = _defense
  private var attack = _attack
  private var hit = _hit
  private var flee = _flee
  private var name = _name

  def Lv: Int = lv
  def Hp: Int = hp
  def Defense: Int = defense
  def Attack: Int = attack
  def Hit: Int = hit
  def Flee: Int = flee
  def Name: String = name

  def Lv_= (delta: Int): Unit = {
    lv = delta
  }
  def Hp_= (delta: Int): Unit = {
    hp = delta
  }
  def Defense_= (delta: Int): Unit = {
    defense = delta
  }
  def Attack_= (delta: Int): Unit = {
    attack = delta
  }
  def Hit_= (delta: Int): Unit = {
    hit = delta
  }
  def Flee_= (delta: Int): Unit = {
    flee = delta
  }
  def Name_= (delta: String): Unit = {
    name = delta
  }
}
