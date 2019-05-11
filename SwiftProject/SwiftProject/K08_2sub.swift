//
//  K08_2sub.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/11.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

enum AttackMethod : Int {
    case Attack = 65
    case Skill = 99
    case Magic = 133
}

public func AttackGolem(lv: Int, playerHp: inout Int) {
    var golem =
        Golem(hp: lv * 50 + 100, defense: lv * 10 + 40, attack: lv * 10 + 30)
    
    print("ゴーレムLv.\(lv + 1)が現れた！")
    while golem.hp > 0 {
        print("\n残りHP：\(golem.hp)")
        print("武器を選択してください（１．攻撃　２．特技　３．魔法）", terminator: "")
        let choice = Int(readLine()!)
        var damage: Int
        
        switch choice {
        case 1:
            damage = AttackMethod.Attack.rawValue
        case 2:
            damage = AttackMethod.Skill.rawValue
        case 3:
            damage = AttackMethod.Magic.rawValue
        default:
            damage = 0
        }
        damage -= golem.defense
        
        if damage <= 0 {
            damage = 0
            print("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
            print("ゴーレムがあなたを攻撃しました！攻撃値：\(golem.attack)")
            playerHp -= golem.attack
            
            if playerHp <= 0 {
                playerHp = 0
                print("あなたはゴーレムに負けました！ゲームオーバー！")
                return
            }
            print("あなたの残りHPは：\(playerHp)")
        }
        print("ダメージは\(damage)です。")
        
        golem.hp -= damage
        
        if golem.hp <= 0 {
            golem.hp = 0
        }
        if golem.hp == 0 {
            print("ゴーレムLv.\(lv + 1)を倒した！")
        }
    }
}
