export default function rpn(input: string) {
    const ops = input.split(' ');
    const result = ops.reduce(innerRpn, []);
    const finalValue = result.pop();
    return result.length === 0 ? finalValue : null;
}

function innerRpn(acc: number[], op: string): number[] {
    switch (op) {
        case "+":
        case "-":
        case "*":
        case "/":
        case "^":
            {
                const n1 = acc.pop() ?? 0.0;
                const n2 = acc.pop() ?? 0.0;
                switch (op) {
                    case "+":
                        acc.push(n2 + n1);
                        break;
                    case "-":
                        acc.push(n2 - n1);
                        break;
                    case "*":
                        acc.push(n2 * n1);
                        break;
                    case "/":
                        acc.push(n2 / n1);
                        break;
                    case "^":
                        acc.push(Math.pow(n2, n1));
                        break;
                }
            }
            break;
        case "ln":
            {
                const n1 = acc.pop() ?? 0.0;
                acc.push(Math.log(n1));
            }
            break;
        case "log10":
            {
                const n1 = acc.pop() ?? 0.0;
                acc.push(Math.log10(n1));
            }
            break;
        case "sum":
            {
                const sum = acc.reduce((prev, curr) => prev + curr);
                acc = [];
                acc.push(sum);
            }
            break;
        case "prod":
            {
                const product = acc.reduce((prev, curr) => prev * curr);
                acc = [];
                acc.push(product);
            }
            break;
        default:
            acc.push(Number.parseFloat(op));
            break;
    }
    return acc;
}