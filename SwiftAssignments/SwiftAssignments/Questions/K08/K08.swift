//
// Created by 周哲輝 on 2021/10/01.
//

import Foundation

class K08 : Question {
    func question1() {
        let numbers = K07.getNumbers(count: 3)
        print("どちらを調べますか？")
        print("（０：最大値　１：最小値）＞")
        let choice = readLine().flatMap { s in Int(s) } ?? 0
        let (text, result) = choice == 0 ? ("最大値", numbers.max() ?? numbers[0]) : ("最小値", numbers.min() ?? numbers[0])
        print("\(numbers.count)つの中で\(text)は\(result)")
    }

    func question2() {
        print("冒険が今始まる！")
        var playerHp = 200 + Int.random(in: 0...100)
        print(gameLoop(playerHp: &playerHp))
    }

    func question3() {
    }

    func question4() {
    }
}