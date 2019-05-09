package com.ecc.gkgo1a;

import java.util.Scanner;

public class K02 extends IExecutable
{
    @Override
    public void Execute(int num)
    {
        super.Execute(num);
    }

    @Override
    public void Question1()
    {
        int seisuu = 3;
        float jissuu = 2.6f;
        char moji = 'A';

        System.out.println("変数seisuuの値は" + seisuu);
        System.out.println("変数jissuuの値は" + jissuu);
        System.out.println("変数mojiの値は" + moji);
    }

    @Override
    public void Question2()
    {
        try
        {
            System.out.print("一つ目の整数は？");
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.print("二つ目の整数は？");
            int b = in.nextInt();

            System.out.println(String.format("%d÷%d=%d...%d", a, b, a / b, a % b));

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Question3()
    {
        try
        {
            System.out.print("一つ目の商品の値段は？");
            Scanner in = new Scanner(System.in);
            int priceA = in.nextInt();
            System.out.print("個数は？");
            int amountA = in.nextInt();
            System.out.print("二つ目の商品の値段は？");
            int priceB = in.nextInt();
            System.out.print("個数は？");
            int amountB = in.nextInt();

            System.out.println(String.format("お支払いは税込み￥%dです", (int)((priceA * amountA + priceB * amountB) * 1.08f)));

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Question4()
    {
        try
        {
            Golem golem = new Golem();

            System.out.println(String.format("ゴーレム　（HP:%d　防御力：%d）\n", golem.hp, golem.defense));
            System.out.println("HP：" + golem.hp);
            System.out.print("今回の攻撃の値を入力してください＞");
            Scanner in = new Scanner(System.in);
            int atk = in.nextInt();
            atk = atk - golem.defense > 0 ? atk - golem.defense : 0;
            System.out.println("ダメージは" + atk + "です");
            golem.hp -= atk;
            System.out.println("残りのHPは" + golem.hp + "です");

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
