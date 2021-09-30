import Foundation

class K03 : Question {
    func question1() {
        print("年齢を入力してください。＞")
        let age = readLine().flatMap { s in Int(s) } ?? 0
        if age < 20 {
            print("未成年なので購入できません。")
        }
    }

    func question2() {
        print("身長を入力してください。＞")
        let height = readLine()
                .flatMap { s in Float(s) }
                .map { f in f * 0.01 } ?? 1.0
        print("体重を入力してください。＞")
        let weight = readLine().flatMap { s in Float(s) } ?? 0.0
        let standard = height * height * 22.0
        print("あなたの標準体重は\(standard)です。")

        if weight > standard && (weight - standard) / standard * 100.0 > 14.0 {
            print("太り気味です。")
        } else if weight < standard && (weight - standard) / standard * 100.0 < -14.0 {
            print("痩せ気味です。")
        } else {
            print("普通ですね。")
        }
    }

    func question3() {
        let num = Int.random(in: 0..<100)
        print("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        let guess = readLine().flatMap { s in Int(s) } ?? 0
        print("決められた数値は\(num)です。")
        if guess > num {
            print("正解です。")
        } else {
            print("不正解です。")
        }
    }

    func question4() {
        let num = Int.random(in: 0..<100)
        print("０から９９の範囲の数値が決定されました。")
        print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")
        let guess = readLine().flatMap { s in Int(s) } ?? 0
        print("決められた数値は\(num)です。")

        if guess < 0 || guess > 99 {
            print("反則です！")
        } else if guess > num && guess - num <= 10 {
            print("大正解です！")
        } else if guess < num && num - guess <= 10 {
            print("惜しい！")
        } else if guess == num {
            print("お見事！")
        } else {
            if guess > num {
                print("正解です。")
            } else {
                print("不正解です。")
            }
        }
    }

    func execute(number: Int) {
        switch number {
        case 1:
            question1()
        case 2:
            question2()
        case 3:
            question3()
        case 4:
            question4()
        default:
            break
        }
    }


}