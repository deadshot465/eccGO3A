import java.util.*

enum class AttackMethod(val weaponDamage: Int) {
    Attack(65),
    Skill(99),
    Magic(133)
}

fun AttackGolem(lv: Int, playerHp: Int): Int {
    val golem = Golem()
    golem.hp = lv * 50 + 100
    golem.defense = lv * 10 + 40
    golem.attack = lv * 10 + 30
    var _playerHp = playerHp

    println("ゴーレムLv.${lv + 1}が現れた！")
    while (golem.hp > 0) {
        println("\n残りHP：${golem.hp}")
        print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
        val reader = Scanner(System.`in`)
        var damage = 0

        when (reader.nextInt()) {
            1 -> damage = AttackMethod.Attack.weaponDamage
            2 -> damage = AttackMethod.Skill.weaponDamage
            3 -> damage = AttackMethod.Magic.weaponDamage
        }
        damage -= golem.defense

        if (damage <= 0) {
            damage = 0
            println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
            println("ゴーレムがあなたを攻撃しました！攻撃値：${golem.attack}")
            _playerHp = DamagePlayer(_playerHp, golem.attack)
            if (_playerHp <= 0) {
                _playerHp = 0
                println("あなたはゴーレムに負けました！ゲームオーバー！")
                return _playerHp
            }
            println("あなたの残りHPは：$_playerHp")
        }
        println("ダメージは${damage}です。")
        golem.hp -= damage

        if (golem.hp <= 0)
            golem.hp = 0
        if (golem.hp == 0) {
            println("ゴーレムLv.${lv + 1}を倒した！")
        }
    }
    return _playerHp
}

fun DamagePlayer(playerHp: Int, attackPower: Int): Int {
    return playerHp - attackPower
}