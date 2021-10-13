use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;
use std::io::Write;

pub struct K06 {}

impl Executable for K06 {
    fn question_1(&self) -> anyhow::Result<()> {
        let mut ages: Vec<f32> = vec![];

        for i in 0..5 {
            print!("{}人目の年齢を入力して下さい：", i + 1);
            std::io::stdout().flush()?;
            ages.push(read_user_input::<f32>()?);
        }

        let average: f32 = ages.iter().sum::<f32>() / ages.len() as f32;
        println!("{}人の平均年齢は{}です。", ages.len(), average);
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()> {
        for i in 0..9 {
            for _ in 0..i + 1 {
                print!("*");
                std::io::stdout().flush()?;
            }
            println!();
        }
        println!();

        for i in (0..9).rev() {
            for _ in 0..i + 1 {
                print!("*");
                std::io::stdout().flush()?;
            }
            println!();
        }
        println!();

        for i in (0..9).rev() {
            for _ in 0..i {
                print!(" ");
                std::io::stdout().flush()?;
            }

            for _ in i..9 {
                print!("*");
                std::io::stdout().flush()?;
            }
            println!();
        }
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()> {
        let total = 370;
        let mut count = 0;
        for i in 0..total / 100 + 1 {
            for j in 0..total / 50 + 1 {
                for k in 0..total / 10 + 1 {
                    if 100 * i + 50 * j + 10 * k == total {
                        println!("10円の硬貨{}枚 50円の硬貨{}枚 100円の硬貨{}枚", k, j, i);
                        count += 1;
                    }
                }
            }
        }
        println!("以上{}通りを発見しました。", count);
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()> {
        print!("\t|\t");
        std::io::stdout().flush()?;
        for i in 1..10 {
            print!("{}\t", i);
            std::io::stdout().flush()?;
        }
        println!();

        for _ in 0..75 {
            print!("-");
            std::io::stdout().flush()?;
        }
        println!();

        for i in 1..10 {
            print!("{}\t|\t", i);
            std::io::stdout().flush()?;
            for j in 1..10 {
                print!("{}\t", i * j);
                std::io::stdout().flush()?;
            }
            println!();
        }

        Ok(())
    }
}
