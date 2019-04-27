package com.ecc.gkgo1a;

import java.util.Scanner;

public class K02_4 implements IExecutable {

    @Override
    public void Execute() {

        try
        {
            Golem golem = new Golem();
            golem.hp = 300;
            golem.defense = 80;

            System.out.println(String.format("ゴーレム　（HP:%d　防御力：%d)\n", golem.hp, golem.defense));
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
