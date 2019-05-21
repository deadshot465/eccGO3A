use crate::Executable;
use crate::read_user_input::read_user_input;
use std::io::{Write, Read};
use std::str::FromStr;

pub struct K11 {}
impl K11 {
    pub fn new() -> K11 {
        K11 {}
    }
}

impl Executable for K11 {
    fn question_1(&self) {
        let mut ages: Vec<f32> = vec!{};
        let max_people = 5;

        for i in 0..max_people {
            print!("{}人目の年齢を入力して下さい：", i + 1);
            std::io::stdout().flush().unwrap();
            let mut reader = String::new();
            let result = match read_user_input(&mut reader) {
                Ok(x) => x,
                Err(e) => {
                    eprintln!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            };
            ages.push(result as f32)
        }

        let average: f32 = ages.iter().sum::<f32>() / ages.len() as f32;
        println!("{}人の平均年齢は{}です。", ages.len(), average);
    }

    fn question_2(&self) {
        print!("1つ目の文字列を入力して下さい。＞");
        std::io::stdout().flush().unwrap();
        let mut str1 = String::new();
        let mut result = match std::io::stdin().read_line(&mut str1) {
            Ok(x) => x,
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };
        str1 = str1.trim().to_string();

        print!("2つ目の文字列を入力して下さい。＞");
        std::io::stdout().flush().unwrap();
        let mut str2 = String::new();
        result = match std::io::stdin().read_line(&mut str2) {
            Ok(x) => x,
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };
        str2 = str2.trim().to_string();

        str1 = str1 + &str2;
        println!("{}の文字数は{}です。", str1, str1.len())
    }

    fn question_3(&self) {
        print!("文字を入力して下さい。＞");
        std::io::stdout().flush().unwrap();
        let mut reader = String::new();
        let mut chr: char;
        let result = match std::io::stdin().read_line(&mut reader) {
            Ok(x) => x,
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };
        chr = reader.chars().nth(0).unwrap();
        let mut applied = false;

        if chr.is_digit(10) {
            println!("この文字は数字です。");
            applied = true;
        }
        if chr.is_uppercase() {
            println!("この文字は英大文字です。");
            applied = true;
        }
        if chr.is_lowercase() {
            println!("この文字は英小文字です。");
            applied = true;
        }
        if chr.is_digit(16) {
            println!("この文字は16進数として使える文字です。");
            applied = true;
        }
        if chr.is_ascii_punctuation() {
            println!("この文字は区切り文字です。");
            applied = true;
        }

        if !applied {
            println!("この文字はよくわからない文字です。");
        }
    }

    fn question_4(&self) {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        let input_string = "I am a STUDENT. I am good at GAME PROGRAMMING.";
        let mut count = 0;
        let mut _count = 0;

        println!("文字列：{}\n", input_string);
        println!("文字頻度");
        for s in alphabets.chars() {
            for _s in input_string.chars() {
                if s == _s.to_ascii_uppercase() {
                    count += 1;
                }
            }
            print!("{}: {}\t", s, count);
            count = 0;
            _count += 1;
            if _count % 4 == 0 {
                println!();
            }
        }
    }
}