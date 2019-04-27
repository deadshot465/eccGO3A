using System;

namespace CSharp
{
    public class K06_4 : IExecutable
    {
        public void Execute()
        {
            Console.Write("\t|\t");
            for (int i = 1; i < 10; i++)
            {
                Console.Write(i + "\t");
            }
            Console.WriteLine();

            for (int i = 0; i < 85; i++)
            {
                Console.Write("-");
            }
            Console.WriteLine();

            for (int i = 1; i < 10; i++)
            {
                Console.Write(i + "\t|\t");
                for (int j = 1; j < 10; j++)
                {
                    Console.Write(i * j + "\t");
                }
                Console.WriteLine();
            }
        }
    }
}
