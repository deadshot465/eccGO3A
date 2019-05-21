//
//  K11.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/22.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

class K11 : IDispatchable {
    func Question1() {
        var ages = [Int]()
        let MAX_PEOPLE = 5
        
        for i in 1...MAX_PEOPLE {
            print("\(i)人目の年齢を入力してください＞", terminator: "")
            ages.append(Int(readLine()!)!)
        }
        
        let average = ages.reduce(0, +) / ages.count
        print("\(ages.count)人の平均年齢は\(average)です。")
    }
    
    func Question2() {
        print("１つ目の文字列を入力してください。＞", terminator: "")
        var str1 = readLine()!
        print("２つ目の文字列を入力してください。＞", terminator: "")
        let str2 = readLine()!
        str1 += str2
        print("\(str1)の文字数は\(str1.count)です。")
    }
    
    func Question3() {
        var chr: Character
        print("文字を入力してください。＞", terminator: "")
        chr = readLine()!.first!
        var applied = false
        
        if chr.isNumber {
            print("この文字は数字です。")
            applied = true
        }
        if chr.isUppercase {
            print("この文字は英大文字です。")
            applied = true
        }
        if chr.isLowercase {
            print("この文字は英小文字です。")
            applied = true
        }
        if chr.isHexDigit {
            print("この文字は16進数として使える文字です。")
            applied = true
        }
        if chr.isPunctuation {
            print("この文字は区切り文字です。")
            applied = true
        }
        if !applied {
            print("この文字はよくわからない文字です。")
        }
    }
    
    func Question4() {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        let inputString = "I am a STUDENT. I am good at GAME PROGRAMMING."
        var count = 0
        var _count = 0
        
        print("文字列：\(inputString)")
        print("\n文字頻度")
        for s in alphabets {
            for _s in inputString {
                if String(s) == _s.uppercased() {
                    count += 1
                }
            }
            print("\(s): \(count)\t", terminator: "")
            count = 0
            _count += 1
            if _count % 4 == 0 {
                print()
            }
        }
        print()
    }
    
    
}
