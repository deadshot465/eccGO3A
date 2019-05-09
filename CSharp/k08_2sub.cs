using System;

namespace CSharp
{
    static partial class Utilities
    {
        enum AttackMethod
        {
            Attack = 65,
            Skill = 99,
            Magic = 133
        }

        public static void AttackGolem(int lv, ref int playerHp)
        {
            try
            {
                Golem golem = new Golem(
                    hp: lv * 50 + 100,
                    defense: lv * 10 + 40,
                    attack: lv * 10 + 30
                    );

                Console.WriteLine(string.Format("ゴーレムLv.{0}が現れた！", lv + 1));
                while (golem.Hp > 0)
                {
                    Console.WriteLine(string.Format("\n残りHP：{0}", golem.Hp));
                    Console.Write("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
                    int choice = int.Parse(Console.ReadLine());
                    int damage;
                    switch (choice)
                    {
                        case 1:
                            damage = (int)AttackMethod.Attack;
                            break;
                        case 2:
                            damage = (int)AttackMethod.Skill;
                            break;
                        case 3:
                            damage = (int)AttackMethod.Magic;
                            break;
                        default:
                            damage = 0;
                            break;
                    }

                    damage -= golem.Defense;
                    if (damage <= 0)
                    {
                        damage = 0;
                        Console.WriteLine("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                        Console.WriteLine(string.Format("ゴーレムがあなたを攻撃しました！攻撃値：{0}", golem.Attack));
                        playerHp -= golem.Attack;
                        if (playerHp <= 0)
                        {
                            playerHp = 0;
                            Console.WriteLine("あなたはゴーレムに負けました！ゲームオーバー！");
                            return;
                        }
                        Console.WriteLine(string.Format("あなたの残りHPは：{0}", playerHp));
                    }
                    Console.WriteLine(string.Format("ダメージは{0}です。", damage));
                    golem.Hp -= damage;

                    if (golem.Hp <= 0)
                        golem.Hp = 0;

                    if (golem.Hp == 0)
                        Console.WriteLine(string.Format("ゴーレムLv.{0}を倒した！", lv + 1));
                }
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex.Message);
            }
        }
    }
}
