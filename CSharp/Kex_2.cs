using System;

namespace CSharp
{
    public static class Kex_2
    {
        public static void Execute()
        {
            Random random = new Random();
            Console.WriteLine("冒険が今始まる！");
            PlayerEx player = new PlayerEx(PlayerEx.INITIAL_HP);
            bool continueGame = true;
            int kills = 0;

            do
            {
                Console.WriteLine($"\n現HP：{player.Hp}");
                Console.Write("奥に進みますか？（１：奥に進む　０．帰る）＞");
                continueGame = Convert.ToBoolean(int.Parse(Console.ReadLine()));

                if (continueGame)
                {
                    int type = random.Next(0, 3);
                    Enemy enemy = Kex_2_Enemy.CreateEnemy((EnemyType)type);
                    bool result = Kex_2_Battle.AttackEnemy(ref player, ref enemy);
                    kills++;

                    if (!result)
                    {
                        break;
                    }
                }

            } while (continueGame);

            Console.WriteLine("リ〇ミト！\n");
            Console.WriteLine($"戦闘回数：{kills}回　残りHP：{player.Hp}");
        }
    }
}
