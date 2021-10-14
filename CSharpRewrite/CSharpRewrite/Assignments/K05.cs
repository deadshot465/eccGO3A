using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K05 : IQuestion
{
    public void Question1()
    {
        var salary = 19.0f;
        var age = 22;

        while (salary < 50.0f)
        {
            salary *= 1.035f;
            age++;
        }

        Console.Write(age + "歳で月給" + salary + "万円");
    }

    public void Question2()
    {
        int choice;

        do
        {
            Console.WriteLine("起きろ～");
            Console.Write("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            choice = int.Parse(Console.ReadLine() ?? "0");
        } while (choice != 1);
        
        Console.WriteLine("よし、学校へ行こう！");
    }

    public void Question3()
    {
        do
        {
            Console.WriteLine("起きろ～");
            Console.Write("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            var choice = int.Parse(Console.ReadLine() ?? "0");
            if (choice == 1)
                Console.WriteLine("よし、学校へ行こう！");
        } while (true);
    }

    public void Question4()
    {
        var rng = new Random(); 
        var golem = new Golem(300 + rng.Next(0, 201), 80, 50);

        var playerHp = 200 + rng.Next(0, 101);

        Console.WriteLine($"ゴーレム　（HP:{golem.Hp}　防御力：{golem.Defense}）\n");

        while (golem.Hp > 0)
        {
            Console.WriteLine("残りHP：" + golem.Hp);
            Console.Write("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
            var choice = int.Parse(Console.ReadLine() ?? "0");
            var damage = choice switch
            {
                1 => 60 + rng.Next(0, 41),
                2 => 30 + rng.Next(0, 101),
                3 => 20 + rng.Next(0, 181),
                _ => 0
            };

            Console.WriteLine("基礎攻撃力は" + damage + "です。");

            damage = damage - golem.Defense < 0 ? 0 : damage - golem.Defense;

            if (damage == 0)
            {
                Console.WriteLine("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                Console.WriteLine("ゴーレムがあなたを攻撃しました！攻撃値：" + golem.Attack);
                playerHp -= golem.Attack;

                if (playerHp <= 0)
                {
                    Console.WriteLine("あなたはゴーレムに負けました！ゲームオーバー！");
                    return;
                }
                Console.WriteLine("あなたの残りHPは：" + playerHp);
            }

            Console.WriteLine("ダメージは" + damage + "です");
            golem.Hp = golem.Hp - damage < 0 ? 0 : golem.Hp - damage;

            Console.WriteLine("残りのHPは" + golem.Hp + "です");

            if (golem.Hp == 0)
                Console.WriteLine("ゴーレムを倒しました！");
        }
    }
}