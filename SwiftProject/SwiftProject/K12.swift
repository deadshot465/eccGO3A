//
//  K12.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/06/08.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

struct Person {
    var Name: String
    var BirthYear: Int
    var Height: Float
    var Weight: Float
    
    init(name: String = "", birthYear: Int = 0, height: Float = 0.0, weight: Float = 0.0) {
        self.Name = name
        self.BirthYear = birthYear
        self.Height = height
        self.Weight = weight
    }
}

struct Staff {
    let Name: String
    let Gender: Character
    let Age: Int
    
    init(name: String, gender: Character, age: Int) {
        self.Name = name
        self.Gender = gender
        self.Age = age
    }
}

struct Position {
    let X: Int
    let Y: Int
    var Distance: Double
    
    init(x: Int, y: Int, distance: Double = 0.0) {
        self.X = x
        self.Y = y
        self.Distance = distance
    }
}

class K12 : IDispatchable {
    func Question1() {
        var person = Person()
        print("名前を入力してください＞", terminator: "")
        person.Name = readLine()!
        print("生年（西暦）を入力してください＞", terminator: "")
        person.BirthYear = Int(readLine()!)!
        print("身長を入力してください＞", terminator: "")
        person.Height = Float(readLine()!)!
        print("体重を入力してください＞", terminator: "")
        person.Weight = Float(readLine()!)!
        
        print("プロファイル")
        print("名前：\(person.Name)")
        print("生年：\(person.BirthYear)")
        print("身長：\(person.Height)")
        print("体重：\(person.Weight)")
    }
    
    func Question2() {
        let staffs = [Staff](arrayLiteral:
            Staff(name: "神木隆之介", gender: "M", age: 23),
            Staff(name: "上白石萌音", gender: "F", age: 18),
            Staff(name: "長澤まさみ", gender: "F", age: 28)
        )
        
        print("名前\t\t性別\t年齢")
        for _ in 1...35 {
            print("-", terminator: "")
        }
        print()
        for staff in staffs {
            print("\(staff.Name)\t\(staff.Gender)\t\(staff.Age)歳")
        }
    }
    
    func GetDistance(playerPos: Position, enemyPos: Position) -> Double {
        let diffX = playerPos.X - enemyPos.X
        let diffY = playerPos.Y - enemyPos.Y
        return sqrt(Double(diffX * diffX + diffY * diffY))
    }
    
    func Question3() {
        let getRandomNumber = {
            () -> Int in
            return Int.random(in: 0...99) - 50
        }
        
        let playerPos = Position(x: getRandomNumber(), y: getRandomNumber())
        var enemyPos = [Position]()
        
        for _ in 0...4 {
            var pos = Position(x: getRandomNumber(), y: getRandomNumber())
            pos.Distance = GetDistance(playerPos: playerPos, enemyPos: pos)
            enemyPos.append(pos)
        }
        
        print(String(format: "プレイヤーの座標：x= %5.2f\t\ty= %5.2f", Float(playerPos.X), Float(playerPos.Y)))
        for enemy in enemyPos.enumerated() {
            let str = String(
                format: "敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f", enemy.offset, Float(enemy.element.X), Float(enemy.element.Y), enemy.element.Distance)
            print("\(str)")
        }
    }
    
    func Question4() {
        let getRandomNumber = {
            () -> Int in
            return Int.random(in: 0...99) - 50
        }
        
        let playerPos = Position(x: getRandomNumber(), y: getRandomNumber())
        var enemyPos = [Position]()
        
        for _ in 0...4 {
            var pos = Position(x: getRandomNumber(), y: getRandomNumber())
            pos.Distance = GetDistance(playerPos: playerPos, enemyPos: pos)
            enemyPos.append(pos)
        }
        
        print(String(format: "プレイヤーの座標：x= %5.2f\t\ty= %5.2f", Float(playerPos.X), Float(playerPos.Y)))
        for enemy in enemyPos.enumerated() {
            let str = String(
                format: "敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f", enemy.offset, Float(enemy.element.X), Float(enemy.element.Y), enemy.element.Distance)
            print("\(str)")
        }
        
        print("\n並び替え後")
        enemyPos.sort(by: {
            (a: Position, b: Position) -> Bool in
            return a.Distance < b.Distance
        })
        for enemy in enemyPos.enumerated() {
            let str = String(
                format: "敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f", enemy.offset, Float(enemy.element.X), Float(enemy.element.Y), enemy.element.Distance)
            print("\(str)")
        }
    }
    
    
}
