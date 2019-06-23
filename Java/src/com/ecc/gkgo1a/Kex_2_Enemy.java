package com.ecc.gkgo1a;

import java.util.Random;

public class Kex_2_Enemy {
    private static final int MAX_GOLEM_LEVEL = 5;
    private static final int MAX_GOBLIN_LEVEL = 7;
    private static final int MAX_SLIME_LEVEL = 9;
    private static final int GOLEM_HIT = 75;
    private static final int GOLEM_FLEE = 20;
    private static final int GOBLIN_HIT = 85;
    private static final int GOBLIN_FLEE = 40;
    private static final int SLIME_HIT = 95;
    private static final int SLIME_FLEE = 30;

    public static Enemy CreateEnemy(EnemyType type) {
        Enemy enemy = new Enemy();
        Random random = new Random();

        switch (type) {
            case TYPE_GOLEM:
            {
                int lv = random.nextInt(MAX_GOLEM_LEVEL);
                enemy.Lv = lv;
                enemy.Hp = lv * 50 + 100;
                enemy.Defense = lv * 10 + 40;
                enemy.Attack = lv * 10 + 40;
                enemy.Hit = GOLEM_HIT;
                enemy.Flee = GOLEM_FLEE;
                enemy.Name = "ゴーレム";
                break;
            }
            case TYPE_GOBLIN:
            {
                int lv = random.nextInt(MAX_GOBLIN_LEVEL);
                enemy.Lv = lv;
                enemy.Hp = lv * 30 + 75;
                enemy.Defense = lv * 5 + 20;
                enemy.Attack = lv * 5 + 20;
                enemy.Hit = GOBLIN_HIT;
                enemy.Flee = GOBLIN_FLEE;
                enemy.Name = "ゴブリン";
                break;
            }
            case TYPE_SLIME:
            {
                int lv = random.nextInt(MAX_SLIME_LEVEL);
                enemy.Lv = lv;
                enemy.Hp = lv * 10 + 50;
                enemy.Defense = lv * 2 + 10;
                enemy.Attack = lv * 2 + 10;
                enemy.Hit = SLIME_HIT;
                enemy.Flee = SLIME_FLEE;
                enemy.Name = "スライム";
                break;
            }
        }

        return enemy;
    }
}
