using System;

namespace CSharp
{
    public class K03_1 : IExecutable
    {
        public void Execute()
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

            return;
        }
    }
}
