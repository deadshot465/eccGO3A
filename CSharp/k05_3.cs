using System;

namespace CSharp
{
    public class K05_3 : IExecutable
    {
        public void Execute()
        {
            int choice = 0;

            do
            {
                Console.WriteLine("起きろ～");
                Console.Write("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
                choice = int.Parse(Console.ReadLine());
                if (choice == 1)
                {
                    Console.WriteLine("よし、学校へ行こう！");
                }

            } while (true);
        }
    }
}
