using System;
using System.Collections.Generic;

namespace CSharp
{
    public class Program
    {
        private static void ShowSelections(int chapter)
        {
            int j = 1;

            for (int i = 4 * chapter - 3; i < 4 * chapter + 1; i++)
            {
                Console.WriteLine(string.Format("\t{0}) K0{1}_{2}", i, chapter, j));
                j++;
            }
        }

        public static void Main(string[] args)
        {
            int choice, choice2;

            List<IExecutable> executables = new List<IExecutable>
            {
                new K01_1(), new K01_2(), new K01_3(), new K01_4(),
                new K02_1(), new K02_2(), new K02_3(), new K02_4(),
                new K03_1(), new K03_2(), new K03_3(), new K03_4(),
                new K04_1(), new K04_2(), new K04_3(), new K04_4(),
                new K05_1(), new K05_2(), new K05_3(), new K05_4(),
                new K06_1(), new K06_2(), new K06_3(), new K06_4()
            };

            Console.WriteLine("実行したいプログラムを選択してください。");

            for (int i = 1; i < 7; i++)
            {
                Console.WriteLine(string.Format("{0}) K0{1}", i, i));
            }

            try
            {
                choice = int.Parse(Console.ReadLine());

                if (choice < 1 || choice > 6)
                {
                    throw new Exception("無効の選択です。");
                }

                ShowSelections(choice);

                choice2 = int.Parse(Console.ReadLine());
                executables[choice2 - 1].Execute();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return;
            }
 
        }
    }
}
