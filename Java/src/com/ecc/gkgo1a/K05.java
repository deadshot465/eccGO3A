package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K05 extends IExecutable {

    @Override
    public void Execute(int num)
    {
        super.Execute(num);
    }

    @Override
    public void Question1()
    {
        float salary = 19.0f;
        int age = 22;

        while (salary < 50.0f)
        {
            salary *= 1.035f;
            age++;
        }

        System.out.print(age + "歳で月給" + salary + "万円");
    }

    @Override
    public void Question2()
    {
        int choice;

        do
        {
            System.out.println("起きろ～");
            System.out.print("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();


        } while (choice != 1);
        System.out.println("よし、学校へ行こう！");
    }

    @Override
    public void Question3()
    {
        int choice;

        do
        {
            System.out.println("起きろ～");
            System.out.print("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if (choice == 1)
            {
                System.out.println("よし、学校へ行こう！");
            }

        } while (true);
    }

    @Override
    public void Question4()
    {
        Random randomNumber = new Random();

        Golem golem = new Golem(300 + randomNumber.nextInt(200));

        int playerHp = 200 + randomNumber.nextInt(100);

        System.out.println(String.format("ゴーレム　（HP:%d　防御力：%d）\n", golem.hp, golem.defense));

        while (golem.hp > 0)
        {
            System.out.println("残りHP：" + golem.hp);
            System.out.print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();
            int damage;

            switch (option)
            {
                case 1:
                    damage = 60 + randomNumber.nextInt(40);
                    break;
                case 2:
                    damage = 30 + randomNumber.nextInt(100);
                    break;
                case 3:
                    damage = 20 + randomNumber.nextInt(180);
                    break;
                default:
                    continue;
            }

            System.out.println("基礎攻撃力は" + damage + "です。");

            damage -= golem.defense;

            if (damage <= 0)
            {
                damage = 0;

                System.out.println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                System.out.println("ゴーレムがあなたを攻撃しました！攻撃値：" + golem.attack);
                playerHp -= golem.attack;

                if (playerHp <= 0)
                {
                    System.out.println("あなたはゴーレムに負けました！ゲームオーバー！");
                    return;
                }
                System.out.println("あなたの残りHPは：" + playerHp);
            }

            System.out.println("ダメージは" + damage + "です");

            golem.hp -= damage;

            if (golem.hp < 0)
            {
                golem.hp = 0;
            }

            System.out.println("残りのHPは" + golem.hp + "です");

            if (golem.hp == 0)
            {
                System.out.println("ゴーレムを倒しました！");
            }
        }
    }
}
