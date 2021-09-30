//
// Created by 周哲輝 on 2021/10/01.
//

import Foundation

enum AgeTier {
    case error, free, half, tenPercentOff, normal
}

class K07 : Question {
    func question1() {
        var choice = 1
        while choice != 0 {
            print("メッセージを表示しますか？（０：終了する　１：表示する）＞")
            choice = readLine().flatMap { s in Int(s) } ?? 1
            if choice != 0 {
                showTexts()
            }
        }
    }

    func question2() {
        let numbers = K07.getNumbers(count: 3)
        let maxValue = numbers.max() ?? numbers[0]
        print("\(numbers.count)つの中で最大値は\(maxValue)")
    }

    func question3() {
        print("年齢を入力して下さい。＞")
        switch getAgeTier(age: readLine().flatMap { s in Int(s) } ?? 0) {
        case .error:
            print("反則です！")
        case .free:
            print("入場料金無料です。")
        case .half:
            print("子供料金で半額です。")
        case .tenPercentOff:
            print("シニア割引で一割引です。")
        case .normal:
            print("通常料金です。")
        }
    }

    func question4() {
    }

    static func getNumbers(count: Int) -> [Int] {
        var numbers: [Int] = []
        for i in 1...count {
            print("\(i)つ目の値を入力してください。＞")
            numbers.append(readLine().flatMap { s in Int(s) } ?? 0)
        }
        return numbers
    }

    private func showTexts() {
        print("Hello World!")
        print("ようこそ")
        print("Swiftの世界へ！")
    }

    private func getAgeTier(age: Int) -> AgeTier {
        switch age {
        case let x where x < 0:
            return .error
        case let x where x < 3 || age >= 70:
            return .free
        case let x where x >= 3 && x <= 15:
            return .half
        case let x where x >= 60 && age < 70:
            return .tenPercentOff
        default:
            return .normal
        }
    }
}