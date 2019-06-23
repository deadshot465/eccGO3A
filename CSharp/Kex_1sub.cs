using System;

namespace CSharp
{
    static class Kex_1sub
    {
        public const int ATTACK_HIT = 110;
        public const int SKILL_HIT = 100;
        public const int MAGIC_HIT = 70;

        private static bool CheckHitOrMiss(int hit)
        {
            Random range = new Random();
            int value = range.Next(0, 100);
            return value <= hit - 1;
        }

        public static void AttackGolemEx(int lv, ref PlayerEx player)
        {
            GolemEx golem = new GolemEx(lv * 50 + 100, lv * 10 + 40, lv * 10 + 40);

            Console.WriteLine($"ゴーレムLv.{lv + 1}が現れた！");

            try
            {
                while (golem.Hp > 0)
                {
                    Console.WriteLine($"ゴーレム 残りHP：{golem.Hp}");
                    Console.WriteLine("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
                    int choice = int.Parse(Console.ReadLine());
                    int damage = 0;
                    bool is_hit = false;
                    Random rand = new Random();

                    switch (choice)
                    {
                        case 1:
                            damage = 60 + rand.Next(0, 41);
                            is_hit = CheckHitOrMiss(ATTACK_HIT - golem.Flee);
                            break;
                        case 2:
                            damage = 30 + rand.Next(0, 101);
                            is_hit = CheckHitOrMiss(SKILL_HIT - golem.Flee);
                            break;
                        case 3:
                            damage = 20 + rand.Next(0, 181);
                            is_hit = CheckHitOrMiss(MAGIC_HIT - golem.Flee);
                            break;
                        default:
                            break;
                    }

                    if (is_hit)
                    {
                        damage -= golem.Defense;
                        if (damage <= 0)
                        {
                            damage = 0;
                        }
                        Console.WriteLine($"{damage}のダメージ！");
                        golem.Hp -= damage;
                    }
                    else
                    {
                        Console.WriteLine("攻撃を外した！");
                    }

                    Console.WriteLine("ゴーレムの攻撃！\n");
                    is_hit = CheckHitOrMiss(golem.Hit);
                    if (is_hit)
                    {
                        int injury = golem.Attack - player.Defense;
                        Console.WriteLine($"{injury}のダメージ！");
                        player.Hp -= injury;
                        if (player.Hp <= 0)
                        {
                            player.Hp = 0;
                            Console.WriteLine("あなたはゴーレムに負けました！ゲームオーバー！");
                            return;
                        }
                    }
                    else
                    {
                        Console.WriteLine("攻撃を外した！");
                    }

                    Console.WriteLine($"プレイヤー残りHP：{player.Hp}");
                    if (golem.Hp <= 0)
                        golem.Hp = 0;

                    if (golem.Hp == 0)
                        Console.WriteLine($"ゴーレムLv.{lv + 1}を倒した！");
                }
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(e);
            }

        }
    }
}
