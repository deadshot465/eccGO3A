//
//  Kex_2.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/06/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class Kex_2 {
    public static func Execute() {
        print("冒険が今始まる！")
        var player = Player()
        var continueGame = 1
        var kills = 0
        
        while continueGame != 0 {
            print("現HP：\(player.Hp)")
            print("奥に進みますか＞？（１：奥に進む　０：帰る）＞", terminator: "")
            continueGame = Int(readLine()!)!
            if continueGame == 1 {
                let type = EnemyType(rawValue: Int.random(in: 0...2))!
                var enemy = CreateEnemy(type: type)
                let result = AttackEnemy(player: &player, enemy: &enemy)
                kills += 1
                
                if !result {
                    break
                }
            }
        }
        print("リ○ミト！\n")
        print("戦闘回数：\(kills)回　残りHP：\(player.Hp)")
    }
}
