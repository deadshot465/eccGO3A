use crate::questions::k07::AgeTier::{Free, Half, Invalid, Normal, TenPercentOff};
use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use std::io::Write;

pub struct K07 {}

enum AgeTier {
    Invalid(&'static str),
    Free(&'static str),
    Half(&'static str),
    TenPercentOff(&'static str),
    Normal(&'static str),
}

impl K07 {
    fn show_text(&self) {
        println!("Hello World!");
        println!("ようこそ");
        println!("Rust言語の世界へ！");
    }

    fn get_max_value(&self, value1: i32, value2: i32, value3: i32) -> i32 {
        let temp = if value1 >= value2 { value1 } else { value2 };

        let temp = if temp >= value3 { temp } else { value3 };

        temp
    }

    fn get_age_tier(&self, age: i32) -> AgeTier {
        match age {
            x if x <= 0 => Invalid("不適切な値が入力されました。"),
            x if x < 3 || age >= 70 => Free("入場料金無料です。"),
            x if x >= 3 && age <= 15 => Half("子供料金で半額です。"),
            x if x >= 60 && age < 70 => TenPercentOff("シニア割引で一割引きです。"),
            _ => Normal("通常料金です。"),
        }
    }
}

impl Executable for K07 {
    fn question_1(&self) -> anyhow::Result<()> {
        let mut choice = 1;
        while choice != 0 {
            print!("メッセージを表示しますか？（０：終了する　１：表示する）＞");
            std::io::stdout().flush()?;
            choice = read_user_input::<i32>()?;
            if choice == 1 {
                self.show_text();
            }
        }
        println!("終了します。");
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        let mut numbers: Vec<i32> = Vec::new();
        for i in 1..4 {
            print!("{}つ目の値を入力してください。＞", i);
            std::io::stdout().flush()?;
            numbers.push(read_user_input::<i32>()?)
        }

        let max_value = self.get_max_value(numbers[0], numbers[1], numbers[2]);
        println!(
            "{}つの中で最大値は{}です。",
            numbers.len() as i32,
            max_value
        );
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        print!("年齢を入力して下さい。＞");
        std::io::stdout().flush()?;
        let age = read_user_input::<i32>()?;

        let msg = match self.get_age_tier(age) {
            Invalid(s) => s,
            Free(s) => s,
            Half(s) => s,
            TenPercentOff(s) => s,
            Normal(s) => s,
        };
        println!("{}", msg);
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        Ok(())
    }
}
