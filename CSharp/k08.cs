using System;
using System.Collections.Generic;

namespace CSharp
{
    class K08 : IExecutable
    {
        public override void Question01()
        {
            List<int> numbers = new List<int>();


            try
            {
                for (int i = 0; i < 3; i++)
                {
                    Console.Write(string.Format("{0}つ目の値を入力してください。＞", i + 1));
                    numbers.Add(int.Parse(Console.ReadLine()));
                }

                Console.WriteLine("どちらを調べますか？");
                Console.Write("（０：最大値　１：最小値）＞");
                int choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 0:
                        Console.WriteLine(
                            string.Format("{0}の中で最大値は{1}です。",
                            numbers.Count,
                            Utilities.GetMaxValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    case 1:
                        Console.WriteLine(
                            string.Format("{0}の中で最小値は{1}です。",
                            numbers.Count,
                            Utilities.GetMinValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    default:
                        break;
                }
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.Message);
            }
        }

        public override void Question02()
        {
            try
            {
                Console.WriteLine("冒険が今始まる！");
                Random random = new Random();
                int playerHp = 200 + random.Next(0, 101);
                bool continueGame = true;
                do
                {
                    if (playerHp == 0)
                        return;

                    Console.WriteLine("あなたのHP：" + playerHp);
                    Console.Write("奥に進みますか？（１：奥に進む　０．帰る）＞");
                    continueGame = Convert.ToBoolean(int.Parse(Console.ReadLine()));
                    if (continueGame)
                    {
                        int golemLv = random.Next(0, 5);
                        Utilities.AttackGolem(golemLv, ref playerHp);
                    }

                } while (continueGame);
                Console.WriteLine("リレ〇ト！");
            }
            catch (Exception ex)
            {

                Console.Error.WriteLine(ex.Message);
            }
        }

        public override void Question03()
        {
            return;
        }

        public override void Question04()
        {
            return;
        }
    }
}
