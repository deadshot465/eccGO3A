using System;

namespace CSharp
{
    public class K02_2 : IExecutable
    {
        public void Execute()
        {
            try
            {
                Console.Write("一つ目の整数は？");
                int a = int.Parse(Console.ReadLine());
                Console.Write("二つ目の整数は？");
                int b = int.Parse(Console.ReadLine());

                Console.WriteLine(string.Format("{0}÷{1}={2}...{3}", a, b, a / b, a % b));

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
