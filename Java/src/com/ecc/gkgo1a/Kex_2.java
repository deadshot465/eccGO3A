package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class Kex_2 {
    public static void Execute() {
        System.out.println("冒険が今始まる！");
        Player player = new Player();
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        int continueGame = 1;
        int kills = 0;

        while (continueGame != 0) {
            System.out.printf("現HP：%d\n", player.Hp);
            System.out.print("奥に進みますか？（１：奥に進む　０．帰る）＞");
            continueGame = reader.nextInt();
            if (continueGame == 1) {
                int typeNo = rand.nextInt(3);
                EnemyType type = EnemyType.TYPE_GOLEM;
                switch (typeNo) {
                    case 1:
                        type = EnemyType.TYPE_GOBLIN;
                        break;
                    case 2:
                        type = EnemyType.TYPE_SLIME;
                        break;
                }
                Enemy enemy = Kex_2_Enemy.CreateEnemy(type);
                boolean result = Kex_2_Battle.AttackEnemy(player, enemy);
                kills++;
                if (!result) {
                    break;
                }
            }
        }
        System.out.println("リ〇ミト！\n");
        System.out.printf("戦闘回数：%d回　残りHP：%d\n", kills, player.Hp);
    }
}
