use crate::enemy::Enemy;
use rand::Rng;

const MAX_GOLEM_LEVEL: i32 = 5;
const MAX_GOBLIN_LEVEL: i32 = 7;
const MAX_SLIME_LEVEL: i32 = 9;
const GOLEM_HIT: i32 = 75;
const GOLEM_FLEE: i32 = 20;
const GOBLIN_HIT: i32 = 85;
const GOBLIN_FLEE: i32 = 40;
const SLIME_HIT: i32 = 95;
const SLIME_FLEE: i32 = 30;

pub enum EnemyType {
    TypeGolem = 0,
    TypeGoblin = 1,
    TypeSlime = 2
}

impl From<i32> for EnemyType {
    fn from(i: i32) -> Self {
        match i {
            0 => EnemyType::TypeGolem,
            1 => EnemyType::TypeGoblin,
            2 => EnemyType::TypeSlime,
            _ => panic!("Enemy type not supported.")
        }
    }
}

pub fn create_enemy(type_no: EnemyType) -> Enemy {
    let mut enemy = Enemy::new();
    match type_no {
        EnemyType::TypeGolem => {
            let lv = rand::thread_rng().gen_range(0, MAX_GOLEM_LEVEL);
            enemy.lv = lv;
            enemy.hp = lv * 50 + 100;
            enemy.defense = lv * 10 + 40;
            enemy.attack = lv * 10 + 40;
            enemy.hit = GOLEM_HIT;
            enemy.flee = GOLEM_FLEE;
            enemy.name = String::from("ゴーレム");
        },
        EnemyType::TypeGoblin => {
            let lv = rand::thread_rng().gen_range(0, MAX_GOBLIN_LEVEL);
            enemy.lv = lv;
            enemy.hp = lv * 30 + 75;
            enemy.defense = lv * 5 + 20;
            enemy.attack = lv * 5 + 20;
            enemy.hit = GOBLIN_HIT;
            enemy.flee = GOBLIN_FLEE;
            enemy.name = String::from("ゴブリン");
        },
        EnemyType::TypeSlime => {
            let lv = rand::thread_rng().gen_range(0, MAX_SLIME_LEVEL);
            enemy.lv = lv;
            enemy.hp = lv * 10 + 50;
            enemy.defense = lv * 2 + 10;
            enemy.attack = lv * 2 + 10;
            enemy.hit = SLIME_HIT;
            enemy.flee = SLIME_FLEE;
            enemy.name = String::from("スライム");
        }
    }
    enemy
}