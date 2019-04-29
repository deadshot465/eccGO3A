using System;
using System.Collections.Generic;

namespace CSharp
{
    public class Program
    {
        private static void ShowSelections(int chapter)
        {
            for (int i = 1; i <= 4; i++)
            {
                Console.WriteLine(string.Format("\t{0}) K0{1}_{2}", i, chapter, i));
            }
        }

        public static void Main(string[] args)
        {
            int choice, choice2;

            List<IExecutable> executables = new List<IExecutable>
            {
                new K01(), new K02(), new K03(),
                new K04(), new K05(), new K06()
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
                executables[choice - 1].Execute(choice2);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return;
            }
 
        }
    }
}
