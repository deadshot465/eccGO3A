import Kex_1sub.ATTACK_HIT
import Kex_1sub.MAGIC_HIT
import Kex_1sub.SKILL_HIT
import Kex_1sub.checkHitOrMiss
import java.util.*
import kotlin.Exception

fun AttackEnemy(player: Player, enemy: Enemy): Boolean {
    println("${enemy.Name}Lv.${enemy.Lv + 1}が現れた！")

    while (enemy.Hp > 0) {
        println("${enemy.Name} 残りHP：${enemy.Hp}")

        try {
            val reader = Scanner(System.`in`)
            print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
            val choice = reader.nextInt()
            val getAttackPower: () -> Int = { (0..40).random() + 60 }
            val getSkillPower: () -> Int = { (0..100).random() + 30 }
            val getMagicPower: () -> Int = { (0..180).random() + 20 }
            val attacks = arrayOf(Attack(), Attack(), Attack())
            val getPowers = arrayOf(getAttackPower, getSkillPower, getMagicPower)
            val getHits = arrayOf(ATTACK_HIT, SKILL_HIT, MAGIC_HIT)
            for (item in attacks.withIndex()) {
                item.value.Damage = getPowers[item.index]()
                item.value.Hit = getHits[item.index]
            }
            var damage = 0
            var isHit = false

            when (choice) {
                1 -> {
                    damage = attacks[0].Damage
                    isHit = checkHitOrMiss(attacks[0].Hit - enemy.Flee)
                }
                2 -> {
                    damage = attacks[1].Damage
                    isHit = checkHitOrMiss(attacks[1].Hit - enemy.Flee)
                }
                3 -> {
                    damage = attacks[2].Damage
                    isHit = checkHitOrMiss(attacks[2].Hit - enemy.Flee)
                }
            }

            if (isHit) {
                damage -= enemy.Defense
                damage = if (damage <= 0) 0 else damage
                println("${damage}のダメージ！")
                enemy.Hp -= damage
            } else {
                println("攻撃を外した！")
            }

            println("${enemy.Name}の攻撃！")
            isHit = checkHitOrMiss(enemy.Hit)
            if (isHit) {
                var injury = enemy.Attack - player.Defense
                injury = if (injury <= 0) 0 else injury
                println("${injury}のダメージ！")
                player.Hp -= injury
                if (player.Hp <= 0) {
                    player.Hp = 0
                    println("あなたは${enemy.Name}に負けました！ゲームオーバー！")
                    return false
                }
            } else {
                println("攻撃を外した！")
            }

            println("プレイヤー残りHP：${player.Hp}")
            enemy.Hp = if (enemy.Hp <= 0) 0 else enemy.Hp
            if (enemy.Hp == 0) {
                println("${enemy.Name}Lv.${enemy.Lv + 1}を倒した！")
            }
        } catch (ex: Exception) {
            error(ex)
        }
    }

    return true
}