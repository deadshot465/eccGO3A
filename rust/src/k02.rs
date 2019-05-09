use crate::golem::Golem;
use crate::executable::Executable;
use crate::read_user_input::read_user_input;
use std::io::Write;

pub struct K02 {}
impl K02
{
    pub fn new() -> K02
    {
        K02 {}
    }
}

impl Executable for K02
{
    fn question_1(&self)
    {
        let seisuu = 3;
        let jissuu: f32 = 2.6;
        let moji = 'A';

        println!("整数seisuuの値は{}", seisuu);
        println!("実数jissuuの値は{}", jissuu);
        println!("文字mojiの値は{}", moji);
    }

    fn question_2(&self)
    {
        print!("一つ目の整数は？");
        std::io::stdout().flush().unwrap();
        let mut first_number = String::new();
        let first_number = match read_user_input(&mut first_number) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("二つ目の整数は？");
        std::io::stdout().flush().unwrap();
        let mut second_number = String::new();
        let second_number = match read_user_input(&mut second_number) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        println!("{}÷{}={}...{}", first_number, second_number, first_number / second_number, first_number % second_number);
    }

    fn question_3(&self)
    {
        print!("一つ目の商品の値段は？");
        std::io::stdout().flush().unwrap();
        let mut price_a = String::new();
        let price_a = match read_user_input(&mut price_a) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("個数は？");
        std::io::stdout().flush().unwrap();
        let mut amount_a = String::new();
        let amount_a = match read_user_input(&mut amount_a) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("二つ目の商品の値段は？");
        std::io::stdout().flush().unwrap();
        let mut price_b = String::new();
        let price_b = match read_user_input(&mut price_b) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("個数は？");
        std::io::stdout().flush().unwrap();
        let mut amount_b = String::new();
        let amount_b = match read_user_input(&mut amount_b) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        let total: f32 = (price_a * amount_a + price_b * amount_b) as f32 * 1.08;
        println!("お支払いは税込み￥{}です", total);
    }

    fn question_4(&self)
    {
        let mut golem = Golem::default();

        println!("ゴーレム　（HP:{}　防御力：{}）", golem.hp, golem.defense);
        println!("HP：{}", golem.hp);
        print!("今回の攻撃の値を入力してください＞");
        std::io::stdout().flush().unwrap();

        let mut damage = String::new();
        let mut damage = match read_user_input(&mut damage) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        damage =
            if damage - golem.defense > 0 {
                damage - golem.defense
            } else {
                0
            };

        println!("ダメージは{}です。", damage);
        golem.hp -= damage;
        println!("残りのHPは{}です。", golem.hp);
    }
}
