package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class Kex_1sub {
    private static final int ATTACK_HIT = 110;
    private static final int SKILL_HIT = 100;
    private static final int MAGIC_HIT = 70;

    private static boolean CheckHitOrMiss(int hit) {
        Random rand = new Random();
        int val = rand.nextInt(100);
        return val <= hit - 1;
    }

    public static Player AttackGolem(int lv, Player player) {
        GolemEx golem = new GolemEx(
                lv * 50 + 100,
                lv * 10 + 40,
                lv * 10 + 40
        );

        System.out.println(String.format("ゴーレムLv.%dが現れた！", lv + 1));
        try {
            while (golem.Hp > 0) {
                System.out.printf("ゴーレム 残りHP：%d\n", golem.Hp);
                System.out.print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
                Scanner reader = new Scanner(System.in);
                int damage = 0;
                boolean is_hit = false;
                Random rand = new Random();
                switch (reader.nextInt()) {
                    case 1:
                        damage = 60 + rand.nextInt(41);
                        is_hit = CheckHitOrMiss(ATTACK_HIT - golem.Flee);
                        break;
                    case 2:
                        damage = 30 + rand.nextInt(101);
                        is_hit = CheckHitOrMiss(SKILL_HIT - golem.Flee);
                        break;
                    case 3:
                        damage = 20 + rand.nextInt(181);
                        is_hit = CheckHitOrMiss(MAGIC_HIT - golem.Flee);
                        break;
                    default:
                        break;
                }

                if (is_hit) {
                    damage -= golem.Defense;
                    if (damage <= 0)
                        damage = 0;
                    System.out.printf("%dのダメージ！\n", damage);
                    golem.Hp -= damage;
                } else {
                    System.out.println("攻撃を外した！");
                }

                System.out.println("ゴーレムの攻撃！");
                is_hit = CheckHitOrMiss(golem.Hit);
                if (is_hit) {
                    int injury = golem.Attack - player.Defense;
                    System.out.printf("%dのダメージ！\n", injury);
                    player.Hp -= injury;
                    if (player.Hp <= 0) {
                        player.Hp = 0;
                        System.out.println("あなたはゴーレムに負けました！ゲームオーバー！");
                        return player;
                    }
                } else {
                    System.out.println("攻撃を外した！");
                }

                System.out.printf("プレイヤー残りHP：%d\n", player.Hp);
                if (golem.Hp <= 0)
                    golem.Hp = 0;
                if (golem.Hp == 0)
                    System.out.printf("ゴーレムLv.%dを倒した！\n", lv + 1);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return player;
    }
}
