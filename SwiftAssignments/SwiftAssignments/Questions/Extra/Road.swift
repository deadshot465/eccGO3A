import Foundation

struct Pair : Equatable {
    let x: Character
    let y: Int

    init(x: Character, y: Int) {
        self.x = x
        self.y = y
    }
}

private struct Route : Comparable {
    let destination: Int
    let path: [Pair]

    init(destination: Int, path: [Pair]) {
        self.destination = destination
        self.path = path
    }

    static func <(lhs: Route, rhs: Route) -> Bool {
        if lhs.destination != rhs.destination {
            return lhs.destination < rhs.destination
        }

        if lhs.path.elementsEqual(rhs.path) {
            return false
        }

        let shorterPath = lhs.path.count < rhs.path.count ? lhs.path : rhs.path
        let longerPath = lhs.path.count > rhs.path.count ? lhs.path : rhs.path
        for (i, elem) in shorterPath.enumerated() {
            if elem.x != longerPath[i].x {
                return elem.x < longerPath[i].x
            }
            if elem.y != longerPath[i].y {
                return elem.y < longerPath[i].y
            }
        }
        return lhs.path.count < rhs.path.count
    }

    static func ==(lhs: Route, rhs: Route) -> Bool {
        if lhs.destination != rhs.destination {
            return false
        }

        return lhs.path.elementsEqual(rhs.path)
    }
}

private struct RoutingResult {
    let a: Route
    let b: Route

    init(a: Route, b: Route) {
        self.a = a
        self.b = b
    }
}

func runHeathrowToLondon() -> [Pair] {
    var numbers = parseMap(content: readFile())
    var acc: [(Int, Int, Int)] = []
    return optimalPath(values: groupValues(numbers: &numbers, acc: &acc))
}

private func groupValues(numbers: inout [Int], acc: inout [(Int, Int, Int)]) -> [(Int, Int, Int)] {
    if numbers.isEmpty {
        return acc
    } else {
        let a = numbers.removeFirst()
        let b = numbers.removeFirst()
        let x = numbers.removeFirst()
        acc.append((a, b, x))
        return groupValues(numbers: &numbers, acc: &acc)
    }
}

private func optimalPath(values: [(Int, Int, Int)]) -> [Pair] {
    let initialRoutingResult = RoutingResult(a: Route(destination: 0, path: []), b: Route(destination: 0, path: []))
    let routingResult = values.reduce(initialRoutingResult, shortestSteps)
    if let last = routingResult.a.path.last, last != Pair(x: "x", y: 0) {
        return routingResult.a.path
    } else if let last = routingResult.b.path.last, last != Pair(x: "x", y: 0) {
        return routingResult.b.path
    } else {
        return []
    }
}

private func parseMap(content: String) -> [Int] {
    let split = content.split(separator: "\r\n")
    return split
            .map { s in
                s.trimmingCharacters(in: .whitespacesAndNewlines)
            }
            .map { s in
                Int(s) ?? 0
            }
}

private func readFile() -> String {
    let filePath = FileManager.default.currentDirectoryPath + "/resources/road.txt"
    let fileHandle = FileHandle(forReadingAtPath: filePath)
    do {
        let content = try fileHandle?.readToEnd()
        if let content = content {
            let text = String(decoding: content, as: UTF8.self)
            try fileHandle?.close()
            return text
        }
    } catch {
        print("Error: \(error)")
    }
    return ""
}

private func shortestSteps(acc: RoutingResult, elem: (Int, Int, Int)) -> RoutingResult {
    let (a, b, x) = elem

    var pathA1 = acc.a.path
    pathA1.append(Pair(x: "a", y: a))
    let optA1 = Route(destination: acc.a.destination + a, path: pathA1)

    var pathA2 = acc.b.path
    pathA2.append(Pair(x: "b", y: b))
    pathA2.append(Pair(x: "x", y: x))
    let optA2 = Route(destination: acc.b.destination + b + x, path: pathA2)

    var pathB1 = acc.b.path
    pathB1.append(Pair(x: "b", y: b))
    let optB1 = Route(destination: acc.b.destination + b, path: pathB1)

    var pathB2 = acc.a.path
    pathB2.append(Pair(x: "a", y: a))
    pathB2.append(Pair(x: "x", y: x))
    let optB2 = Route(destination: acc.a.destination + a + x, path: pathB2)

    return RoutingResult(a: min(optA1, optA2), b: min(optB1, optB2))
}