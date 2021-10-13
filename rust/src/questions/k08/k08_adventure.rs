use crate::shared::structs::golem::Golem;
use crate::shared::utility::read_user_input;
use rand::Rng;
use std::io::Write;

#[derive(PartialEq, Eq, Hash, Copy, Clone, Debug)]
enum AttackMethod {
    Attack(i32),
    Skill(i32),
    Magic(i32),
}

#[derive(Clone, Debug)]
enum ProgressResult {
    End(String),
    Continue(i32),
}

pub fn game_loop(mut player_hp: i32) -> anyhow::Result<String> {
    while player_hp > 0 {
        println!("あなたのHP：{}", player_hp);
        println!("奥に進みますか？（１：奥に進む　０．帰る）＞");
        let choice = read_user_input::<i32>()?;

        match choice {
            0 => {
                return Ok("リレ〇ト！".to_string());
            }
            _ => match engage_battle(player_hp) {
                Ok(hp) => match hp {
                    ProgressResult::End(s) => {
                        println!("{}", s);
                        break;
                    }
                    ProgressResult::Continue(hp) => player_hp = hp,
                },
                Err(e) => return Err(anyhow::anyhow!("{}", e)),
            },
        }
    }
    Ok("ゲームオーバー！".to_string())
}

fn select_attack(choice: i32) -> AttackMethod {
    let mut rng = rand::thread_rng();
    match choice {
        1 => AttackMethod::Attack(rng.gen_range(0..36) + 65),
        2 => AttackMethod::Skill(rng.gen_range(0..101) + 50),
        3 => AttackMethod::Magic(rng.gen_range(0..168) + 33),
        _ => select_attack(1),
    }
}

fn damage_player(golem_attack: i32, player_hp: i32) -> i32 {
    println!("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
    println!("ゴーレムがあなたを攻撃しました！攻撃値：{}", golem_attack);
    player_hp - golem_attack
}

fn battle_loop(
    golem_level: i32,
    mut golem: Golem,
    mut player_hp: i32,
) -> anyhow::Result<ProgressResult> {
    while golem.hp > 0 {
        println!("ゴーレムLv.{} 残りHP：{}", golem_level + 1, golem.hp);
        print!("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
        std::io::stdout().flush()?;

        let base_damage = match select_attack(read_user_input()?) {
            AttackMethod::Attack(dmg) => dmg,
            AttackMethod::Skill(dmg) => dmg,
            AttackMethod::Magic(dmg) => dmg,
        };

        println!("基礎ダメージは{}です。", base_damage);

        let actual_damage = if base_damage - golem.defense < 0 {
            0
        } else {
            base_damage - golem.defense
        };

        println!("実際ダメージは{}です。", actual_damage);

        if actual_damage <= 0 {
            player_hp = damage_player(golem.attack, player_hp);
            if player_hp <= 0 {
                return Ok(ProgressResult::End(
                    "あなたはゴーレムに負けました！".to_string(),
                ));
            }
            println!("あなたの残りHPは：{}", player_hp);
        } else {
            golem.hp = if golem.hp - actual_damage <= 0 {
                0
            } else {
                golem.hp - actual_damage
            };
        }
    }

    println!("ゴーレムLv.{}を倒した！", golem_level + 1);
    Ok(ProgressResult::Continue(player_hp))
}

fn engage_battle(player_hp: i32) -> anyhow::Result<ProgressResult> {
    let golem_level = rand::thread_rng().gen_range(0..10);
    let golem = Golem {
        hp: golem_level * 50 + 100,
        defense: golem_level * 10 + 40,
        attack: golem_level * 10 + 30,
    };
    println!("ゴーレムLv.{}が現れた！", golem_level + 1);
    battle_loop(golem_level, golem, player_hp)
}
