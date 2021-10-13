use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use rand::prelude::*;
use std::io::Write;

pub struct K04 {}

impl Executable for K04 {
    fn question_1(&self) -> anyhow::Result<()> {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush()?;

        let age = read_user_input::<u32>()?;
        if age < 3 || age >= 70 {
            println!("入場料金無料です。");
        } else {
            println!("通常料金です。");
        }
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        print!("性別を選択してください。（０：男性　１：女性）＞");
        std::io::stdout().flush()?;

        match read_user_input::<u32>()? {
            0 => println!("あら、格好良いですね。"),
            1 => println!("あら、モデルさんみたいですね。"),
            _ => println!("そんな選択肢はありません。"),
        }
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush()?;

        let age = read_user_input::<u32>()?;
        if age < 3 || age >= 70 {
            println!("入場料金無料です。");
        } else if age >= 3 && age <= 15 {
            println!("子供料金で半額です。");
        } else if age >= 60 && age < 70 {
            println!("シニア割引で一割引きです。");
        } else {
            println!("通常料金です。");
        }
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        println!("＊＊＊おみくじプログラム＊＊＊");
        print!("おみくじを引きますか　（はい：１　いいえ：０）　＞");
        std::io::stdout().flush()?;

        let choice = read_user_input::<i32>()?;

        if choice == 0 {
            return Ok(());
        }

        let oracle = rand::thread_rng().gen_range(0..5);

        println!(
            "{}",
            match oracle {
                0 => "大吉　とってもいいことがありそう！！",
                1 => "中吉　きっといいことあるんじゃないかな",
                2 => "小吉　少しぐらいはいいことあるかもね",
                3 => "凶　今日はおとなしくておいた方がいいかも",
                4 => "大凶　これじゃやばくない？早く家に帰った方がいいかも",
                _ => "",
            }
        );

        Ok(())
    }
}
