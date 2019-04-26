using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharp
{
    public class K06_1 : IExecutable
    {
        public void Execute()
        {
            List<int> ages = new List<int>();

            for (int i = 0; i < 5; i++)
            {
                Console.Write((i + 1) + "人目の年齢を入力して下さい：");
                ages.Add(int.Parse(Console.ReadLine()));
            }

            Console.WriteLine(string.Format("{0}人の平均年齢は{1}です。", ages.Count, ages.Average()));
        }
    }
}
