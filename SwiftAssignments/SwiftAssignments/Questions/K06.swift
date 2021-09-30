import Foundation

class K06 : Question {
    func question1() {
        var salary = 19.0
        var age = 22
        while salary < 50.0 {
            age += 1
            salary *= 1.035
        }
        print("\(age)歳で月給\(salary)万円")
    }

    func question2() {
        print("起きろ～")
        print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
        var choice = readLine().flatMap { s in Int(s) } ?? 0
        while choice != 1 {
            print("起きろ～")
            print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
            choice = readLine().flatMap { s in Int(s) } ?? 0
        }
        print("よし、学校へ行こう！")
    }

    func question3() {
        print("起きろ～")
        print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
        var choice = readLine().flatMap { s in Int(s) } ?? 0
        while true {
            if choice == 1 {
                print("よし、学校へ行こう！")
            }
            print("起きろ～")
            print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
            choice = readLine().flatMap { s in Int(s) } ?? 0
        }
    }

    func question4() {
        var golem = Golem(hp: 300 + Int.random(in: 0...200), defense: 80, attack: 50)
        var playerHp = 200 + Int.random(in: 0...100)
        print("ゴーレム　（HP：\(golem.hp)　防御力：\(golem.defense)）")

        while golem.hp > 0 {
            print("ゴーレム残りHP：\(golem.hp)")
            let damage = getDamage(choice: 0)
            print("基礎攻撃力は\(damage)です。")
            let actualDamage = damage - golem.defense <= 0 ? 0 : damage - golem.defense
            print("ダメージは\(actualDamage)です。")

            if actualDamage <= 0 {
                playerHp = damagePlayer(golemAttack: golem.attack, playerHp: playerHp)
                if playerHp <= 0 {
                    print("あなたはゴーレムに負けました！ゲームオーバー！")
                    return
                }
                print("あなたの残りHPは：\(playerHp)")
            } else {
                golem.hp = golem.hp - actualDamage <= 0 ? 0 : golem.hp - actualDamage
                print("残りのHPは\(golem.hp)です。")
            }
        }

        print("ゴーレムを倒しました！")
    }

    func execute(number: Int) {
        switch number {
        case 1:
            question1()
        case 2:
            question2()
        case 3:
            question3()
        case 4:
            question4()
        default:
            break
        }
    }

    private func damagePlayer(golemAttack: Int, playerHp: Int) -> Int {
        print("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
        print("ゴーレムがあなたを攻撃しました！攻撃値：\(golemAttack)")
        return playerHp - golemAttack
    }

    private func getDamage(choice: Int) -> Int {
        switch choice {
        case 1:
            return 60 + Int.random(in: 0...40)
        case 2:
            return 30 + Int.random(in: 0...100)
        case 3:
            return 20 + Int.random(in: 0...180)
        default:
            print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）＞")
            return getDamage(choice: readLine().flatMap { s in Int(s) } ?? 0)
        }
    }
}