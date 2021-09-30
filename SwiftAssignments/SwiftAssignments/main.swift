import Foundation

let questions: [Question] = [K01(), K02(), K03(), K04(), K05(), K06(), K07(), K08()]

private func showSelections(chapter: Int) {
    let prefix = chapter < 10 ? "K0" : "K"
    [1, 2, 3, 4].forEach { i in
        print("\t\(i)) \(prefix)\(chapter)_\(i)")
    }
}

print("実行したいプログラムを選択してください。")
questions.enumerated().forEach { (i: Int, _) in
    let prefix = i < 10 ? "K0" : "K"
    print("\(i + 1)) \(prefix)\(i + 1)\t\t", terminator: "")
}
print("")
let choice = readLine().flatMap { s in Int(s) } ?? 1
showSelections(chapter: choice)
let choice2 = readLine().flatMap { s in Int(s) } ?? 1
questions[choice - 1].execute(number: choice2)