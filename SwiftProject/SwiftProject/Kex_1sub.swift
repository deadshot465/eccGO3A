//
//  Kex_1sub.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

let ATTACK_HIT = 110
let SKILL_HIT = 100
let MAGIC_HIT = 70

func CheckHitOrMiss(hit: Int) -> Bool {
    let val = Int.random(in: 0...99)
    return val <= hit - 1
}

public func AttackGolemEx(lv: Int, player: inout Player) {
    var golem =
        GolemEx(hp: lv * 50 + 100, defense: lv * 10 + 40, attack: lv * 10 + 40)
    
    print("ゴーレムLv.\(lv + 1)が現れた！")
    while golem.Hp > 0 {
        print("ゴーレム 残りHP：\(golem.Hp)")
        print("攻撃手段を選択して下さい（１.攻撃　２.特技　３.魔法）", terminator: "")
        var damage: Int
        var is_hit = false
        
        switch Int(readLine()!)! {
        case 1:
            damage = 60 + Int.random(in: 0...40)
            is_hit = CheckHitOrMiss(hit: ATTACK_HIT - golem.Flee)
        case 2:
            damage = 30 + Int.random(in: 0...100)
            is_hit = CheckHitOrMiss(hit: SKILL_HIT - golem.Flee)
        case 3:
            damage = 20 + Int.random(in: 0...180)
            is_hit = CheckHitOrMiss(hit: MAGIC_HIT - golem.Flee)
        default:
            damage = 0
        }
        
        if is_hit {
            damage -= golem.Defense
            if damage <= 0 {
                damage = 0
            }
            print("\(damage)のダメージ！")
            golem.Hp -= damage
        } else {
            print("攻撃を外した！")
        }
        
        print("ゴーレムの攻撃！")
        is_hit = CheckHitOrMiss(hit: golem.Hit)
        if is_hit {
            let injury = golem.Attack - player.Defense
            print("\(injury)のダメージ！")
            player.Hp -= injury
            if player.Hp <= 0 {
                player.Hp = 0
                print("あなたはゴーレムに負けました！ゲームオーバー！")
                return
            }
        } else {
            print("攻撃を外した！")
        }
        
        print("プレイヤー残りHP：\(player.Hp)")
        if golem.Hp <= 0 {
            golem.Hp = 0
        }
        if golem.Hp == 0 {
            print("ゴーレムLv.\(lv + 1)を倒した！")
        }
    }
}
