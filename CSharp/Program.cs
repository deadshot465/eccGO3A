using System;
using System.Collections.Generic;

namespace CSharp
{
    public class Program
    {
        private static void ShowSelections(int chapter)
        {
            if (chapter < 10)
            {
                for (int i = 1; i <= 4; i++)
                {
                    Console.WriteLine($"\t{i}) K0{chapter}_{i}");
                }

                if (chapter == 9)
                {
                    Console.WriteLine($"\t5) K0{chapter}_5");
                }
            }
            else
            {
                for (int i = 1; i <= 4; i++)
                {
                    Console.WriteLine($"\t{i}) K{chapter}_{i}");
                }
            }
        }

        public static void Main(string[] args)
        {
            int choice, choice2;

            List<IExecutable> executables = new List<IExecutable>
            {
                new K01(), new K02(), new K03(),
                new K04(), new K05(), new K06(),
                new K07(), new K08(), new K09(),
                new K10(), new K11(), new K12(),
                new K13(), new FileControl()
            };

            Console.WriteLine("実行したいプログラムを選択してください。");

            for (int i = 1; i <= executables.Count; i++)
            {
                if (i < 10)
                {
                    Console.WriteLine($"{i}) K0{i}");
                }
                else
                {
                    int addedNumber = i >= 12 ? i + 3 : i;
                    Console.WriteLine($"{i}) K{addedNumber}");
                }
            }
            Console.WriteLine("100) Kex_1");
            Console.WriteLine("101) Kex_2");
            Console.WriteLine("102) Sort");

            try
            {
                choice = int.Parse(Console.ReadLine());

                if (choice == 100)
                {
                    Kex kex = new Kex();
                    kex.Execute();
                    return;
                }
                else if (choice == 101)
                {
                    Kex_2.Execute();
                    return;
                }
                else if (choice == 102)
                {
                    Sort sort = new Sort();
                    sort.Execute();
                    return;
                }

                if (choice < 1 || choice > executables.Count)
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
