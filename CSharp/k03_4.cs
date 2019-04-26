using System;

namespace CSharp
{
    public class K03_4 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Random randomNumber = new Random();
                int n = randomNumber.Next(0, 99);
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

            return;
        }
    }
}
