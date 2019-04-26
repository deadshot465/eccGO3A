using System;

namespace CSharp
{
    public class K03_2 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Console.Write("身長を入力してください。＞");
                double height = int.Parse(Console.ReadLine());
                Console.Write("体重を入力してください。＞");
                double weight = int.Parse(Console.ReadLine());
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

            return;
        }
    }
}
