//
//  Golem.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

let GOLEM_HIT = 70
let GOLEM_FLEE = 20

public struct Golem {
    var hp = 300
    var defense = 80
    var attack = 50
    
    init() {
        
    }
    
    init(hp: Int = 300, defense: Int = 80, attack: Int = 50) {
        self.hp = hp
        self.defense = defense
        self.attack = attack
    }
}

public struct GolemEx {
    var Hp: Int
    var Defense: Int
    var Attack: Int
    let Hit = GOLEM_HIT
    let Flee = GOLEM_FLEE
    
    init(hp: Int, defense: Int, attack: Int) {
        Hp = hp
        Defense = defense
        Attack = attack
    }
}
