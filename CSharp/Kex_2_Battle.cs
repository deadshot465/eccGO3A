using System;
using System.Collections.Generic;

namespace CSharp
{
    public static class Kex_2_Battle
    {
        private static bool CheckHitOrMiss(int hit)
        {
            Random random = new Random();
            int value = random.Next(0, 101);
            return value <= hit - 1;
        }

        public static bool AttackEnemy(ref PlayerEx player, ref Enemy enemy)
        {
            Console.WriteLine($"{enemy.Name}Lv.{enemy.Lv + 1}が現れた！");

            while (enemy.Hp > 0)
            {
                Console.WriteLine($"{enemy.Name} 残りHP：{enemy.Hp}");
                Console.Write("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
                try
                {
                    int choice = int.Parse(Console.ReadLine());
                    int damage = 0;
                    bool isHit = false;
                    Random random = new Random();
                    Func<int> getAttackPower = () => random.Next(0, 41) + 60;
                    Func<int> getSkillPower = () => random.Next(0, 101) + 30;
                    Func<int> getMagicPower = () => random.Next(0, 181) + 20;

                    List<Attack> attacks = new List<Attack>(3);
                    List<Func<int>> getPowers = new List<Func<int>>
                    {
                        getAttackPower, getSkillPower, getMagicPower
                    };
                    int[] getHits = { Kex_1sub.ATTACK_HIT, Kex_1sub.SKILL_HIT, Kex_1sub.MAGIC_HIT };

                    for (int i = 0; i < 3; i++)
                    {
                        attacks.Add(new Attack(getPowers[i](), getHits[i]));
                    }

                    switch (choice)
                    {
                        case 1:
                            damage = attacks[0].Damage;
                            isHit = CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
                            break;
                        case 2:
                            damage = attacks[1].Damage;
                            isHit = CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
                            break;
                        case 3:
                            damage = attacks[2].Damage;
                            isHit = CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
                            break;
                    }

                    if (isHit)
                    {
                        damage -= enemy.Defense;
                        if (damage <= 0)
                            damage = 0;
                        Console.WriteLine($"{damage}のダメージ！");
                        enemy.Hp -= damage;
                    }
                    else
                    {
                        Console.WriteLine("攻撃を外した！");
                    }

                    Console.WriteLine($"{enemy.Name}の攻撃！");
                    isHit = CheckHitOrMiss(enemy.Hit);
                    if (isHit)
                    {
                        int injury = enemy.Attack - player.Defense;
                        if (injury <= 0)
                            injury = 0;

                        Console.WriteLine($"{injury}のダメージ！");
                        player.Hp -= injury;
                        if (player.Hp <= 0)
                        {
                            player.Hp = 0;
                            Console.WriteLine($"あなたは{enemy.Name}に負けました！ゲームオーバー！");
                            return false;
                        }
                    }
                    else
                    {
                        Console.WriteLine("攻撃を外した！");
                    }

                    Console.WriteLine($"プレイヤー残りHP：{player.Hp}");
                    if (enemy.Hp <= 0)
                        enemy.Hp = 0;
                    if (enemy.Hp == 0)
                        Console.WriteLine($"{enemy.Name}Lv.{enemy.Lv + 1}を倒した！");
                }
                catch (Exception ex)
                {
                    Console.Error.WriteLine(ex.Message);
                }
            }

            return true;
        }

    }
}
