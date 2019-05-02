use crate::golem::Golem;
use crate::executable::Executable;
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
        std::io::stdout().flush();
        let mut first_number = String::new();
        std::io::stdin().read_line(&mut first_number).expect("入力失敗！");
        let first_number = first_number.trim().parse::<i32>().expect("入力失敗！");
        print!("二つ目の整数は？");
        std::io::stdout().flush();
        let mut second_number = String::new();
        std::io::stdin().read_line(&mut second_number).expect("入力失敗！");
        let second_number = second_number.trim().parse::<i32>().expect("入力失敗！");

        println!("{}÷{}={}...{}", first_number, second_number, first_number / second_number, first_number % second_number);
    }

    fn question_3(&self)
    {
        print!("一つ目の商品の値段は？");
        std::io::stdout().flush();
        let mut price_a = String::new();
        std::io::stdin().read_line(&mut price_a).expect("入力失敗！");
        let price_a = price_a.trim().parse::<i32>().expect("入力失敗！");
        print!("個数は？");
        std::io::stdout().flush();
        let mut amount_a = String::new();
        std::io::stdin().read_line(&mut amount_a).expect("入力失敗！");
        let amount_a = amount_a.trim().parse::<i32>().expect("入力失敗！");

        print!("二つ目の商品の値段は？");
        std::io::stdout().flush();
        let mut price_b = String::new();
        std::io::stdin().read_line(&mut price_b).expect("入力失敗！");
        let price_b = price_b.trim().parse::<i32>().expect("入力失敗！");
        print!("個数は？");
        std::io::stdout().flush();
        let mut amount_b = String::new();
        std::io::stdin().read_line(&mut amount_b).expect("入力失敗！");
        let amount_b = amount_b.trim().parse::<i32>().expect("入力失敗！");

        let total: f32 = (price_a * amount_a + price_b * amount_b) as f32 * 1.08;
        println!("お支払いは税込み￥{}です", total);
    }

    fn question_4(&self)
    {
        let mut golem = Golem { hp: 300, defense: 80, attack: 50 };

        println!("ゴーレム　（HP:{}　防御力：{}）", golem.hp, golem.defense);
        println!("HP：{}", golem.hp);
        print!("今回の攻撃の値を入力してください＞");
        std::io::stdout().flush();

        let mut damage = String::new();
        std::io::stdin().read_line(&mut damage).expect("入力失敗！");
        let mut damage = damage.trim().parse::<i32>().expect("入力失敗！");
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
