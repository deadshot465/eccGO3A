//
//  Kex.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class Kex {
    public static func Execute() {
        print("冒険が今始まる！")
        var player = Player()
        var continue_game = 1
        var kills = 0
        while continue_game != 0 {
            print("現HP：\(player.Hp)")
            print("奥に進みますか？（１．奥に進む　２．帰る）")
            continue_game = Int(readLine()!)!
            if continue_game != 0 {
                let golem_lv = Int.random(in: 0...4)
                AttackGolemEx(lv: golem_lv, player: &player)
                kills += 1
                if player.Hp == 0 {
                    break
                }
            }
        }
        print("リ◯ミト！")
        print("戦闘回数：\(kills)回　残りHP：\(player.Hp)")
    }
}
