//
//  K06.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K06 : IExecutable {
    public override func Question1() {
        var ages = [Int]()
        
        for i in 1...5 {
            print("\(i)人目の年齢を入力してください＞", terminator: "")
            ages.append(Int(readLine()!)!)
        }
        
        let average = ages.reduce(0, +) / ages.count
        print("\(ages.count)人の平均年齢は\(average)です。")
    }
    
    public override func Question2() {
        for i in 1...9 {
            for _ in 1...i {
                print("*", terminator: "")
            }
            print()
        }
        print()
        
        for i in stride(from: 9, to: 0, by: -1) {
            for _ in 1...i {
                print("*", terminator: "")
            }
            print()
        }
        print()
        
        for i in stride(from: 9, to: 0, by: -1) {
            for _ in stride(from: 0, to: i - 1, by: 1) {
                print(" ", terminator: "")
            }
            
            for _ in stride(from: 9, to: i - 1, by: -1) {
                print("*", terminator: "")
            }
            print()
        }
    }
    
    public override func Question3() {
        let total = 370
        var count = 0
        
        for i in 0...(total / 100) {
            for j in 0...(total / 50) {
                for k in 0...(total / 10) {
                    if 100 * i + 50 * j + 10 * k == total {
                        print("10円の硬貨\(k)枚　50円の硬貨\(j)枚　100円の硬貨\(i)枚")
                        count += 1
                    }
                }
            }
        }
        
        print("以上\(count)通りを発見しました。")
    }
    
    public override func Question4() {
        print("\t|\t", terminator: "")
        for i in 1...9 {
            print("\(i)\t", terminator: "")
        }
        print()
        
        for _ in 0...75 {
            print("-", terminator: "")
        }
        print()
        
        for i in 1...9 {
            print("\(i)\t|\t", terminator: "")
            for j in 1...9 {
                print("\(i * j)\t", terminator: "")
            }
            print()
        }
    }
}
