package PrimaryClasses
import Golem.Golem

object AttackMethod extends Enumeration {
  type AttackMethod = Value

  val Attack: PrimaryClasses.AttackMethod.Value = Value(65)
  val Skill: PrimaryClasses.AttackMethod.Value = Value(99)
  val Magic: PrimaryClasses.AttackMethod.Value = Value(133)
}

object K08_2sub {
  def AttackGolem(lv: Int, playerHp: Int): Int ={
    var golem = new Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30)
    var _playerHp = playerHp

    printf("ゴーレムLv.%dが現れた！\n", lv + 1)
    while (golem.hp > 0) {
      printf("\n残りHP：%d\n", golem.hp)
      print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
      val choice = scala.io.StdIn.readInt()
      var damage = 0



      choice match {
        case 1 => damage = AttackMethod.Attack.id
        case 2 => damage = AttackMethod.Skill.id
        case 3 => damage = AttackMethod.Magic.id
        case _ => ()
      }
      damage -= golem.defense

      if (damage <= 0) {
        damage = 0
        println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
        printf("ゴーレムがあなたを攻撃しました！攻撃値：%d\n", golem.attack)
        _playerHp = DamagePlayer(_playerHp, golem.attack)
        if (_playerHp <= 0) {
          _playerHp = 0
          println("あなたはゴーレムに負けました！ゲームオーバー！")
          return _playerHp
        }
        printf("あなたの残りHPは：%d\n", _playerHp)
      }
      printf("ダメージは%dです。\n", damage)
      golem.hp -= damage

      if (golem.hp <= 0)
        golem.hp = 0
      if (golem.hp == 0)
        printf("ゴーレムLv.%dを倒した！\n", lv + 1)
    }
    _playerHp
  }

  def DamagePlayer(playerHp: Int, attackPower: Int): Int = {
    playerHp - attackPower
  }
}
