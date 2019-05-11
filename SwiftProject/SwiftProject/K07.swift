//
//  K07.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/11.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K07 : IExecutable {
    func ShowText() {
        print("Hello World!")
        print("ようこそ")
        print("Swift言語の世界へ！")
    }
    
    func GetMaxValue(v1: Int, v2: Int, v3: Int) -> Int {
        var temp = v1 >= v2 ? v1 : v2
        temp = temp >= v3 ? temp : v3
        return temp
    }
    
    func GetType(age: Int) -> Int {
        switch age {
        case let age where age <= 0:
            return 0
        case let age where age < 3 || age >= 70:
            return 1
        case let age where age >= 3 && age <= 15:
            return 2
        case let age where age >= 60 && age < 70:
            return 3
        default:
            return 4
        }
    }
    
    public override func Question1() {
        var choice: Int = 1
        
        while choice != 0 {
            print("メッセージを表示しますか？（０：終了する　１：表示する）＞", terminator: "")
            choice = Int(readLine()!)!
            if choice == 1 {
                self.ShowText()
            }
        }
        print("終了します。")
    }
    
    public override func Question2() {
        var numbers = [Int]()
        for i in 1...3 {
            print("\(i)つ目の値を入力してください。＞", terminator: "")
            numbers.append(Int(readLine()!)!)
        }
        
        let maxValue = self.GetMaxValue(v1: numbers[0], v2: numbers[1], v3: numbers[2])
        print("\(numbers.count)つの中で最大値は\(maxValue)です。")
    }
    
    public override func Question3() {
        var age = 0
        var no = 0
        print("年齢を入力してください。＞")
        age = Int(readLine()!)!
        
        no = self.GetType(age: age)
        
        switch no {
        case 0:
            print("不適切な値が入力されました。")
        case 1:
            print("入場料金無料です。")
        case 2:
            print("子供料金で半額です。")
        case 3:
            print("シニア割引で１割引です。")
        default:
            print("通常料金です。")
        }
    }
    
    public override func Question4() {
        return
    }

}
