import Foundation

class K02 : Question {
    func question1() {
        let seisuu = 3
        let jissuu = 2.6
        let moji: Character = "A"
        print("変数seisuuの値は\(seisuu)")
        print("変数jissuuの値は\(jissuu)")
        print("変数mojiの値は\(moji)")
    }

    func question2() {
        print("一つ目の整数は？")
        let a = readLine().flatMap { (s: String) in
            Int(s)
        } ?? 0
        print("二つ目の整数は？")
        let b = readLine().flatMap { (s: String) in
            Int(s)
        } ?? 1
        let result = a / b
        let modulo = a % b
        print("\(a)÷\(b)=\(result)...\(modulo)")
    }

    func question3() {
        print("一つ目の商品の値段は？")
        let priceA = readLine().flatMap { s in Float(s) } ?? 0
        print("個数は？")
        let amountA = readLine().flatMap { s in Float(s) } ?? 0
        print("一つ目の商品の値段は？")
        let priceB = readLine().flatMap { s in Float(s) } ?? 0
        print("個数は？")
        let amountB = readLine().flatMap { s in Float(s) } ?? 0
        let total = (priceA * amountA + priceB * amountB) * 1.1
        print("お支払いは税込み\(total)です。")
    }

    func question4() {
        var golem = Golem(hp: 300, defense: 80, attack: 50)
        print("ゴーレム　（HP：\(golem.hp) 防御力：\(golem.defense)）")
        print("HP：\(golem.hp)")
        print("今回の攻撃の値を入力してください＞")
        let damage = readLine().flatMap { s in Int(s) } ?? 0
        let actualDamage = damage - golem.defense <= 0 ? 0 : damage - golem.defense
        print("ダメージは\(actualDamage)です。")
        golem.hp -= actualDamage
        print("残りのHPは\(golem.hp)です。")
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