using System;

namespace CSharp
{
    public class K04_1 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Console.Write("年齢を入力してください。＞");
                int age = int.Parse(Console.ReadLine());

                if (age < 3 || age >= 70)
                {
                    Console.WriteLine("入場料金無料です。");
                }
                else
                {
                    Console.WriteLine("通常料金です。");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            return;
        }
    }
}
