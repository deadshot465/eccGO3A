using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K03 : IQuestion
{
    public void Question1()
    {
        try
        {
            Console.Write("年齢を入力してください。＞");
            var age = int.Parse(Console.ReadLine() ?? "0");
            if (age < 20)
            {
                Console.WriteLine("未成年なので購入できません。");
            }
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }

    public void Question2()
    {
        try
        {
            Console.Write("身長を入力してください。＞");
            var height = double.Parse(Console.ReadLine() ?? "0.0");
            Console.Write("体重を入力してください。＞");
            var weight = double.Parse(Console.ReadLine() ?? "0.0");
            height /= 100.0;
            var standard = height * height * 22.0;
            Console.WriteLine("あなたの標準体重は" + standard + "です。");

            if (weight > standard && (weight - standard) / standard * 100 > 14)
            {
                Console.WriteLine("太り気味です。");
            }
            else if (weight < standard && (weight - standard) / standard * 100 < -14)
            {
                Console.WriteLine("痩せ気味です。");
            }
            else
            {
                Console.WriteLine("普通ですね。");
            }
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
            var randomNumber = new Random();
            var n = randomNumber.Next(0, 100);
            Console.WriteLine("０から９９の範囲の数値が決定されました。");
            Console.Write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
            var guess = int.Parse(Console.ReadLine() ?? "0");
            Console.WriteLine("決められた数値は" + n + "です。");

            Console.WriteLine(guess > n ? "正解です。" : "不正解です。");
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
            var randomNumber = new Random();
            var n = randomNumber.Next(0, 100);
            Console.WriteLine("０から９９の範囲の数値が決定されました。");
            Console.Write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
            var guess = int.Parse(Console.ReadLine() ?? "0");
            Console.WriteLine("決められた数値は" + n + "です。");
            
            Console.WriteLine(guess switch
            {
                > 100 or < 0 => "反則です！",
                var x when x > n && x - n <= 10 => "大正解！",
                var x when x < n && n - x <= 10 => "惜しい！",
                var x when x == n => "お見事！",
                _ => guess > n ? "正解です。" : "不正解です。"
            });
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine(ex.Message);
        }
    }
}