package com.ecc.gkgo1a;

import java.util.*;

class K08_2Sub {

    enum AttackMethod {
        Attack,
        Skill,
        Magic
    }

    static int AttackGolem(int lv, int playerHp) {
        Golem golem = new Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30);
        int _playerHp = playerHp;
        try
        {
            System.out.println(String.format("ゴーレムLv.%dが現れた！", lv + 1));
            while (golem.hp > 0)
            {
                System.out.println(String.format("\n残りHP：%d", golem.hp));
                System.out.print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
                Scanner in = new Scanner(System.in);
                int choice = in.nextInt();
                int damage = 0;

                HashMap<AttackMethod, Integer> damageDispatcher = new HashMap<>();
                damageDispatcher.put(AttackMethod.Attack, 65);
                damageDispatcher.put(AttackMethod.Skill, 99);
                damageDispatcher.put(AttackMethod.Magic, 133);

                switch (choice)
                {
                    case 1:
                        damage = damageDispatcher.get(AttackMethod.Attack);
                        break;
                    case 2:
                        damage = damageDispatcher.get(AttackMethod.Skill);
                        break;
                    case 3:
                        damage = damageDispatcher.get(AttackMethod.Magic);
                        break;
                    default:
                            break;
                }

                damage -= golem.defense;
                if (damage <= 0)
                {
                    damage = 0;
                    System.out.println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                    System.out.println(String.format("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.attack));
                    _playerHp = DamagePlayer(_playerHp, golem.attack);
                    if (_playerHp <= 0)
                    {
                        _playerHp = 0;
                        System.out.println("あなたはゴーレムに負けました！ゲームオーバー！");
                        return _playerHp;
                    }
                    System.out.println(String.format("あなたの残りHPは：%d", _playerHp));
                }
                System.out.println(String.format("ダメージは%dです。", damage));
                golem.hp -= damage;

                if (golem.hp <= 0)
                    golem.hp = 0;

                if (golem.hp == 0)
                    System.out.println(String.format("ゴーレムLv.%dを倒した！", lv + 1));
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        return _playerHp;
    }

    static int DamagePlayer(int playerHp, int attackPower) {
        return playerHp - attackPower;
    }
}
