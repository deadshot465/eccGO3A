//
//  K05.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K05 : IExecutable {
    public override func Question1() {
        var salary: Float = 19.0
        var age = 22
        
        while salary < 50.0 {
            salary *= 1.035
            age += 1
        }
        
        print("\(age)歳で月給＄\(salary)万円")
    }
    
    public override func Question2() {
        var choice = 0
        
        while choice != 1 {
            print("起きろ〜")
            print("1.起きた　2.あと５分　3.Zzzz...\t入力＞")
            choice = Int(readLine()!)!
        }
        print("よし、学校へ行こう！")
    }
    
    public override func Question3() {
        var choice = 0
        
        while true {
            print("起きろ〜")
            print("1.起きた　2.あと５分　3.Zzzz...\t入力＞")
            choice = Int(readLine()!)!
            
            if choice == 1 {
                print("よし、学校へ行こう！")
            }
        }
    }
    
    public override func Question4() {
        
        var golem = Golem(hp: 300 + Int.random(in: 0...200), defense: 80, attack: 50)
        var playerHp = 200 + Int.random(in: 0...100)
        
        print("ゴーレム　（HP：\(golem.hp) 防御力：\(golem.defense)）")
        
        while golem.hp > 0 {
            print("HP：\(golem.hp)")
            print("攻撃手段を選択してください＞（1.攻撃　2.特技　3.魔法）")
            let choice = Int(readLine()!)!
            var damage = 0
            
            switch choice {
            case 1:
                damage = 60 + Int.random(in: 0...40)
            case 2:
                damage = 30 + Int.random(in: 0...100)
            case 3:
                damage = 20 + Int.random(in: 0...180)
            default:
                break
            }
            print("基礎攻撃力は\(damage)です。")
            
            damage -= golem.defense
            if damage <= 0 {
                damage = 0
                
                print("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
                print("ゴーレムがあなたを攻撃しました！攻撃値：\(golem.attack)")
                playerHp -= golem.attack
                
                if playerHp <= 0 {
                    print("あなたはゴーレムに負けました！ゲームオーバー！")
                    return
                }
                print("あなたの残りHPは\(playerHp)です。")
            }
            
            print("ダメージは\(damage)です。")
            golem.hp -= damage
            
            if golem.hp < 0 {
                golem.hp = 0
            }
            
            print("残りのHPは\(golem.hp)です。")
            
            if golem.hp == 0 {
                print("ゴーレムを倒しました！")
            }
        }
    }
}
