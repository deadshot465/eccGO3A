import Foundation

class K06 : Question {
    func question1() {
        let ages = getAges(number: 5)
        let count = ages.count
        let totalAges = ages.reduce(0.0, { acc, x in acc + x }) / Float(count)
        print("\(count)人の平均年齢は\(totalAges)です。")
    }

    func question2() {
        let upperPyramid = makeUpperPyramid(levels: 8).joined(separator: "\n")
        print(upperPyramid)
        print("")
        let lowerPyramid = makeLowerPyramid(levels: 8).joined(separator: "\n")
        print(lowerPyramid)
        print("")
        let specialPyramid = makeSpecialPyramid(levels: 8).joined(separator: "\n")
        print(specialPyramid)
        print("")
    }

    func question3() {
        let combinations = countHundreds(remains: 370).map { (h, f, t) in
            "10円の硬貨\(t)枚 50円の硬貨\(f)枚 100円の硬貨\(h)枚"
        }
        let count = combinations.count
        print(combinations.joined(separator: "\n") + "\n")
        print("以上\(count)通りを発見しました。")
    }

    func question4() {
        print("\t|\t", terminator: "")
        let numbers: [String] = Array(1...9).map { (i: Int) in String(i) }
        print(numbers.joined(separator: "\t"))
        print(String(repeating: "-", count: 90))

        var calculations: [[Int]] = []
        for i in 1...9 {
            var multiplications: [Int] = []
            for j in 1...9 {
                multiplications.append(i * j)
            }
            calculations.append(multiplications)
        }

        let result: [String] = calculations
                .enumerated()
                .map { (index: Int, nums: [Int]) in
                    let innerList = nums.map { i in String(i) }.joined(separator: "\t")
                    return "\(index + 1)\t|\t\(innerList)"
                }

        print(result.joined(separator: "\n"))
    }

    private func getAges(number: Int) -> [Float] {
        var numbers: [Float] = []
        for i in 0..<number {
            print("\(i + 1)人目の年齢を入力して下さい：")
            numbers.append(readLine().flatMap { s in Float(s) } ?? 0)
        }
        return numbers
    }

    private func makeUpperPyramid(levels: Int) -> [String] {
        var stars: [String] = []
        for i in 0..<levels {
            stars.append(String(repeating: "*", count: i + 1))
        }
        return stars
    }

    private func makeLowerPyramid(levels: Int) -> [String] {
        var stars: [String] = []
        for i in stride(from: levels, through: 1, by: -1) {
            stars.append(String(repeating: "*", count: i))
        }
        return stars
    }

    private func makeSpecialPyramid(levels: Int) -> [String] {
        var stars: [String] = []
        for i in 0..<levels {
            let str = String(repeating: " ", count: 8 - (i + 1)) + String(repeating: "*", count: i + 1)
            stars.append(str)
        }
        return stars
    }

    private func countTens(remains: Int) -> Int {
        remains / 10
    }

    private func countFifties(remains: Int) -> [(Int, Int)] {
        let max = remains / 50
        var combinations: [(Int, Int)] = []
        for i in stride(from: max, through: 0, by: -1) {
            let remaining = remains - (50 * i)
            combinations.append((i, countTens(remains: remaining)))
        }
        return combinations
    }

    private func countHundreds(remains: Int) -> [(Int, Int, Int)] {
        let max = remains / 100
        var combinations: [(Int, Int, Int)] = []
        for i in stride(from: max, through: 0, by: -1) {
            let remaining = remains - (100 * i)
            let combinationsWithHundred = countFifties(remains: remaining).map { (f, t) in (i, f, t) }
            combinations.append(contentsOf: combinationsWithHundred)
        }
        return combinations
    }

}