using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K06 : IQuestion
{
    public void Question1()
    {
        var ages = new List<int>();
        for (var i = 0; i < 5; i++)
        {
            Console.Write(i + 1 + "人目の年齢を入力して下さい：");
            ages.Add(int.Parse(Console.ReadLine() ?? "0"));
        }

        Console.WriteLine($"{ages.Count}人の平均年齢は{ages.Average()}です。");
    }

    public void Question2()
    {
        for (var i = 0; i < 9; i++)
        {
            for (var j = 0; j < i + 1; j++)
            {
                Console.Write("*");
            }
            Console.WriteLine();
        }
        Console.WriteLine();

        for (var i = 9; i > 0; i--)
        {
            for (var j = 0; j < i; j++)
            {
                Console.Write("*");
            }
            Console.WriteLine();
        }
        Console.WriteLine();

        for (var i = 9; i > 0; i--)
        {
            for (var j = 0; j < i - 1; j++)
            {
                Console.Write(" ");
            }

            for (var k = 9; k > i - 1; k--)
            {
                Console.Write("*");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }

    public void Question3()
    {
        const int total = 370;
        var count = 0;

        for (var i = 0; i <= total / 100; i++)
        {
            for (var j = 0; j <= total / 50; j++)
            {
                for (var k = 0; k <= total / 10; k++)
                {
                    if (100 * i + 50 * j + 10 * k != total) continue;
                    Console.WriteLine($"10円の硬貨{k}枚 50円の硬貨{j}枚 100円の硬貨{i}枚");
                    count++;
                }
            }
        }

        Console.WriteLine("\n以上" + count + "通りを発見しました。");
    }

    public void Question4()
    {
        Console.Write("\t|\t");
        for (var i = 1; i < 10; i++)
        {
            Console.Write(i + "\t");
        }
        Console.WriteLine();

        for (var i = 0; i < 85; i++)
        {
            Console.Write("-");
        }
        Console.WriteLine();

        for (var i = 1; i < 10; i++)
        {
            Console.Write(i + "\t|\t");
            for (var j = 1; j < 10; j++)
            {
                Console.Write(i * j + "\t");
            }
            Console.WriteLine();
        }
    }
}