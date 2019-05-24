import java.util.*
import kotlin.random.Random

class Kex {
    fun execute() {
        val rand = Random
        println("冒険が今始まる！")
        var player = Player()
        var continueGame = 1
        var kills = 0
        val reader = Scanner(System.`in`)

        while (continueGame != 0) {
            println("現HP：${player.Hp}")
            print("奥に進みますか？（１：奥に進む　０．帰る）＞")
            continueGame = reader.nextInt()
            if (continueGame != 0) {
                val golemLv = rand.nextInt(0, 4)
                player = Kex_1sub.attackGolem(golemLv, player)
                kills++
                if (player.Hp == 0)
                    break
            }
        }
        println("リ〇ミト！")
        println("戦闘回数：${kills}　残りHP：${player.Hp}")
    }
}