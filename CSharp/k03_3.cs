using System;

namespace CSharp
{
    public class K03_3 : IExecutable
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

                Console.WriteLine(guess > n ? "正解です。" : "不正解です。");
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
