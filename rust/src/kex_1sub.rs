use crate::golem::GolemEx;
use crate::player::Player;
use crate::read_user_input::read_user_input;
use rand::Rng;
use std::io::Write;

const ATTACK_HIT: i32 = 110;
const SKILL_HIT: i32 = 100;
const MAGIC_HIT: i32 = 70;

fn check_hit_or_miss(hit: i32) -> bool {
    let val = rand::thread_rng().gen_range::<i32>(0, 100);
    val <= hit - 1
}

pub fn attack_golem(lv: i32, player: &mut Player) {
    let mut golem = GolemEx::new(
        lv * 50 + 100,
        lv * 10 + 40,
        lv * 10 + 40
    );

    println!("ゴーレムLv.{}が現れた！", lv + 1);
    while golem.hp > 0 {
        println!("ゴーレム 残りHP：{}", golem.hp);
        print!("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
        std::io::stdout().flush().unwrap();
        let mut reader = String::new();
        let choice = match read_user_input(&mut reader) {
            Ok(x) => x,
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };
        let mut damage = 0;
        let mut is_hit = false;
        match choice {
            1 => {
                damage = 60 + rand::thread_rng().gen_range::<i32>(0, 41);
                is_hit = check_hit_or_miss(ATTACK_HIT - golem.flee);
            },
            2 => {
                damage = 30 + rand::thread_rng().gen_range::<i32>(0, 101);
                is_hit = check_hit_or_miss(SKILL_HIT - golem.flee);
            }
            3 => {
                damage = 20 + rand::thread_rng().gen_range::<i32>(0, 181);
                is_hit = check_hit_or_miss(MAGIC_HIT - golem.flee);
            },
            _ => ()
        }

        if is_hit {
            damage -= golem.defense;
            if damage <= 0 {
                damage = 0;
            }
            println!("{}のダメージ！", damage);
            golem.hp -= damage;
        } else {
            println!("攻撃を外した！");
        }

        println!("ゴーレムの攻撃！");
        is_hit = check_hit_or_miss(golem.hit);
        if is_hit {
            let injury = golem.attack - player.defense;
            println!("{}のダメージ！", injury);
            player.hp -= injury;
            if player.hp <= 0 {
                player.hp = 0;
                println!("あなたはゴーレムに負けました！ゲームオーバー！");
                return;
            }
        } else {
            println!("攻撃を外した！");
        }

        println!("プレーヤー残りHP：{}", player.hp);
        if golem.hp <= 0 { golem.hp = 0; }
        if golem.hp == 0 {
            println!("ゴーレムLv.{}を倒した！", lv + 1);
        }
    }
}