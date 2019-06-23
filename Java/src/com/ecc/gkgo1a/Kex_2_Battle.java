package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.function.Supplier;

public class Kex_2_Battle {
    public static boolean AttackEnemy(Player player, Enemy enemy) {
        System.out.printf("%sLv.%dが現れた！\n", enemy.Name, enemy.Lv + 1);
        Random rand = new Random();

        while (enemy.Hp > 0) {
            System.out.printf("%s 残りHP：%d\n", enemy.Name, enemy.Hp);
            Scanner reader = new Scanner(System.in);
            System.out.print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
            int choice = reader.nextInt();
            Supplier<Integer> getAttackPower = () -> rand.nextInt(41) + 60;
            Supplier<Integer> getSkillPower = () -> rand.nextInt(101) + 30;
            Supplier<Integer> getMagicPower = () -> rand.nextInt(181) + 20;
            Attack[] attacks = {new Attack(), new Attack(), new Attack()};
            Vector<Supplier<Integer>> getPowers = new Vector<>();
            getPowers.add(getAttackPower);
            getPowers.add(getSkillPower);
            getPowers.add(getMagicPower);
            int[] getHits = {Kex_1sub.ATTACK_HIT, Kex_1sub.SKILL_HIT, Kex_1sub.MAGIC_HIT};
            for (int i = 0; i < attacks.length; i++) {
                attacks[i].Damage = getPowers.get(i).get();
                attacks[i].Hit = getHits[i];
            }
            int damage = 0;
            boolean isHit = false;

            switch (choice) {
                case 1:
                    damage = attacks[0].Damage;
                    isHit = Kex_1sub.CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
                    break;
                case 2:
                    damage = attacks[1].Damage;
                    isHit = Kex_1sub.CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
                    break;
                case 3:
                    damage = attacks[2].Damage;
                    isHit = Kex_1sub.CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
                    break;
            }

            if (isHit) {
                damage -= enemy.Defense;
                damage = damage <= 0 ? 0 : damage;
                System.out.printf("%dのダメージ！\n", damage);
                enemy.Hp -= damage;
            } else {
                System.out.println("攻撃を外した！");
            }

            System.out.printf("%sの攻撃！\n", enemy.Name);
            isHit = Kex_1sub.CheckHitOrMiss(enemy.Hit);
            if (isHit) {
                int injury = enemy.Attack - player.Defense;
                injury = injury <= 0 ? 0 : injury;
                System.out.printf("%dのダメージ！\n", injury);
                player.Hp -= injury;
                if (player.Hp <= 0) {
                    player.Hp = 0;
                    System.out.printf("あなたは%sに負けました！ゲームオーバー！\n", enemy.Name);
                    return false;
                }
            } else {
                System.out.println("攻撃を外した！");
            }

            System.out.printf("プレイヤー残りHP：%d\n", player.Hp);
            enemy.Hp = enemy.Hp <= 0 ? 0 : enemy.Hp;
            if (enemy.Hp == 0) {
                System.out.printf("%sLv.%dを倒した！\n", enemy.Name, enemy.Lv + 1);
            }
        }
        return true;
    }
}