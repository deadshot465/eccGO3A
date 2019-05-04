//
//  K02.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K02 : IExecutable {
    public override func Question1() {
        let seisuu = 3
        let jissuu = 2.6
        let moji = "A"
        
        print("整数seisuuの値は\(seisuu)")
        print("実数jissuuの値は\(jissuu)")
        print("文字mojiの値は\(moji)")
    }
    
    public override func Question2() {
        print("一つ目の整数は？")
        let firstNumber = Int(readLine()!)!
        print("二つ目の整数は？")
        let secondNumber = Int(readLine()!)!
        
        print("\(firstNumber)÷\(secondNumber)=\(firstNumber / secondNumber)...\(firstNumber % secondNumber)")
    }
    
    public override func Question3() {
        print("一つ目の商品の値段は？")
        let priceA = Int(readLine()!)!
        print("個数は？")
        let amountA = Int(readLine()!)!
        print("二つ目の商品の値段は？")
        let priceB = Int(readLine()!)!
        print("個数は？")
        let amountB = Int(readLine()!)!
        
        let total = Float((priceA * amountA + priceB * amountB)) * 1.08
        print("お支払いは税込み￥\(total)です。")
    }
    
    public override func Question4() {
        
        var golem = Golem()
        
        print("ゴーレム　（HP：\(golem.hp) 防御力：\(golem.defense)）")
        print("HP：\(golem.hp)")
        print("今回の攻撃の値を入力してください＞")
        var damage = Int(readLine()!)!
        
        damage = damage - golem.defense > 0 ? damage - golem.defense : 0
        print("ダメージは\(damage)です。")
        golem.hp -= damage
        print("残りのHPは\(golem.hp)です。")
    }
    
    
}
