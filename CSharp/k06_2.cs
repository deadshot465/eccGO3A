using System;

namespace CSharp
{
    public class K06_2 : IExecutable
    {
        public void Execute()
        {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < i + 1; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
            Console.WriteLine();

            for (int i = 9; i > 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
            Console.WriteLine();

            for (int i = 9; i > 0; i--)
            {
                for (int j = 0; j < i - 1; j++)
                {
                    Console.Write(" ");
                }
                
                for (int k = 9; k > i - 1; k--)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }
    }
}
