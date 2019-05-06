//
//  K03.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K03 : IExecutable {
    public override func Question1() {
        print("年齢を入力してください＞")
        let age = Int(readLine()!)!
        
        if age < 20 {
            print("未成年なので購入できません。")
        }
    }
    
    public override func Question2() {
        print("身長を入力してください＞")
        var height = Double(readLine()!)!
        height /= 100.0
        print("体重を入力してください＞")
        let weight = Double(readLine()!)!
        
        let standard = height * height * 22.0
        print("あなたの標準体重は\(standard)です。")
        
        if weight > standard && (weight - standard) / standard * 100.0 > 14.0 {
            print("太り気味です。")
        }
        else if weight < standard && (weight - standard) / standard * 100.0 < -14.0 {
            print("痩せ気味です。")
        }
        else {
            print("普通ですね。")
        }
    }
    
    public override func Question3() {
        let randomNumber = Int.random(in: 0...99)
        print("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        let guess = Int(readLine()!)!
        print("決められた数値は\(randomNumber)です。")
        
        print(guess > randomNumber ? "正解です。" : "不正解です。")
    }
    
    public override func Question4() {
        let randomNumber = Int.random(in: 0...99)
        print("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        let guess = Int(readLine()!)!
        print("決められた数値は\(randomNumber)です。")
        
        if guess > 100 || guess < 0 {
            print("反則です！")
        }
        else if guess > randomNumber && guess - randomNumber <= 10 {
            print("大正解！")
        }
        else if guess < randomNumber && guess - randomNumber >= -10 {
            print("惜しい！")
        }
        else if guess == randomNumber {
            print("お見事！")
        }
        else {
            print(guess > randomNumber ? "正解です。" : "不正解です。")
        }
    }
}
