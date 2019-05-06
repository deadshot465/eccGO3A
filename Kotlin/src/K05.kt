import java.lang.Exception
import java.util.*

class K05 : IExectuable() {

    override fun question_01() {
        var salary = 19.0f
        var age = 22

        while (salary < 50.0f) {
            salary *= 1.035f
            age++
        }

        print("${age}歳で月給${salary}万円")
    }

    override fun question_02() {
        try {
            var choice: Int

            do {
                println("起きろ～")
                print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
                val reader = Scanner(System.`in`)
                choice = reader.nextInt()


            } while (choice != 1)
            println("よし、学校へ行こう！")
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }

    override fun question_03() {
        try {
            var choice: Int

            do {
                println("起きろ～")
                print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
                val reader = Scanner(System.`in`)
                choice = reader.nextInt()
                if (choice == 1) {
                    println("よし、学校へ行こう！")
                }

            } while (true)

        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    override fun question_04() {
        try {
            val randomNumber = Random()

            val golem = Golem()
            golem.hp = 300 + randomNumber.nextInt(200)
            golem.defense = 80

            var playerHp = 200 + randomNumber.nextInt(100)

            println("ゴーレム　（HP:${golem.hp}　防御力：${golem.defense}）\n")

            GolemLoop@ while (golem.hp > 0) {
                println("残りHP：" + golem.hp)
                print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞")
                val reader = Scanner(System.`in`)
                val option = reader.nextInt()
                var damage: Int

                when (option) {
                    1 -> damage = 60 + randomNumber.nextInt(40)
                    2 -> damage = 30 + randomNumber.nextInt(100)
                    3 -> damage = 20 + randomNumber.nextInt(180)
                    else -> continue@GolemLoop
                }

                println("基礎攻撃力は${damage}です。")

                damage -= golem.defense

                if (damage <= 0) {
                    damage = 0

                    println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
                    println("ゴーレムがあなたを攻撃しました！攻撃値：${golem.attack}")
                    playerHp -= golem.attack

                    if (playerHp <= 0) {
                        println("あなたはゴーレムに負けました！ゲームオーバー！")
                        return
                    }
                    println("あなたの残りHPは：$playerHp")
                }

                println("ダメージは${damage}です")

                golem.hp -= damage

                if (golem.hp < 0) {
                    golem.hp = 0
                }

                println("残りのHPは${golem.hp}です")

                if (golem.hp == 0) {
                    println("ゴーレムを倒しました！")
                }
            }
        }
        catch (ex: Exception)
        {
            println(ex.message)
        }
    }
}