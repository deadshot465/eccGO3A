use crate::executable::Executable;
use std::io::{self, Write, stdin};

pub struct K06 {}
impl K06 {
    pub fn new() -> K06 {
        K06 {}
    }
}

impl Executable for K06 {
    fn question_1(&self) {
        let mut ages: Vec<f32> = vec!{};

        for i in 0..5 {
            print!("{}人目の年齢を入力して下さい：", i + 1);
            std::io::stdout().flush();
            let mut reader = String::new();
            std::io::stdin().read_line(&mut reader).expect("入力失敗！");
            ages.push(reader.trim().parse::<f32>().expect("入力失敗！"));
        }

        let average: f32 = ages.iter().sum::<f32>() / ages.len() as f32;
        println!("{}人の平均年齢は{}です。", ages.len(), average);
    }

    fn question_2(&self) {
        for i in 0..9 {
            for j in 0..i + 1 {
                print!("*");
                std::io::stdout().flush();
            }
            println!();
        }
        println!();

        for i in (0..9).rev() {
            for j in 0..i + 1 {
                print!("*");
                std::io::stdout().flush();
            }
            println!();
        }
        println!();

        for i in (0..9).rev() {
            for j in 0..i {
                print!(" ");
                std::io::stdout().flush();
            }

            for k in i..9 {
                print!("*");
                std::io::stdout().flush();
            }
            println!();
        }
    }

    fn question_3(&self) {
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
    }

    fn question_4(&self) {
        print!("\t|\t");
        std::io::stdout().flush();
        for i in 1..10 {
            print!("{}\t", i);
            std::io::stdout().flush();
        }
        println!();

        for i in 0..75 {
            print!("-");
            std::io::stdout().flush();
        }
        println!();

        for i in 1..10 {
            print!("{}\t|\t", i);
            std::io::stdout().flush();
            for j in 1..10 {
                print!("{}\t", i * j);
                std::io::stdout().flush();
            }
            println!();
        }
    }
}