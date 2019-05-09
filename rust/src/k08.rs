use crate::Executable;
use crate::k08_1sub::get_max_value;
use crate::k08_1sub::get_min_value;
use crate::k08_2sub::attack_golem;
use crate::read_user_input::read_user_input;
use std::io::Write;
use rand::Rng;

pub struct K08 {}

impl K08 {
    pub fn new() -> K08 {
        K08 {}
    }
}

impl Executable for K08 {
    fn question_1(&self) {
        let mut numbers: Vec<i32> = Vec::new();
        for i in 1..4 {
            print!("{}つ目の値を入力してください。＞", i);
            std::io::stdout().flush().unwrap();
            let mut input = String::new();
            numbers.push(match read_user_input(&mut input) {
                Ok(x) => x,
                Err(e) => {
                    println!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            });
        }

        println!("どちらを調べますか？");
        print!("（０：最大値　１：最小値）＞");
        std::io::stdout().flush().unwrap();
        let mut choice = String::new();
        let choice = match read_user_input(&mut choice) {
            Ok(x) => x,
            Err(e) => {
                println!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        match choice {
            0 => {
                println!("{}の中で最大値は{}です。", numbers.len() as i32,
                         get_max_value(numbers[0], numbers[1], numbers[2]));
            },
            1 => {
                println!("{}の中で最小値は{}です。", numbers.len() as i32,
                         get_min_value(numbers[0], numbers[1], numbers[2]));
            }
            _ => ()
        }
    }

    fn question_2(&self) {
        println!("冒険が今始まる！");
        let mut player_hp = 100 + rand::thread_rng().gen_range(0, 101);
        let mut continue_game = 1;

        while continue_game != 0 {
            if player_hp == 0 {
                return;
            }
            println!("あなたのHP：{}", player_hp);
            print!("奥に進みますか？（１：奥に進む　０．帰る）＞");
            std::io::stdout().flush().unwrap();
            let mut input_string = String::new();
            continue_game = match read_user_input(&mut input_string) {
                Ok(x) => x,
                Err(e) => {
                    println!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            };

            if continue_game == 1 {
                let golem_lv = rand::thread_rng().gen_range(0, 5);
                attack_golem(golem_lv, &mut player_hp);
            }
        }
        println!("リレ〇ト！");
    }

    fn question_3(&self) {
        return
    }

    fn question_4(&self) {
        return
    }
}