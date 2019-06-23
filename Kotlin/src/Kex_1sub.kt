import java.util.*

object Kex_1sub {
    const val ATTACK_HIT = 110
    const val SKILL_HIT = 100
    const val MAGIC_HIT = 70

    fun checkHitOrMiss(hit: Int): Boolean {
        val value = (0..99).random()
        return value <= hit - 1
    }

    fun attackGolem(lv: Int, player: Player) {
        var golem = GolemEx(
            lv * 50 + 100,
            lv * 10 + 40,
            lv * 10 + 40
            )

        println("ゴーレムLv.${lv + 1}が現れた！")
        while (golem.Hp > 0) {
            println("ゴーレム 残りHP：${golem.Hp}")
            print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
            val reader = Scanner(System.`in`)
            var damage: Int
            var is_hit = false
            when (reader.nextInt()) {
                1 -> {
                    damage = 60 + (0..40).random()
                    is_hit = checkHitOrMiss(ATTACK_HIT - golem.Flee)
                }
                2 -> {
                    damage = 30 + (0..100).random()
                    is_hit = checkHitOrMiss(SKILL_HIT - golem.Flee)
                }
                3 -> {
                    damage = 20 + (0..180).random()
                    is_hit = checkHitOrMiss(MAGIC_HIT - golem.Flee)
                }
                else -> damage = 0
            }

            if (is_hit) {
                damage -= golem.Defense
                if (damage <= 0)
                    damage = 0
                println("${damage}のダメージ！")
                golem.Hp -= damage
            } else {
                println("攻撃を外した！")
            }

            println("ゴーレムの攻撃！")
            is_hit = checkHitOrMiss(golem.Hit)
            if (is_hit) {
                val injury = golem.Attack - player.Defense
                println("${injury}のダメージ！")
                player.Hp -= injury
                if (player.Hp <= 0) {
                    player.Hp = 0
                    println("あなたはゴーレムに負けました！ゲームオーバー！")
                    return
                }
            } else {
                println("攻撃を外した！")
            }

            println("プレイヤー残りHP：${player.Hp}")
            if (golem.Hp <= 0)
                golem.Hp = 0
            if (golem.Hp == 0)
                println("ゴーレムLv.${lv + 1}を倒した！")
        }
    }
}