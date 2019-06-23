import { Enemy } from "./Enemy";

const MAX_GOLEM_LEVEL = 4;
const MAX_GOBLIN_LEVEL = 6;
const MAX_SLIME_LEVEL = 8;
const GOLEM_HIT = 75;
const GOLEM_FLEE = 20;
const GOBLIN_HIT = 85;
const GOBLIN_FLEE = 40;
const SLIME_HIT = 95;
const SLIME_FLEE = 30;

export enum EnemyType {
    TYPE_GOLEM = 0,
    TYPE_GOBLIN = 1,
    TYPE_SLIME = 2
}

export function CreateEnemy(type: EnemyType): Enemy {
    let enemy: Enemy;

    switch (type) {
        case EnemyType.TYPE_GOLEM:
            {
                let lv = Math.round(Math.random() * MAX_GOLEM_LEVEL);
                enemy = new Enemy(lv, lv * 50 + 100, lv * 10 + 40, lv * 10 + 40,
                    GOLEM_HIT, GOLEM_FLEE, 'ゴーレム');
                break;
            }
        case EnemyType.TYPE_GOBLIN:
            {
                let lv = Math.round(Math.random() * MAX_GOBLIN_LEVEL);
                enemy = new Enemy(lv, lv * 30 + 75, lv * 5 + 20, lv * 5 + 20,
                    GOBLIN_HIT, GOBLIN_FLEE, 'ゴブリン');
                break;
            }
        case EnemyType.TYPE_SLIME:
            {
                let lv = Math.round(Math.random() * MAX_SLIME_LEVEL);
                enemy = new Enemy(lv, lv * 10 + 50, lv * 2 + 10, lv * 2 + 10,
                    SLIME_HIT, SLIME_FLEE, 'スライム');
                break;
            }
    }

    return enemy;
}