use crate::shared::structs::golem::Golem;
use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use std::io::Write;

pub struct K02 {}

impl Executable for K02 {
    fn question_1(&self) -> anyhow::Result<()> {
        let seisuu = 3;
        let jissuu: f32 = 2.6;
        let moji = 'A';

        println!("整数seisuuの値は{}", seisuu);
        println!("実数jissuuの値は{}", jissuu);
        println!("文字mojiの値は{}", moji);
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        print!("一つ目の整数は？");
        std::io::stdout().flush()?;
        let first_number = read_user_input::<i32>()?;

        print!("二つ目の整数は？");
        std::io::stdout().flush()?;
        let second_number = read_user_input::<i32>()?;

        println!(
            "{}÷{}={}...{}",
            first_number,
            second_number,
            first_number / second_number,
            first_number % second_number
        );
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        print!("一つ目の商品の値段は？");
        std::io::stdout().flush()?;
        let price_a = read_user_input::<i32>()?;

        print!("個数は？");
        std::io::stdout().flush()?;
        let amount_a = read_user_input::<i32>()?;

        print!("二つ目の商品の値段は？");
        std::io::stdout().flush()?;
        let price_b = read_user_input::<i32>()?;

        print!("個数は？");
        std::io::stdout().flush()?;
        let amount_b = read_user_input::<i32>()?;

        let total: f32 = (price_a * amount_a + price_b * amount_b) as f32 * 1.08;
        println!("お支払いは税込み￥{}です", total);
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        let mut golem = Golem::default();

        println!("ゴーレム　（HP:{}　防御力：{}）", golem.hp, golem.defense);
        println!("HP：{}", golem.hp);
        print!("今回の攻撃の値を入力してください＞");
        std::io::stdout().flush()?;

        let damage = read_user_input::<i32>()?;

        let damage = if damage - golem.defense > 0 {
            damage - golem.defense
        } else {
            0
        };

        println!("ダメージは{}です。", damage);
        golem.hp -= damage;
        println!("残りのHPは{}です。", golem.hp);
        Ok(())
    }
}
