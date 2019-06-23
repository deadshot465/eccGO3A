//
//  Enemy.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/06/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public struct Enemy {
    let Lv: Int
    var Hp: Int
    let Defense: Int
    let Attack: Int
    let Hit: Int
    let Flee: Int
    let Name: String
    
    init() {
        Lv = 0
        Hp = 0
        Defense = 0
        Attack = 0
        Hit = 0
        Flee = 0
        Name = ""
    }
    
    init(lv: Int, hp: Int, defense: Int, attack: Int, hit: Int, flee: Int, name: String) {
        Lv = lv
        Hp = hp
        Defense = defense
        Attack = attack
        Hit = hit
        Flee = flee
        Name = name
    }
}
