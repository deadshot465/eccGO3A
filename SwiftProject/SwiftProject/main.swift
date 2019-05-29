//
//  main.swift
//  SwiftProject
//
//  Created by 周哲輝 on 2019/05/05.
//  Copyright © 2019 周哲輝. All rights reserved.
//

import Foundation

func ShowSelections(chapter: Int) {
    if chapter < 10 {
        for i in 1...4 {
            print("\t\(i)) K0\(chapter)_\(i)")
        }
        if chapter == 9 {
            print("\t5) K0\(chapter)_5")
        }
    } else {
        for i in 1...4 {
            print("\t\(i)) K\(chapter)_\(i)")
        }
    }
}

var executables = [IDispatchable](arrayLiteral:
    K01(), K02(), K03(), K04(), K05(),
    K06(), K07(), K08(), K09(), K10(),
    K11(), FileControl())

print("実行したいプログラムを選択してください。")

for i in 1...executables.count {
    if i < 10 {
        print("\(i)) K0\(i)")
    }
    else {
        print("\(i)) K\(i)")
    }
}
print("100) Kex")

if let choice = Int(readLine()!) {
    if choice == 100 {
        Kex.Execute()
    } else {
        ShowSelections(chapter: choice)
        let choice2 = Int(readLine()!)
        if choice != 9 {
            executables[choice - 1].Execute(num: choice2!)
        }
        else {
            (executables[8] as! K09).Execute(num: choice2!)
        }
    }
}
