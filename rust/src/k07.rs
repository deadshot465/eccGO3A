use crate::Executable;
use crate::read_user_input::read_user_input;
use std::io::Write;

pub struct K07 {}

impl K07 {
    pub fn new() -> K07 {
        K07 {}
    }

    fn show_text(&self) {
        println!("Hello World!");
        println!("ようこそ");
        println!("Rust言語の世界へ！");
    }

    fn get_max_value(&self, value1: i32, value2: i32, value3: i32) -> i32 {
        let mut temp = if value1 >= value2 {
            value1
        } else { value2 };
        temp = if temp >= value3 {
            temp
        } else {
            value3
        };
        temp
    }

    fn get_type(&self, age: i32) -> i32 {
        match age {
            x if x <= 0 => 0,
            x if x < 3 || age >= 70 => 1,
            x if x >= 3 && age <= 15 => 2,
            x if x >= 60 && age < 70 => 3,
            _ => 4
        }
    }
}

impl Executable for K07 {
    fn question_1(&self) {
        let mut choice = 1;
        while choice != 0 {
            print!("メッセージを表示しますか？（０：終了する　１：表示する）＞");
            std::io::stdout().flush().unwrap();
            let mut input_string = String::new();
            choice = match read_user_input(&mut input_string) {
                Ok(x) => x,
                Err(e) => {
                    println!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            };
            if choice == 1 {
                self.show_text();
            }
        }
        println!("終了します。");
    }

    fn question_2(&self) {
        let mut numbers: Vec<i32> = Vec::new();
        for i in 1..4 {
            print!("{}つ目の値を入力してください。＞", i);
            std::io::stdout().flush().unwrap();
            let mut input_string: String = String::new();
            numbers.push(match read_user_input(&mut input_string) {
                Ok(x) => x,
                Err(e) => {
                    println!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            })
        }

        let max_value = self.get_max_value(numbers[0], numbers[1], numbers[2]);
        println!("{}つの中で最大値は{}です。", numbers.len() as i32, max_value);
    }

    fn question_3(&self) {
        let no: i32;
        print!("年齢を入力して下さい。＞");
        std::io::stdout().flush().unwrap();
        let mut age = String::new();
        let age = match read_user_input(&mut age) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        no = self.get_type(age);
        match no {
            0 => println!("不適切な値が入力されました。"),
            1 => println!("入場料金無料です。"),
            2 => println!("子供料金で半額です。"),
            3 => println!("シニア割引で一割引きです。"),
            _ => println!("通常料金です。")
        }
    }

    fn question_4(&self) {
        return;
    }
}