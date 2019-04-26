using System;
using System.Collections.Generic;

namespace CSharp
{
    public class Program
    {

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
            Console.WriteLine("1) K01");
            Console.WriteLine("2) K02");
            Console.WriteLine("3) K03");
            Console.WriteLine("4) K04");
            Console.WriteLine("5) K05");
            Console.WriteLine("6) K06");

            try
            {
                choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        Console.WriteLine("\t1) K01_1");
                        Console.WriteLine("\t2) K01_2");
                        Console.WriteLine("\t3) K01_3");
                        Console.WriteLine("\t4) K01_4");

                        break;
                    case 2:
                        Console.WriteLine("\t5) K02_1");
                        Console.WriteLine("\t6) K02_2");
                        Console.WriteLine("\t7) K02_3");
                        Console.WriteLine("\t8) K02_4");

                        break;
                    case 3:
                        Console.WriteLine("\t9) K03_1");
                        Console.WriteLine("\t10) K03_2");
                        Console.WriteLine("\t11) K03_3");
                        Console.WriteLine("\t12) K03_4");

                        break;
                    case 4:
                        Console.WriteLine("\t13) K04_1");
                        Console.WriteLine("\t14) K04_2");
                        Console.WriteLine("\t15) K04_3");
                        Console.WriteLine("\t16) K04_4");

                        break;
                    case 5:
                        Console.WriteLine("\t17) K05_1");
                        Console.WriteLine("\t18) K05_2");
                        Console.WriteLine("\t19) K05_3");
                        Console.WriteLine("\t20) K05_4");

                        break;
                    case 6:
                        Console.WriteLine("\t21) K06_1");
                        Console.WriteLine("\t22) K06_2");
                        Console.WriteLine("\t23) K06_3");
                        Console.WriteLine("\t24) K06_4");

                        break;
                    default:
                        break;
                }
                choice2 = int.Parse(Console.ReadLine());
                executables[choice2 - 1].Execute();
            }
            catch (Exception)
            {
                Console.WriteLine("無効の選択です。");
                return;
            }

            return;  
        }
    }
}
