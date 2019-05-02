use crate::executable::Executable;
use rand::Rng;
use std::io::Write;

pub struct K04 {}
impl K04 {
    pub fn new() -> K04 {
        K04 {}
    }
}

impl Executable for K04 {
    fn question_1(&self) {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush();

        let mut age = String::new();
        std::io::stdin().read_line(&mut age).expect("入力失敗！");
        let age = age.trim().parse::<u32>().expect("入力失敗！");
        if age < 3 || age >= 70
        {
            println!("入場料金無料です。");
        }
        else
        {
            println!("通常料金です。");
        }
    }

    fn question_2(&self) {
        print!("性別を選択してください。（０：男性　１：女性）＞");
        std::io::stdout().flush();
        let mut gender = String::new();
        std::io::stdin().read_line(&mut gender).expect("入力失敗！");
        let gender = gender.trim().parse::<i32>().expect("入力失敗！");
        match gender {
            0 => println!("あら、格好良いですね。"),
            1 => println!("あら、モデルさんみたいですね。"),
            _ => println!("そんな選択肢はありません。")
        }
    }

    fn question_3(&self) {
        print!("年齢を入力してください。＞");
        std::io::stdout().flush();

        let mut age = String::new();
        std::io::stdin().read_line(&mut age).expect("入力失敗！");
        let age = age.trim().parse::<u32>().expect("入力失敗！");
        if age < 3 || age >= 70
        {
            println!("入場料金無料です。");
        } else if age >= 3 && age <=15
        {
            println!("子供料金で半額です。");
        } else if age >= 60 && age < 70
        {
            println!("シニア割引で一割引きです。");
        }
        else
        {
            println!("通常料金です。");
        }
    }

    fn question_4(&self) {
        println!("＊＊＊おみくじプログラム＊＊＊");
        print!("おみくじを引きますか　（はい：１　いいえ：０）　＞");
        std::io::stdout().flush();
        let mut choice = String::new();
        std::io::stdin().read_line(&mut choice).expect("入力失敗！");
        let choice = choice.trim().parse::<i32>().expect("入力失敗！");

        if choice == 1
        {
            let oracle = rand::thread_rng().gen_range(0, 5);
            match oracle
                {
                    0 => println!("大吉　とってもいいことがありそう！！"),
                    1 => println!("中吉　きっといいことあるんじゃないかな"),
                    2 => println!("小吉　少しぐらいはいいことあるかもね"),
                    3 => println!("凶　今日はおとなしくておいた方がいいかも"),
                    4 => println!("大凶　これじゃやばくない？早く家に帰った方がいいかも"),
                    _ => ()
                }
        }
    }
}