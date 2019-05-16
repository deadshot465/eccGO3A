//
//  K09.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/16.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

class K09 : IDispatchable {
    
    func Question1() {
        var ages = Array(repeating: 0, count: 3)
        for i in ages.indices {
            print("\(i + 1)人目の年齢を入力＞", terminator: "")
            ages[i] = Int(readLine()!)!
        }
        
        for _ in 1...25 {
            print("-", terminator: "")
        }
        print()
        
        for (n, age) in ages.enumerated() {
            print("\(n + 1)人目：\(age)歳")
        }
        
        let average = (Float(ages.reduce(0, +)) / Float(ages.count) * 10.0).rounded() / 10.0
        print("平均年齢：\(average)歳")
        
    }
    
    func Question2() {
        let numbers = [8, 3, 12, 7, 9]
        print("元々の配列：", terminator: "")
        for num in numbers {
            print("\(num) ", terminator: "")
        }
        print()
        
        print("逆順での表示：", terminator: "")
        for num in numbers.reversed() {
            print("\(num) ", terminator: "")
        }
    }
    
    func Question3() {
        let studentScores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ]
        
        print("\t\t|\t科目A\t科目B\t科目C\t科目D")
        for _ in 1...45 {
            print("-", terminator: "")
        }
        print()
        
        for (n, student) in studentScores.enumerated() {
            print("学生\(n + 1)\t|\t", terminator: "")
            for score in student {
                print("\(score)\t\t", terminator: "")
            }
            print()
        }
        
    }
    
    func Question4() {
        let studentScores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ]
        
        var total = 0
        var average = [Float](arrayLiteral: 0.0, 0.0, 0.0, 0.0)
        
        print("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点")
        for _ in 1...65 {
            print("-", terminator: "")
        }
        print()
        
        for (n, student) in studentScores.enumerated() {
            print("学生\(n + 1)\t|\t", terminator: "")
            for (i, score) in student.enumerated() {
                print("\(score)\t\t", terminator: "")
                total += score
                average[i] += Float(score)
            }
            print("|\t\(total)")
            total = 0
        }
        print("平均点\t|\t", terminator: "")
        for score in average {
            let _rounded = (score / 3.0 * 10.0).rounded() / 10.0
            print("\(_rounded)\t", terminator: "")
        }
        print("|")
    }
    
    func Question5() {
        var numbers = [Int]()
        for i in 0...99 {
            print("\(i + 1)件目の入力：", terminator: "")
            numbers.append(Int(readLine()!)!)
            if (numbers[i] < 0) {
                break
            }
        }
        print("-----並び替え後-----")
        _ = numbers.popLast()
        for num in numbers.sorted() {
            print(num)
        }
    }
}

extension K09 {
    public func Execute(num: Int) {
        switch num {
        case 1:
            Question1()
        case 2:
            Question2()
        case 3:
            Question3()
        case 4:
            Question4()
        case 5:
            Question5()
        default:
            break
        }
    }
}
