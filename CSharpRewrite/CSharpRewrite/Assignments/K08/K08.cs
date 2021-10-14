using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments.K08;

public class K08 : IQuestion
{
    public void Question1()
    {
        var numbers = new List<int>();
        try
        {
            for (var i = 0; i < 3; i++)
            {
                Console.Write($"{i + 1}つ目の値を入力してください。＞");
                numbers.Add(int.Parse(Console.ReadLine() ?? "0"));
            }

            Console.WriteLine("どちらを調べますか？");
            Console.Write("（０：最大値　１：最小値）＞");

            switch (int.Parse(Console.ReadLine() ?? "0"))
            {
                case 0:
                    Console.WriteLine($"{numbers.Count}の中で最大値は{numbers.Max()}です。");
                    break;
                case 1:
                    Console.WriteLine($"{numbers.Count}の中で最小値は{numbers.Min()}です。");
                    break;
            }
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question2()
    {
        Console.WriteLine("冒険が今始まる！");
        var rng = new Random();
        var playerHp = 200 + rng.Next(0, 101);
        Console.WriteLine(Adventure.GameLoop(playerHp));
    }

    public void Question3() { }

    public void Question4() { }
}