//
// Created by 周哲輝 on 2021/10/01.
//

import Foundation

enum AttackMethod {
    case attack(Int)
    case skill(Int)
    case magic(Int)
}

enum ProgressResult: Equatable {
    case `continue`(Int)
    case end(String)
}

func gameLoop(playerHp: inout Int) -> String {
    var choice = 1
    while choice != 0 {
        print("あなたのHP：\(playerHp)")
        print("奥に進みますか？（１：奥に進む　０．帰る）＞")
        choice = readLine().flatMap { s in Int(s) } ?? 0

        if choice == 0 {
            break
        }

        switch engageBattle(playerHp: &playerHp) {
        case .continue(_):
            break
        case let .end(msg):
            return msg + "\nゲームオーバー！"
        }
    }

    return "リレ〇ト！"
}

private func selectAttack(choice: Int) -> AttackMethod {
    switch choice {
    case 1:
        return .attack(65 + Int.random(in: 0...35))
    case 2:
        return .skill(50 + Int.random(in: 0...100))
    case 3:
        return .magic(33 + Int.random(in: 0...167))
    default:
        return selectAttack(choice: 1)
    }
}

private func damagePlayer(golemAttack: Int, playerHp: Int) -> Int {
    print("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
    print("ゴーレムがあなたを攻撃しました！攻撃値：\(golemAttack)")
    return playerHp - golemAttack
}

private func battleLoop(golemLevel: Int, golem: inout Golem, playerHp: inout Int) -> ProgressResult {
    while golem.hp > 0 {
        print("ゴーレムLv.\(golemLevel)残りHP：\(golem.hp)\n")
        print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
        var baseDamage = 0
        switch selectAttack(choice: readLine().flatMap { s in Int(s) } ?? 0) {
        case let .attack(dmg):
            baseDamage = dmg
        case let .skill(dmg):
            baseDamage = dmg
        case let .magic(dmg):
            baseDamage = dmg
        }

        let actualDamage = baseDamage - golem.defense <= 0 ? 0 : baseDamage - golem.defense
        print("ダメージは\(actualDamage)です。")

        if actualDamage <= 0 {
            playerHp = damagePlayer(golemAttack: golem.attack, playerHp: playerHp)
            if playerHp <= 0 {
                return .end("あなたはゴーレムに負けました！")
            } else {
                print("あなたの残りHPは：\(playerHp)")
            }
        } else {
            golem.hp = golem.hp - actualDamage <= 0 ? 0 : golem.hp - actualDamage
        }
    }

    print("ゴーレムLv.\(golemLevel)を倒した！")
    return .continue(playerHp)
}

private func engageBattle(playerHp: inout Int) -> ProgressResult {
    let golemLevel = Int.random(in: 1...9)
    var golem = Golem(hp: golemLevel * 50 + 100, defense: golemLevel * 10 + 40, attack: golemLevel * 10 + 30)
    print("ゴーレムLv.\(golemLevel)が現れた！")
    return battleLoop(golemLevel: golemLevel, golem: &golem, playerHp: &playerHp)
}