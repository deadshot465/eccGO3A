import Foundation

public func rpn(input: String) -> Float? {
    var result = input.split(separator: " ").reduce(into: [], { (acc: inout [Float], s : Swift.String.SubSequence) in
        let _ = innerRpn(stack: &acc, op: String(s))
    })
    let finalResult = result.popLast()
    return result.count > 0 ? nil : finalResult
}

private func innerRpn(stack: inout [Float], op: String) -> [Float] {
    switch op {
    case "+":
        fallthrough
    case "-":
        fallthrough
    case "*":
        fallthrough
    case "/":
        fallthrough
    case "^":
        let n1 = stack.popLast() ?? 0.0
        let n2 = stack.popLast() ?? 0.0
        switch op {
        case "+":
            stack.append(n2 + n1)
            return stack
        case "-":
            stack.append(n2 - n1)
            return stack
        case "*":
            stack.append(n2 * n1)
            return stack
        case "/":
            stack.append(n2 / n1)
            return stack
        case "^":
            stack.append(powf(n2, n1))
            return stack
        default:
            return stack
        }
    case "ln":
        let n1 = stack.popLast() ?? 0.0
        stack.append(logf(n1))
        return stack
    case "log10":
        let n1 = stack.popLast() ?? 0.0
        stack.append(log10f(n1))
        return stack
    case "sum":
        let result = stack.reduce(0.0, { (acc, x) in
            acc + x
        })
        stack = [result]
        return stack
    case "prod":
        let result = stack.reduce(1.0, { (acc, x) in
            acc * x
        })
        stack = [result]
        return stack
    default:
        stack.append(Float(op) ?? 0.0)
        return stack
    }
}