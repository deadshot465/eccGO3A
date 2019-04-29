using System;
using System.Collections.Generic;
using System.Linq;

namespace CSharp
{
    class K06 : IExecutable
    {
        public override void Question01()
        {
            List<int> ages = new List<int>();

            for (int i = 0; i < 5; i++)
            {
                Console.Write((i + 1) + "人目の年齢を入力して下さい：");
                ages.Add(int.Parse(Console.ReadLine()));
            }

            Console.WriteLine(string.Format("{0}人の平均年齢は{1}です。", ages.Count, ages.Average()));
        }

        public override void Question02()
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

        public override void Question03()
        {
            int total = 370;
            int count = 0;

            for (int i = 0; i <= total / 100; i++)
            {
                for (int j = 0; j <= total / 50; j++)
                {
                    for (int k = 0; k <= total / 10; k++)
                    {
                        if (100 * i + 50 * j + 10 * k == total)
                        {
                            Console.WriteLine(string
                                .Format("10円の硬貨{0}枚 50円の硬貨{1}枚 100円の硬貨{2}枚", k, j, i));
                            count++;
                        }
                    }
                }
            }

            Console.WriteLine("\n以上" + count + "通りを発見しました。");
        }

        public override void Question04()
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
