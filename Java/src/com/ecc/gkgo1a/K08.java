package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class K08 extends IExecutable {

    @Override
    public void Question1() {
        Vector<Integer> numbers = new Vector<>();
        Scanner in = new Scanner(System.in);
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(String.format("%dつ目の値を入力してください。＞", i + 1));
                numbers.add(in.nextInt());
            }
            System.out.println("どちらを調べますか？");
            System.out.print("（０：最大値　１：最小値）＞");
            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    System.out.println(String.format("%dの中で最大値は%dです。", numbers.size(),
                            K08_1Sub.GetMaxValue(numbers.get(0), numbers.get(1), numbers.get(2))));
                    break;
                case 1:
                    System.out.println(String.format("%dの中で最小値は%dです。", numbers.size(),
                            K08_1Sub.GetMinValue(numbers.get(0), numbers.get(1), numbers.get(2))));
                    break;
            }
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Question2() {
        try {
            System.out.println("冒険が今始まる！");
            Random random = new Random();
            int playerHp = 200 + random.nextInt(101);
            int continueGame = 1;
            Scanner in = new Scanner(System.in);
            do {
                if (playerHp == 0)
                    return;

                System.out.println("あなたのHP：" + playerHp);
                System.out.print("奥に進みますか？（１：奥に進む　０．帰る）＞");
                continueGame = in.nextInt();
                if (continueGame == 1) {
                    int golemLv = random.nextInt(5);
                    playerHp = K08_2Sub.AttackGolem(golemLv, playerHp);
                }
            } while (continueGame != 0);
            System.out.println("リレ〇ト！");
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Question3() {
    }

    @Override
    public void Question4() {
    }
}
