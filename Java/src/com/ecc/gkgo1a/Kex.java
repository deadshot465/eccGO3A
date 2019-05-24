package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class Kex {
    public static void Execute() {
        Random rand = new Random();
        System.out.println("冒険が今始まる！");
        Player player = new Player();
        int continueGame = 1;
        int kills = 0;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.printf("現HP：%d\n", player.Hp);
            System.out.print("奥に進みますか？（１：奥に進む　０．帰る）＞");
            continueGame = reader.nextInt();
            if (continueGame != 0) {
                int golemLv = rand.nextInt(5);
                player = Kex_1sub.AttackGolem(golemLv, player);
                kills++;
                if (player.Hp == 0)
                    break;
            }
        } while (continueGame != 0);

        System.out.println("リ〇ミト！");
        System.out.printf("戦闘回数：%d　残りHP：%d\n", kills, player.Hp);
    }
}
