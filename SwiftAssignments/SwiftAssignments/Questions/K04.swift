import Foundation

class K04 : Question {
    func question1() {
        print("年齢を入力してください。＞")
        let age = readLine().flatMap { s in Int(s) } ?? 0
        if age < 3 || age >= 70 {
            print("入場料金無料です。")
        } else {
            print("通常料金です。")
        }
    }

    func question2() {
        print("性別を選択してください。（０：男性　１：女性）＞")
        let gender = readLine().flatMap { s in Int(s) } ?? 2
        switch gender {
        case 0:
            print("あら、格好良いですね。")
        case 1:
            print("あら、モデルさんみたいですね。")
        default:
            print("そんな選択肢はありません。")
        }
    }

    func question3() {
        print("年齢を入力してください。＞")
        let age = readLine().flatMap { s in Int(s) } ?? 0
        if age < 0 {
            print("反則です！")
        } else if age < 3 || age >= 70 {
            print("入場料金無料です。")
        } else if age >= 3 && age <= 15 {
            print("子供料金で半額です。")
        } else if age >= 60 && age < 70 {
            print("シニア割引で一割引です。")
        } else {
            print("通常料金です。")
        }
    }

    func question4() {
        print("＊＊＊おみくじプログラム＊＊＊")
        print("おみくじを引きますか　（はい：１　いいえ：０）")
        let choice = readLine().flatMap { s in Int(s) } ?? 0
        if choice < 1 {
            return
        }

        let oracle = Int.random(in: 0...4)
        switch oracle {
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