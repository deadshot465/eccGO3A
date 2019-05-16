use crate::golem::Golem;
use crate::read_user_input::read_user_input;
use std::io::Write;
use std::collections::HashMap;

#[derive(PartialEq, Eq, Hash)]
enum AttackMethod {
    Attack,
    Skill,
    Magic
}

pub fn attack_golem(lv: i32, player_hp: &mut i32) {
    let mut golem = Golem {
        hp: lv * 50 + 100,
        defense: lv * 10 + 40,
        attack: lv * 10 + 30
    };

    let mut attack_options: HashMap<AttackMethod, i32> = HashMap::new();
    attack_options.insert(AttackMethod::Attack, 65);
    attack_options.insert(AttackMethod::Skill, 99);
    attack_options.insert(AttackMethod::Magic, 133);

    println!("ゴーレムLv.{}が現れた！", lv + 1);
    while golem.hp > 0 {
        println!("\n残りHP：{}", golem.hp);
        print!("武器を選択してください（１．攻撃　２．特技　３．魔法）＞");
        std::io::stdout().flush().unwrap();
        let mut choice = String::new();
        let choice = match read_user_input(&mut choice) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        let damage = match choice {
            1 => attack_options.get(&AttackMethod::Attack).unwrap(),
            2 => attack_options.get(&AttackMethod::Skill).unwrap(),
            3 => attack_options.get(&AttackMethod::Magic).unwrap(),
            _ => &0
        };

        let mut damage = damage.clone() - golem.defense;
        if damage <= 0 {
            damage = 0;
            println!("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
            println!("ゴーレムがあなたを攻撃しました！攻撃値：{}", golem.attack);
            *player_hp -= golem.attack;
            if *player_hp <= 0 {
                *player_hp = 0;
                println!("あなたはゴーレムに負けました！ゲームオーバー！");
                return;
            }
            println!("あなたの残りHPは：{}", player_hp);
        }

        println!("ダメージは{}です。", damage);
        golem.hp -= damage;

        if golem.hp <= 0 {
            golem.hp = 0;
        }

        if golem.hp == 0 {
            println!("ゴーレムLv.{}を倒した！", lv + 1);
        }
    }
}