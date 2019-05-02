use crate::executable::Executable;
use crate::golem::Golem;
use rand::Rng;
use std::io::Write;

pub struct K05 {}
impl K05 {
    pub fn new() -> K05 {
        K05 {}
    }
}

impl Executable for K05 {
    fn question_1(&self) {
        let mut salary: f32 = 19.0;
        let mut age: i32 = 22;

        while salary < 50.0 {
            salary *= 1.035;
            age += 1;
        }

        println!("{}歳で月給{}万円", age, salary);
    }

    fn question_2(&self) {
        let mut choice_num = 0;

        while choice_num != 1 {
            let choice_ptr: &mut i32 = &mut choice_num;
            println!("起きろ～");
            print!("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            std::io::stdout().flush();
            let mut choice = String::new();
            std::io::stdin().read_line(&mut choice).expect("入力失敗！");
            *choice_ptr = choice.trim().parse::<i32>().expect("入力失敗！");
        }
        println!("よし、学校へ行こう！");
    }

    fn question_3(&self) {

        loop {
            println!("起きろ～");
            print!("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            std::io::stdout().flush();
            let mut choice = String::new();
            std::io::stdin().read_line(&mut choice).expect("入力失敗！");
            let choice = choice.trim().parse::<i32>().expect("入力失敗！");
            if choice == 1 {
                println!("よし、学校へ行こう！");
            }
        }
    }

    fn question_4(&self) {
        let rand_num = rand::thread_rng().gen_range(0, 200);

        let mut golem = Golem {
            hp: 300 + rand_num,
            defense: 80,
            attack: 50
        };

        let mut player_hp = 200 + rand::thread_rng().gen_range(0, 100);

        println!("ゴーレム　（HP:{}　防御力：{}）", golem.hp, golem.defense);

        while golem.hp > 0 {
            println!("HP：{}", golem.hp);
            print!("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞");
            std::io::stdout().flush();

            let mut option = String::new();
            std::io::stdin().read_line(&mut option).expect("入力失敗！");
            let option = option.trim().parse::<i32>().expect("入力失敗！");
            let mut damage: i32 = 0;

            match option {
                1 => damage = 60 + rand::thread_rng().gen_range(0, 41),
                2 => damage = 30 + rand::thread_rng().gen_range(0, 101),
                3 => damage = 20 + rand::thread_rng().gen_range(0, 181),
                _ => ()
            }

            println!("基礎攻撃力は{}です。", damage);
            if damage - golem.defense <= 0
            {
                damage = 0;
                println!("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                println!("ゴーレムがあなたを攻撃しました！攻撃値：{}", golem.attack);
                player_hp -= golem.attack;

                if player_hp <= 0
                {
                    println!("あなたはゴーレムに負けました！ゲームオーバー！");
                    return;
                }
                println!("あなたの残りHPは：{}", player_hp);
            }
            println!("ダメージは{}です。", damage);
            golem.hp -= damage;

            if golem.hp < 0 {
                golem.hp = 0;
            }

            println!("残りのHPは{}です。", golem.hp);
            if golem.hp == 0
            {
                println!("ゴーレムを倒しました！");
            }
        }
    }
}