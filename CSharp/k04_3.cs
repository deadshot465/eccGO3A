using System;

namespace CSharp
{
    public class K04_3 : IExecutable
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
                else if (age >= 3 && age <= 15)
                {
                    Console.WriteLine("子供料金で半額です。");
                }
                else if (age >= 60 && age < 70)
                {
                    Console.WriteLine("シニア割引で一割引きです。");
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
