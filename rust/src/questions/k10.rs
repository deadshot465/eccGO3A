use crate::Executable;
use std::io::Write;

pub struct K10 {}
impl K10 {
    pub fn new() -> K10 {
        K10 {}
    }
}

impl Executable for K10 {
    fn question_1(&self) {
        print!("文字列の入力＞");
        std::io::stdout().flush().unwrap();
        let mut input_string = String::new();
        let _ = std::io::stdin().read_line(&mut input_string).unwrap_or_else(|e| {
            panic!(format!("エラーが発生しました：{}", e.to_string()));
        });
        println!("入力された文字列の文字数：{}", input_string.trim().len());
    }

    fn question_2(&self) {
        let input_str = "STRINGcopy";
        println!("コピーしたい文字列：{}", input_str);
        let copy_str = input_str;
        println!("コピー後の文字列：{}", copy_str);
    }

    fn question_3(&self) {
        let input_str: [&str; 3] = [
            "abcdef", "GHIJKL", "13579"
        ];
        let mut str_combined = String::new();
        println!("連結したい３つの文字列：");
        for s in input_str.iter() {
            println!("{}", s);
            str_combined += s;
        }
        println!("連結した文字列：{}", str_combined);
    }

    fn question_4(&self) {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        let input_string = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.";
        let mut count = 0;
        let mut _count = 0;

        println!("文字列：{}\n", input_string);
        println!("文字頻度");
        for s in alphabets.chars() {
            for _s in input_string.chars() {
                if s == _s {
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