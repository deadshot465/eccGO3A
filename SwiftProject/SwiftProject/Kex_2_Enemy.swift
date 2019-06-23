//
//  Kex_2_Enemy.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/06/24.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public enum EnemyType: Int {
    case TYPE_GOLEM = 0, TYPE_GOBLIN = 1, TYPE_SLIME = 2
}

let MAX_GOLEM_LEVEL = 4
let MAX_GOBLIN_LEVEL = 6
let MAX_SLIME_LEVEL = 8
let GOBLIN_HIT = 85
let GOBLIN_FLEE = 40
let SLIME_HIT = 95
let SLIME_FLEE = 30

public func CreateEnemy(type: EnemyType) -> Enemy {
    var enemy = Enemy()
    switch type {
    case .TYPE_GOLEM:
        let lv = Int.random(in: 0...MAX_GOLEM_LEVEL)
        enemy = Enemy(lv: lv, hp: lv * 50 + 100, defense: lv * 10 + 40, attack: lv * 10 + 40, hit: GOLEM_HIT, flee: GOLEM_FLEE, name: "ゴーレム")
    case .TYPE_GOBLIN:
        let lv = Int.random(in: 0...MAX_GOBLIN_LEVEL)
        enemy = Enemy(lv: lv, hp: lv * 30 + 75, defense: lv * 5 + 20, attack: lv * 5 + 20, hit: GOBLIN_HIT, flee: GOBLIN_FLEE, name: "ゴブリン")
    case .TYPE_SLIME:
        let lv = Int.random(in: 0...MAX_SLIME_LEVEL)
        enemy = Enemy(lv: lv, hp: lv * 10 + 50, defense: lv * 2 + 10, attack: lv * 2 + 10, hit: SLIME_HIT, flee: SLIME_FLEE, name: "スライム")
    }
    return enemy
}
