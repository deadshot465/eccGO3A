using System;

namespace CSharp
{
    class K03 : IExecutable
    {
        public override void Question01()
        {
            try
            {
                Console.Write("年齢を入力してください。＞");
                int age = int.Parse(Console.ReadLine());
                if (age < 20)
                {
                    Console.WriteLine("未成年なので購入できません。");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return;
            }
        }

        public override void Question02()
        {
            try
            {
                Console.Write("身長を入力してください。＞");
                double height = double.Parse(Console.ReadLine());
                Console.Write("体重を入力してください。＞");
                double weight = double.Parse(Console.ReadLine());
                height /= 100.0;
                double standard = height * height * 22.0;
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
                Console.WriteLine(ex.Message);
                return;
            }
        }

        public override void Question03()
        {
            try
            {
                Random randomNumber = new Random();
                int n = randomNumber.Next(0, 100);
                Console.WriteLine("０から９９の範囲の数値が決定されました。");
                Console.Write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
                int guess = int.Parse(Console.ReadLine());
                Console.WriteLine("決められた数値は" + n + "です。");

                Console.WriteLine(guess > n ? "正解です。" : "不正解です。");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return;
            }
        }

        public override void Question04()
        {
            try
            {
                Random randomNumber = new Random();
                int n = randomNumber.Next(0, 100);
                Console.WriteLine("０から９９の範囲の数値が決定されました。");
                Console.Write("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
                int guess = int.Parse(Console.ReadLine());
                Console.WriteLine("決められた数値は" + n + "です。");

                if (guess > 100 || guess < 0)
                {
                    Console.WriteLine("反則です！");
                }
                else if (guess > n && (guess - n) <= 10)
                {
                    Console.WriteLine("大正解！");
                }
                else if (guess < n && (guess - n) >= -10)
                {
                    Console.WriteLine("惜しい！");
                }
                else if (guess == n)
                {
                    Console.WriteLine("お見事！");
                }
                else
                {
                    Console.WriteLine(guess > n ? "正解です。" : "不正解です。");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return;
            }
        }
    }
}
