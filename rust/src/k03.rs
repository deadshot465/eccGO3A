use crate::executable::Executable;
use rand::Rng;
use std::io::Write;

pub struct K03 {}
impl K03 {
    pub fn new() -> K03 {
        K03 {}
    }
}

impl Executable for K03 {
    fn question_1(&self) {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush().unwrap();

        let mut age = String::new();
        std::io::stdin().read_line(&mut age).expect("入力失敗！");
        let age = age.trim().parse::<u32>().expect("入力失敗！");
        if age < 20
        {
            println!("未成年なので購入できません。");
        }
    }

    fn question_2(&self) {
        print!("身長を入力してください。＞");
        std::io::stdout().flush().unwrap();
        let mut height = String::new();
        std::io::stdin().read_line(&mut height).expect("入力失敗！");
        let mut height = height.trim().parse::<f64>().expect("入力失敗！");
        height /= 100.0;

        print!("体重を入力してください。＞");
        std::io::stdout().flush().unwrap();
        let mut weight = String::new();
        std::io::stdin().read_line(&mut weight).expect("入力失敗！");
        let weight = weight.trim().parse::<f64>().expect("入力失敗！");

        let standard = height * height * 22.0;
        println!("あなたの標準体重は{}です。", standard);

        if weight > standard && (weight - standard) / standard * 100.0 > 14.0
        {
            println!("太り気味です。");
        }
        else if weight < standard && (weight - standard) / standard * 100.0 < -14.0
        {
            println!("痩せ気味です。");
        }
        else
        {
            println!("普通ですね。");
        }
    }

    fn question_3(&self) {
        let secret_number = rand::thread_rng().gen_range(0, 100);
        println!("０から９９の範囲の数値が決定されました。");
        print!("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        std::io::stdout().flush().unwrap();

        let mut guess = String::new();
        std::io::stdin().read_line(&mut guess).expect("入力失敗！");
        let guess = guess.trim().parse::<i32>().expect("入力失敗！");

        println!("決められた数値は{}です。", secret_number);
        let result = String::from(if guess > secret_number {
            "正解です。"
        } else {
            "不正解です。"
        });
        println!("{}", result);
    }

    fn question_4(&self) {
        let secret_number = rand::thread_rng().gen_range(0, 100);
        println!("０から９９の範囲の数値が決定されました。");
        print!("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        std::io::stdout().flush().unwrap();

        let mut guess = String::new();
        std::io::stdin().read_line(&mut guess).expect("入力失敗！");
        let guess = guess.trim().parse::<i32>().expect("入力失敗！");

        println!("決められた数値は{}です。", secret_number);
        let result = String::from(if guess > 100 || guess < 0 {
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
        });
        println!("{}", result);
    }
}