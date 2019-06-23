//
//  Kex_2_Battle.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/06/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public func AttackEnemy(player: inout Player, enemy: inout Enemy) -> Bool {
    print("\(enemy.Name)Lv.\(enemy.Lv + 1)が現れた！")
    
    while enemy.Hp > 0 {
        print("\(enemy.Name) 残りHP：\(enemy.Hp)")
        print("武器を選択してください（１、攻撃　２、特技　３、魔法）", terminator: "")
        let choice = Int(readLine()!)!
        let getAttackPower = {
            () -> Int in
            return Int.random(in: 0...40) + 60
        }
        let getSkillPower = {
            () -> Int in
            return Int.random(in: 0...100) + 30
        }
        let getMagicPower = {
            () -> Int in
            return Int.random(in: 0...180) + 20
        }
        var attacks = [Attack(), Attack(), Attack()]
        let getPowers = [getAttackPower, getSkillPower, getMagicPower]
        let getHits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT]
        for i in 0...attacks.count - 1 {
            attacks[i].Damage = getPowers[i]()
            attacks[i].Hit = getHits[i]
        }
        
        var damage = 0
        var isHit = false
        
        switch choice {
        case 1:
            damage = attacks[0].Damage
            isHit = CheckHitOrMiss(hit: attacks[0].Hit - enemy.Flee)
        case 2:
            damage = attacks[1].Damage
            isHit = CheckHitOrMiss(hit: attacks[1].Hit - enemy.Flee)
        case 3:
            damage = attacks[2].Damage
            isHit = CheckHitOrMiss(hit: attacks[2].Hit - enemy.Flee)
        default:
            break
        }
        
        if isHit {
            damage -= enemy.Defense
            damage = damage <= 0 ? 0 : damage
            print("\(damage)のダメージ！")
            enemy.Hp -= damage
        } else {
            print("攻撃を外した！")
        }
        
        print("\(enemy.Name)の攻撃！")
        isHit = CheckHitOrMiss(hit: enemy.Hit)
        if isHit {
            var injury = enemy.Attack - player.Defense
            injury = injury <= 0 ? 0 : injury
            print("\(injury)のダメージ！")
            player.Hp -= injury
            if player.Hp <= 0 {
                player.Hp = 0
                print("あなたは\(enemy.Name)に負けました！ゲームオーバー！")
                return false
            }
        } else {
            print("攻撃を外した！")
        }
        
        print("プレイヤー残りHP：\(player.Hp)")
        enemy.Hp = enemy.Hp <= 0 ? 0 : enemy.Hp
        if enemy.Hp == 0 {
            print("\(enemy.Name)Lv.\(enemy.Lv + 1)を倒した！")
        }
    }
    return true
}
