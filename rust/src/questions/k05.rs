use crate::shared::structs::golem::Golem;
use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use rand::prelude::*;
use std::io::Write;

pub struct K05 {}

impl Executable for K05 {
    fn question_1(&self) -> anyhow::Result<()> {
        let mut salary: f32 = 19.0;
        let mut age: i32 = 22;

        while salary < 50.0 {
            salary *= 1.035;
            age += 1;
        }

        println!("{}歳で月給{}万円", age, salary);
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        let mut choice = 0;

        while choice != 1 {
            println!("起きろ～");
            print!("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            std::io::stdout().flush()?;
            choice = read_user_input::<i32>()?;
        }
        println!("よし、学校へ行こう！");
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        loop {
            println!("起きろ～");
            print!("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            std::io::stdout().flush()?;
            let choice = read_user_input::<i32>()?;
            if choice == 1 {
                println!("よし、学校へ行こう！");
            }
        }
    }

    fn question_4(&self) -> anyhow::Result<()> {
        let rand_num = rand::thread_rng().gen_range(0..201);
        let mut golem = Golem::new(300 + rand_num);
        let mut player_hp = 200 + rand::thread_rng().gen_range(0..101);

        println!("ゴーレム　（HP:{}　防御力：{}）", golem.hp, golem.defense);

        while golem.hp > 0 {
            println!("HP：{}", golem.hp);
            print!("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
            std::io::stdout().flush()?;

            let choice = read_user_input::<i32>()?;

            let damage = match choice {
                1 => 60 + rand::thread_rng().gen_range(0..41),
                2 => 30 + rand::thread_rng().gen_range(0..101),
                3 => 20 + rand::thread_rng().gen_range(0..181),
                _ => 0,
            };

            println!("基礎攻撃力は{}です。", damage);
            let damage = if damage - golem.defense <= 0 {
                0
            } else {
                damage - golem.defense
            };
            if damage == 0 {
                println!("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                println!("ゴーレムがあなたを攻撃しました！攻撃値：{}", golem.attack);
                player_hp -= golem.attack;

                if player_hp <= 0 {
                    println!("あなたはゴーレムに負けました！ゲームオーバー！");
                    return Ok(());
                }
                println!("あなたの残りHPは：{}", player_hp);
            }
            println!("ダメージは{}です。", damage);
            golem.hp -= damage;

            if golem.hp < 0 {
                golem.hp = 0;
            }

            println!("残りのHPは{}です。", golem.hp);
            if golem.hp == 0 {
                println!("ゴーレムを倒しました！");
            }
        }
        Ok(())
    }
}
