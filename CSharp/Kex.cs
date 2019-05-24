using System;

namespace CSharp
{
    class Kex
    {
        public void Execute()
        {
            Random rand = new Random();
            Console.WriteLine("冒険が今始まる！");

            PlayerEx player = new PlayerEx(PlayerEx.INITIAL_HP);
            int kills = 0;
            bool continueGame = true;

            do
            {
                Console.WriteLine($"\n現HP：{player.Hp}");
                Console.Write("奥に進みますか？（１：奥に進む　０．帰る）＞");
                continueGame = Convert.ToBoolean(int.Parse(Console.ReadLine()));

                if (continueGame)
                {
                    int golem_lv = rand.Next(0, 5);
                    Kex_1sub.AttackGolemEx(golem_lv, ref player);
                    ++kills;
                    if (player.Hp == 0)
                        break;
                }

            } while (continueGame);

            Console.WriteLine("リ〇ミト！\n");
            Console.WriteLine($"戦闘回数：{kills}　残りHP：{player.Hp}");
        }
    }
}
