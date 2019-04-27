using System;

namespace CSharp
{
    public class K05_4 : IExecutable
    {
        public void Execute()
        {
            Random randomNumber = new Random();

            Golem golem = new Golem()
            {
                hp = 300 + randomNumber.Next(0, 200),
                defense = 80
            };

            int golemAttack = 50;
            int playerHp = 200 + randomNumber.Next(0, 100);

            Console.WriteLine(string.Format("ゴーレム　（HP:{0}　防御力：{1}）\n", golem.hp, golem.defense));

            while (golem.hp > 0)
            {
                Console.WriteLine("残りHP：" + golem.hp);
                Console.Write("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
                int option = int.Parse(Console.ReadLine());
                int damage = 0;

                switch (option)
                {
                    case 1:
                        damage = 60 + randomNumber.Next(0, 40);
                        break;
                    case 2:
                        damage = 30 + randomNumber.Next(0, 100);
                        break;
                    case 3:
                        damage = 20 + randomNumber.Next(0, 180);
                        break;
                    default:
                        continue;
                }

                Console.WriteLine("基礎攻撃力は" + damage + "です。");

                damage -= golem.defense;

                if (damage < 0)
                {
                    damage = 0;

                    Console.WriteLine("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                    Console.WriteLine("ゴーレムがあなたを攻撃しました！攻撃値：" + golemAttack);
                    playerHp -= golemAttack;

                    if (playerHp < 0)
                    {
                        playerHp = 0;
                        Console.WriteLine("あなたはゴーレムに負けました！ゲームオーバー！");
                        return;
                    }
                    Console.WriteLine("あなたの残りHPは：" + playerHp);
                }

                Console.WriteLine("ダメージは" + damage + "です");

                golem.hp -= damage;

                if (golem.hp < 0)
                {
                    golem.hp = 0;
                }

                Console.WriteLine("残りのHPは" + golem.hp + "です");

                if (golem.hp == 0)
                {
                    Console.WriteLine("ゴーレムを倒しました！");
                }
            }

        }
    }
}
