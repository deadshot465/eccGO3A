//
//  K10.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/16.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

class K10 : IDispatchable {
    func Question1() {
        var inputStr = ""
        print("文字列の入力＞", terminator: "")
        inputStr = readLine()!
        print("入力された文字列の文字数：\(inputStr.count)")
    }
    
    func Question2() {
        let str = "STRINGcopy"
        print("コピーしたい文字列：\(str)")
        let copyStr = str
        print("コピー後の文字列：\(copyStr)")
    }
    
    func Question3() {
        let str = [
            "abcdef", "GHIJKL", "13579"
        ]
        var strCombined = ""
        print("連結したい３つの文字列：")
        for s in str {
            print(s)
            strCombined += s
        }
        print("連結した文字列：\(strCombined)")
    }
    
    func Question4() {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        let inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."
        var count = 0
        var _count = 0
        
        print("文字列：\(inputString)")
        print("\n文字頻度")
        for s in alphabets {
            for _s in inputString {
                if s == _s {
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
    }
}
