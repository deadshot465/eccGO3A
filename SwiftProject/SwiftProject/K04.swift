//
//  K04.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

public class K04 : IExecutable {
    public override func Question1() {
        print("年齢を入力してください＞")
        let age = Int(readLine()!)!
        
        if age < 3 || age >= 70 {
            print("入場料金無料です。")
        }
        else {
            print("通常料金です。")
        }
    }
    
    public override func Question2() {
        print("性別を選択してください＞　（０：男性　１：女性）")
        let gender = Int(readLine()!)!
        
        switch gender {
        case 0:
            print("あら、格好良いですね。")
        case 1:
            print("あら、モデルさんみたいですね。")
        default:
            print("そんな選択肢はありません。")
        }
    }
    
    public override func Question3() {
        print("年齢を入力してください＞")
        let age = Int(readLine()!)!
        
        if age < 3 || age >= 70 {
            print("入場料金無料です。")
        }
        else if age >= 3 && age <= 15 {
            print("子供料金で半額です。")
        }
        else if age >= 60 && age < 70 {
            print("シニア割引で一割引です。")
        }
        else {
            print("通常料金です。")
        }
    }
    
    public override func Question4() {
        print("＊＊＊おみくじプログラム＊＊＊")
        print("おみくじを引きますか　（はい：１　いいえ：０）")
        let choice = Int(readLine()!)!
        
        if choice >= 1 {
            let randomNumber = Int.random(in: 0...4)
            switch randomNumber {
            case 0:
                print("大吉　とってもいいことがありそう！")
            case 1:
                print("中吉　きっといいことあるんじゃないかな")
            case 2:
                print("小吉　少しぐらいはいいことあるかもね")
            case 3:
                print("凶　今日はおとなしくておいた方がいいかも")
            case 4:
                print("大凶　これじゃやばくない？早く家に帰った方がいいかも")
            default:
                break
            }
        }
    }
}
