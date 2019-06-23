use crate::player::Player;
use crate::enemy::Enemy;
use crate::read_user_input::read_user_input;
use std::io::Write;
use rand::Rng;
use crate::attack::Attack;
use crate::kex_1sub::{ATTACK_HIT, SKILL_HIT, MAGIC_HIT, check_hit_or_miss};

pub fn attack_enemy(player: &mut Player, enemy: &mut Enemy) -> bool {
    println!("{}Lv.{}が現れた！", enemy.name, enemy.lv + 1);

    while enemy.hp > 0 {
        println!("{} 残りHP：{}", enemy.name, enemy.hp);

        let mut reader = String::new();
        print!("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
        std::io::stdout().flush().unwrap();
        let choice = match read_user_input(&mut reader) {
            Ok(x) => x,
            Err(ex) => {
                eprintln!("エラーが発生しました：{}", ex.to_string());
                return false
            }
        };

        let get_attack_power = || { rand::thread_rng().gen_range(0, 41) + 60 };
        let get_skill_power = || { rand::thread_rng().gen_range(0, 101) + 30 };
        let get_magic_power = || { rand::thread_rng().gen_range(0, 181) + 20 };
        let get_powers: [Box<Fn() -> i32>; 3] = [Box::new(get_attack_power)
            , Box::new(get_skill_power), Box::new(get_magic_power)];
        let mut attacks = [Attack::new(), Attack::new(), Attack::new()];
        let get_hits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT];

        for x in 0..3 {
            attacks[x].damage = get_powers[x]();
            attacks[x].hit = get_hits[x];
        }

        let mut damage = 0;
        let mut is_hit = false;

        match choice {
            1 => {
                damage = attacks[0].damage;
                is_hit = check_hit_or_miss(attacks[0].hit - enemy.flee);
            },
            2 => {
                damage = attacks[1].damage;
                is_hit = check_hit_or_miss(attacks[1].hit - enemy.flee);
            },
            3 => {
                damage = attacks[2].damage;
                is_hit = check_hit_or_miss(attacks[2].hit - enemy.flee);
            },
            _ => ()
        };

        if is_hit {
            damage -= enemy.defense;
            damage = if damage <= 0 {
                0
            } else {
                damage
            };

            println!("{}のダメージ！", damage);
            enemy.hp -= damage;
        } else {
            println!("攻撃を外した！");
        }

        println!("{}の攻撃！", enemy.name);
        is_hit = check_hit_or_miss(enemy.hit);
        if is_hit {
            let mut injury = enemy.attack - player.defense;
            injury = if injury <= 0 {
                0
            } else {
                injury
            };
            println!("{}のダメージ！", injury);
            player.hp -= injury;
            if player.hp <= 0 {
                player.hp = 0;
                println!("あなたは{}に負けました！ゲームオーバー！", enemy.name);
                return false
            }
        } else {
            println!("攻撃を外した！");
        }

        println!("プレイヤー残りHP：{}", player.hp);
        enemy.hp = if enemy.hp <= 0 {
            0
        } else {
            enemy.hp
        };

        if enemy.hp == 0 {
            println!("{}Lv.{}を倒した！", enemy.name, enemy.lv + 1);
        }
    }
    true
}