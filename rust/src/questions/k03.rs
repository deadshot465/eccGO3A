use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use rand::prelude::*;
use std::io::Write;

pub struct K03 {}

impl Executable for K03 {
    fn question_1(&self) -> anyhow::Result<()> {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush()?;

        if read_user_input::<u32>()? < 20 {
            println!("未成年なので購入できません。");
        }
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        print!("身長を入力してください。＞");
        std::io::stdout().flush()?;
        let height = read_user_input::<f64>()?;
        let height = height / 100.0;

        print!("体重を入力してください。＞");
        std::io::stdout().flush()?;
        let weight = read_user_input::<f64>()?;

        let standard = height * height * 22.0;
        println!("あなたの標準体重は{}です。", standard);

        if weight > standard && (weight - standard) / standard * 100.0 > 14.0 {
            println!("太り気味です。");
        } else if weight < standard && (weight - standard) / standard * 100.0 < -14.0 {
            println!("痩せ気味です。");
        } else {
            println!("普通ですね。");
        }
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        let secret_number = rand::thread_rng().gen_range(0..100);
        println!("０から９９の範囲の数値が決定されました。");
        print!("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        std::io::stdout().flush()?;

        let guess = read_user_input::<i32>()?;

        println!("決められた数値は{}です。", secret_number);
        println!(
            "{}",
            if guess > secret_number {
                "正解です。"
            } else {
                "不正解です。"
            }
        );
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        let secret_number = rand::thread_rng().gen_range(0..100);
        println!("０から９９の範囲の数値が決定されました。");
        print!("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        std::io::stdout().flush()?;

        let guess = read_user_input::<i32>()?;

        println!("決められた数値は{}です。", secret_number);
        let result = if guess > 100 || guess < 0 {
            "反則です！"
        } else if guess > secret_number && guess - secret_number <= 10 {
            "大正解！"
        } else if guess < secret_number && guess - secret_number >= -10 {
            "惜しい！"
        } else if guess == secret_number {
            "お見事！"
        } else {
            if guess > secret_number {
                "正解です。"
            } else {
                "不正解です。"
            }
        };
        println!("{}", result);
        Ok(())
    }
}
