//
//  K08.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/11.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

class K08 : IDispatchable {
    
    func Question1() {
        var numbers = [Int]()
        
        for i in 1...3 {
            print("\(i)つ目の値を入力してください。＞", terminator: "")
            numbers.append(Int(readLine()!)!)
        }
        
        print("どちらを調べますか？")
        print("（０：最大値　１：最小値）＞", terminator: "")
        let choice = Int(readLine()!)
        switch choice {
        case 0:
            print("\(numbers.count)つの中で最大値は\(GetMaxValue(v1: numbers[0], v2: numbers[1], v3: numbers[2]))です。")
        case 1:
            print("\(numbers.count)つの中で最小値は\(GetMinValue(v1: numbers[0], v2: numbers[1], v3: numbers[2]))です。")
        default:
            break
        }
    }
    
    func Question2() {
        print("冒険が今始まる！")
        var playerHp = 200 + Int.random(in: 0...100)
        var continueGame = true
        
        while continueGame {
            if playerHp == 0 {
                return
            }
            
            print("あなたのHP：\(playerHp)")
            print("奥に進みますか？（１：奥に進む　０：帰る）", terminator: "")
            let choice = Int(readLine()!)!
            continueGame = Bool(truncating: choice as NSNumber)
            if continueGame {
                let golemLv = Int.random(in: 0...4)
                AttackGolem(lv: golemLv, playerHp: &playerHp)
            }
        }
        print("リレ◯ト！")
    }
    
    func Question3() {
        return
    }
    
    func Question4() {
        return
    }
    
}
