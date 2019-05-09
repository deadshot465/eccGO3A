using System;

namespace CSharp
{
    class K05 : IExecutable
    {
        public override void Question01()
        {
            float salary = 19.0f;
            int age = 22;

            while (salary < 50.0f)
            {
                salary *= 1.035f;
                age++;
            }

            Console.Write(age + "歳で月給" + salary + "万円");
        }

        public override void Question02()
        {
            int choice = 0;

            do
            {
                Console.WriteLine("起きろ～");
                Console.Write("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
                choice = int.Parse(Console.ReadLine());


            } while (choice != 1);
            Console.WriteLine("よし、学校へ行こう！");
        }

        public override void Question03()
        {
            int choice = 0;

            do
            {
                Console.WriteLine("起きろ～");
                Console.Write("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
                choice = int.Parse(Console.ReadLine());
                if (choice == 1)
                {
                    Console.WriteLine("よし、学校へ行こう！");
                }

            } while (true);
        }

        public override void Question04()
        {
            Random randomNumber = new Random();

            Golem golem = new Golem(hp: 300 + randomNumber.Next(0, 201));

            int playerHp = 200 + randomNumber.Next(0, 101);

            Console.WriteLine(string.Format("ゴーレム　（HP:{0}　防御力：{1}）\n", golem.Hp, golem.Defense));

            while (golem.Hp > 0)
            {
                Console.WriteLine("残りHP：" + golem.Hp);
                Console.Write("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
                int option = int.Parse(Console.ReadLine());
                int damage = 0;

                switch (option)
                {
                    case 1:
                        damage = 60 + randomNumber.Next(0, 41);
                        break;
                    case 2:
                        damage = 30 + randomNumber.Next(0, 101);
                        break;
                    case 3:
                        damage = 20 + randomNumber.Next(0, 181);
                        break;
                    default:
                        continue;
                }

                Console.WriteLine("基礎攻撃力は" + damage + "です。");

                damage -= golem.Defense;

                if (damage <= 0)
                {
                    damage = 0;

                    Console.WriteLine("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                    Console.WriteLine("ゴーレムがあなたを攻撃しました！攻撃値：" + golem.Attack);
                    playerHp -= golem.Attack;

                    if (playerHp <= 0)
                    {
                        playerHp = 0;
                        Console.WriteLine("あなたはゴーレムに負けました！ゲームオーバー！");
                        return;
                    }
                    Console.WriteLine("あなたの残りHPは：" + playerHp);
                }

                Console.WriteLine("ダメージは" + damage + "です");

                golem.Hp -= damage;

                if (golem.Hp < 0)
                {
                    golem.Hp = 0;
                }

                Console.WriteLine("残りのHPは" + golem.Hp + "です");

                if (golem.Hp == 0)
                {
                    Console.WriteLine("ゴーレムを倒しました！");
                }
            }
        }
    }
}
