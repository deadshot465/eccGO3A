import java.util.*

object Kex_2 {
    fun Execute() {
        println("冒険が今始まる！")
        var player = Player()
        val reader = Scanner(System.`in`)
        var continueGame = 1
        var kills = 0

        while (continueGame != 0) {
            println("現HP：${player.Hp}")
            print("奥に進みますか？（１：奥に進む　０．帰る）＞")
            continueGame = reader.nextInt()
            if (continueGame == 1) {
                val typeNo = (0..2).random()
                val enemy = CreateEnemy(EnemyType.values()[typeNo])
                val result = AttackEnemy(player, enemy)
                kills += 1

                if (!result) {
                    break
                }
            }
        }
        println("リ〇ミト！\n")
        println("戦闘回数：${kills}回　残りHP：${player.Hp}")
    }
}