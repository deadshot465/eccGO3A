using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K02 : IQuestion
{
    public void Question1()
    {
        const int seisuu = 3;
        const float jissuu = 2.6f;
        const char moji = 'A';

        Console.WriteLine("変数seisuuの値は" + seisuu);
        Console.WriteLine("変数jissuuの値は" + jissuu);
        Console.WriteLine("変数mojiの値は" + moji);
    }

    public void Question2()
    {
        try
        {
            Console.Write("一つ目の整数は？");
            var a = int.Parse(Console.ReadLine() ?? "0");
            Console.Write("二つ目の整数は？");
            var b = int.Parse(Console.ReadLine() ?? "0");

            Console.WriteLine($"{a}÷{b}={a / b}...{a % b}");

        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question3()
    {
        try
        {
            Console.Write("一つ目の商品の値段は？");
            var priceA = int.Parse(Console.ReadLine() ?? "0");
            Console.Write("個数は？");
            var amountA = int.Parse(Console.ReadLine() ?? "0");
            Console.Write("二つ目の商品の値段は？");
            var priceB = int.Parse(Console.ReadLine() ?? "0");
            Console.Write("個数は？");
            var amountB = int.Parse(Console.ReadLine() ?? "0");

            Console.WriteLine($"お支払いは税込み￥{(int)((priceA * amountA + priceB * amountB) * 1.1f)}です");

        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question4()
    {
        try
        {
            var golem = new Golem(300, 80, 50);

            Console.WriteLine($"ゴーレム　（HP:{golem.Hp}　防御力：{golem.Defense}）\n");
            Console.WriteLine("HP：" + golem.Hp);
            Console.Write("今回の攻撃の値を入力してください＞");
            var atk = int.Parse(Console.ReadLine() ?? "0");
            atk = atk - golem.Defense > 0 ? atk - golem.Defense : 0;
            Console.WriteLine("ダメージは" + atk + "です");
            golem.Hp -= atk;
            Console.WriteLine("残りのHPは" + golem.Hp + "です");

        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }
}