import java.util.*
import kotlin.random.Random

object Kex_1sub {
    private const val ATTACK_HIT = 110
    private const val SKILL_HIT = 100
    private const val MAGIC_HIT = 70

    private fun checkHitOrMiss(hit: Int): Boolean {
        val rand = Random
        val value = rand.nextInt(0, 99)
        return value <= hit - 1
    }

    fun attackGolem(lv: Int, player: Player): Player {
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
            var damage = 0
            var is_hit = false
            val rand = Random
            when (reader.nextInt()) {
                1 -> {
                    damage = 60 + rand.nextInt(0, 40)
                    is_hit = checkHitOrMiss(ATTACK_HIT - golem.Flee)
                }
                2 -> {
                    damage = 30 + rand.nextInt(0, 100)
                    is_hit = checkHitOrMiss(SKILL_HIT - golem.Flee)
                }
                3 -> {
                    damage = 20 + rand.nextInt(0, 180)
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
                    return player
                }
            } else {
                println("攻撃を外した！")
            }

            println("プレーヤー残りHP：${player.Hp}")
            if (golem.Hp <= 0)
                golem.Hp = 0
            if (golem.Hp == 0)
                println("ゴーレムLv.${lv + 1}を倒した！")
        }
        return player
    }
}