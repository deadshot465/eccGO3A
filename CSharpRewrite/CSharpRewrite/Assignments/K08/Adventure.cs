using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments.K08;

public static class Adventure
{
    public static string GameLoop(int playerHp)
    {
        while (playerHp > 0)
        {
            Console.WriteLine($"あなたのHP：{playerHp}");
            Console.Write("奥に進みますか？（１：奥に進む　０．帰る）＞");

            switch (int.Parse(Console.ReadLine() ?? "0"))
            {
                case 0:
                    return "リレ〇ト！";
                default:

                    string? RunBattle()
                    {
                        var (hp, msg) = EngageBattle(playerHp);
                        if (hp.HasValue)
                            playerHp = hp.Value;
                        else if (msg != null)
                            return msg;
                        return null;
                    }

                    var result = RunBattle();
                    if (result != null)
                    {
                        Console.WriteLine(result);
                        return "ゲームオーバー！";
                    }
                    break;
            }
        }
        return "ゲームオーバー！";
    }

    private static int SelectAttack(int choice)
    {
        var rng = new Random();
        return choice switch
        {
            1 => 65 + rng.Next(0, 36),
            2 => 50 + rng.Next(0, 101),
            3 => 33 + rng.Next(0, 168),
            _ => SelectAttack(1)
        };
    }

    private static int DamagePlayer(int golemAttack, int playerHp)
    {
        Console.WriteLine("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
        Console.WriteLine($"ゴーレムがあなたを攻撃しました！攻撃値：{golemAttack}");
        return playerHp - golemAttack;
    }

    private static (int?, string?) BattleLoop(int golemLevel, Golem golem, int playerHp)
    {
        while (golem.Hp > 0)
        {
            Console.WriteLine($"ゴーレムLv.{golemLevel + 1} 残りHP：{golem.Hp}");
            Console.Write("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");

            var baseDamage = SelectAttack(int.Parse(Console.ReadLine() ?? "0"));
            Console.WriteLine($"基礎ダメージは{baseDamage}です。");
            var actualDamage = baseDamage - golem.Defense < 0 ? 0 : baseDamage - golem.Defense;
            Console.WriteLine($"実際ダメージは{actualDamage}です。");

            if (actualDamage <= 0)
            {
                playerHp = DamagePlayer(golem.Attack, playerHp);
                if (playerHp <= 0)
                    return (null, "あなたはゴーレムに負けました！");
                Console.WriteLine($"あなたの残りHPは：{playerHp}");
            }
            else
            {
                golem.Hp = golem.Hp - actualDamage < 0 ? 0 : golem.Hp - actualDamage;
            }
        }
        
        Console.WriteLine($"ゴーレムLv.{golemLevel + 1}を倒した！");
        return (playerHp, null);
    }

    private static (int?, string?) EngageBattle(int playerHp)
    {
        var rng = new Random();
        var golemLevel = rng.Next(0, 10);
        var golem = new Golem
        {
            Hp = golemLevel * 50 + 100,
            Defense = golemLevel * 10 + 40,
            Attack = golemLevel * 10 + 30
        };
        
        Console.WriteLine($"ゴーレムLv.{golemLevel + 1}が現れた！");
        return BattleLoop(golemLevel, golem, playerHp);
    }
}