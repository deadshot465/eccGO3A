use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use rand::prelude::*;
use std::io::Write;

mod k08_adventure;

pub struct K08 {}

impl Executable for K08 {
    fn question_1(&self) -> anyhow::Result<()> {
        let mut numbers: Vec<i32> = Vec::new();
        for i in 1..4 {
            print!("{}つ目の値を入力してください。＞", i);
            std::io::stdout().flush()?;
            numbers.push(read_user_input()?);
        }

        println!("どちらを調べますか？");
        print!("（０：最大値　１：最小値）＞");
        std::io::stdout().flush()?;
        let choice = read_user_input::<i32>()?;

        match choice {
            0 => {
                println!(
                    "{}の中で最大値は{}です。",
                    numbers.len() as i32,
                    numbers.into_iter().max().unwrap_or_default()
                );
            }
            1 => {
                println!(
                    "{}の中で最小値は{}です。",
                    numbers.len() as i32,
                    numbers.into_iter().min().unwrap_or_default()
                );
            }
            _ => (),
        }
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        println!("冒険が今始まる！");
        let player_hp = 200 + rand::thread_rng().gen_range(0..101);
        let result = k08_adventure::game_loop(player_hp)?;
        println!("{}", result);
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        Ok(())
    }
}
