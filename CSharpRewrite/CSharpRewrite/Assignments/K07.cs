using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K07 : IQuestion
{
    public void Question1()
    {
        var choice = 0;
        do
        {
            try
            {
                Console.Write("メッセージを表示しますか？（０：終了する　１：表示する）＞");
                choice = int.Parse(Console.ReadLine() ?? "0");
                if (choice == 1)
                    ShowTexts();
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.Message);
            }
                

        } while (choice != 0);
        Console.WriteLine("終了します。");
    }

    public void Question2()
    {
        try
        {
            var numbers = new int[3];
            for (var i = 0; i < 3; i++)
            {
                Console.Write($"{i + 1}つ目の値を入力してください。＞");
                numbers[i] = int.Parse(Console.ReadLine() ?? "0");
            }

            Console.WriteLine($"{numbers.Length}つの中で最大値は{GetMaxValue(numbers[0], numbers[1], numbers[2])}です。");
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
            Console.Write("年齢を入力して下さい。＞");
            var age = int.Parse(Console.ReadLine() ?? "0");
            Console.WriteLine(GetAgeTier(age));
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question4() { }

    private static string GetAgeTier(int age)
    {
        return age switch
        {
            <= 0 => "不適切な値が入力されました。",
            < 3 or >= 70 => "入場料金無料です。",
            >= 3 and <= 15 => "子供料金で半額です。",
            >= 60 and < 70 => "シニア割引で一割引きです。",
            _ => "通常料金です。"
        };
    }
    
    private static int GetMaxValue(int value1, int value2, int value3)
    {
        var temp = value1 >= value2 ? value1 : value2;
        temp = temp >= value3 ? temp : value3;
        return temp;
    }
    
    private static void ShowTexts()
    {
        Console.WriteLine("Hello World!");
        Console.WriteLine("ようこそ");
        Console.WriteLine("C#言語の世界へ！");
    }
}