namespace CSharpRewrite.Assignments.Extra;

using System.Linq;

public static class Rpn
{
    public static float? Run(string input)
    {
        var ops = input.Split(' ')
            .Aggregate(new Stack<float>(), Run);
        var result = ops.Pop();
        return ops.Count == 0 ? result : null;
    }

    private static Stack<float> Run(Stack<float> acc, string op)
    {
        switch (op)
        {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                var a = acc.Pop();
                var b = acc.Pop();
                acc.Push(op switch
                {
                    "+" => b + a,
                    "-" => b - a,
                    "*" => b * a,
                    "/" => b / a,
                    "^" => MathF.Pow(b, a),
                    _ => 0.0f
                });
                break;
            case "ln":
                var c = acc.Pop();
                acc.Push(MathF.Log(c));
                break;
            case "log10":
                var d = acc.Pop();
                acc.Push(MathF.Log10(d));
                break;
            case "sum":
                var sum = acc.Sum();
                acc = new Stack<float>();
                acc.Push(sum);
                break;
            case "prod":
                var product = acc.Aggregate((n1, n2) => n1 * n2);
                acc = new Stack<float>();
                acc.Push(product);
                break;
            default:
                acc.Push(float.Parse(op));
                break;
        }

        return acc;
    }
}