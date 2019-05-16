using System;
using System.Linq;

namespace CSharp
{
    class K09 : IExecutable
    {
        public override void Execute(int num)
        {
            switch (num)
            {
                case 1:
                    Question01();
                    break;
                case 2:
                    Question02();
                    break;
                case 3:
                    Question03();
                    break;
                case 4:
                    Question04();
                    break;
                case 5:
                    Question05();
                    break;
            }
        }

        public override void Question01()
        {
            try
            {
                int[] ages = new int[3];
                for (int i = 0; i < 3; i++)
                {
                    Console.Write($"{i + 1}人目の年齢を入力＞");
                    ages[i] = int.Parse(Console.ReadLine());
                }

                for (int i = 0; i < 21; i++)
                {
                    Console.Write("-");
                }
                Console.WriteLine();

                for (int i = 0; i < 3; i++)
                {
                    Console.WriteLine($"{i + 1}人目：{ages[i]}歳。");
                }

                Console.Write($"平均年齢：{Math.Round(ages.Average(), 1)}歳。");
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e.Message);
            }

        }

        public override void Question02()
        {
            int[] numbers = {8, 3, 12, 7, 9};
            Console.Write("元々の配列：");
            foreach (var num in numbers)
            {
                Console.Write($"{num} ");
            }
            Console.WriteLine();

            Console.Write("逆順での表示：");

            foreach (var num in numbers.Reverse())
            {
                Console.Write($"{num} ");
            }

        }

        public override void Question03()
        {
            int[,] studentScores =
            {
                { 52, 71, 61, 47 },
                { 6, 84, 81, 20 },
                { 73, 98, 94, 95 }
            };

            Console.WriteLine("\t|\t科目A\t科目B\t科目C\t科目D");
            for (int i = 0; i < 46; ++i)
            {
                Console.Write("-");
            }
            Console.WriteLine();

            for (int i = 0; i < studentScores.GetLength(0); i++)
            {
                Console.Write($"学生{i + 1}\t|\t");
                for (int j = 0; j < studentScores.GetLength(1); j++)
                {
                    Console.Write($"{studentScores[i, j]}\t");
                }

                Console.WriteLine();
            }

        }

        public override void Question04()
        {
            int[,] studentScores =
            {
                { 52, 71, 61, 47 },
                { 6, 84, 81, 20 },
                { 73, 98, 94, 95 }
            };

            float[] average = new float[4];
            int total = 0;

            Console.WriteLine("\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点");
            for (int i = 0; i < 66; ++i)
            {
                Console.Write("-");
            }
            Console.WriteLine();

            for (int i = 0; i < studentScores.GetLength(0); i++)
            {
                Console.Write($"学生{i + 1}\t|\t");

                for (int j = 0; j < studentScores.GetLength(1); j++)
                {
                    Console.Write($"{studentScores[i, j]}\t");
                    total += studentScores[i, j];
                    average[j] += studentScores[i, j];

                }
                Console.Write($"|\t{total}");
                total = 0;
                Console.WriteLine();
                
            }
            Console.Write("平均点\t|\t");
            foreach (var score in average)
            {
                Console.Write($"{Math.Round(score / 3.0f, 1)}\t");
            }
            Console.Write("|");
        }

        public void Question05()
        {
            try
            {
                int count = 0;
                int[] numbers = new int[100];
                for (int i = 0; i < numbers.Length; i++)
                {
                    Console.Write($"{i + 1}件目の入力：");
                    numbers[i] = int.Parse(Console.ReadLine());
                    if (numbers[i] < 0)
                    {
                        break;
                    }
                    count++;
                }

                Console.WriteLine("----並び替え後----");

                var query = numbers.ToList().Take(count).OrderBy((x) => x);

                foreach (var i in query)
                {
                    Console.WriteLine(i);
                }
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e.Message);
            }
        }
    }
}
