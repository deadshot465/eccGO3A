use crate::Executable;
use crate::read_user_input::read_user_input;
use std::io::{stdin, Write};
use rand::Rng;
use std::cmp::Ordering;

pub struct K12 {}
impl K12 {
    pub fn new() -> K12 {
        K12 {}
    }
}

struct Person {
    name: String,
    birth_year: i32,
    height: f32,
    weight: f32
}

impl Person {
    pub fn new() -> Person {
        Person {
            name: String::new(),
            birth_year: 0,
            height: 0.0,
            weight: 0.0
        }
    }
}

struct Staff {
    name: String,
    gender: char,
    age: i32
}

impl Staff {
    pub fn new(name: &str, gender: char, age: i32) -> Staff {
        Staff {
            name: String::from(name),
            gender,
            age
        }
    }
}

#[derive(Copy, Clone)]
struct Position {
    x: i32,
    y: i32,
    distance: f64
}

impl Position {
    pub fn new(x: i32, y: i32, distance: f64) -> Position {
        Position {
            x,
            y,
            distance
        }
    }
}

impl K12 {
    fn get_distance(&self, player_pos: &Position, enemy_pos: &Position) -> f64 {
        let diff_x = player_pos.x - enemy_pos.x;
        let diff_y = player_pos.y - enemy_pos.y;
        let result: f64 = (diff_x * diff_x + diff_y * diff_y) as f64;
        result.sqrt()
    }
}

impl Executable for K12 {
    fn question_1(&self) {
        let mut person = Person::new();
        print!("名前を入力してください＞");
        std::io::stdout().flush().unwrap();
        let mut name = String::new();
        match stdin().read_line(&mut name) {
            Ok(x) => person.name = String::from(name.trim()),
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("生年（西暦）を入力してください＞");
        std::io::stdout().flush().unwrap();
        let mut birth_year = String::new();
        match read_user_input(&mut birth_year) {
            Ok(x) => person.birth_year = x,
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("身長を入力してください＞");
        std::io::stdout().flush().unwrap();
        let mut height = String::new();
        match stdin().read_line(&mut height) {
            Ok(x) => person.height = height.trim().parse::<f32>().unwrap(),
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        print!("体重を入力してください＞");
        std::io::stdout().flush().unwrap();
        let mut weight = String::new();
        match stdin().read_line(&mut weight) {
            Ok(x) => person.weight = weight.trim().parse::<f32>().unwrap(),
            Err(e) => {
                eprintln!("エラーが発生しました：{}", e.to_string());
                return;
            }
        };

        println!("プロファイル：");
        println!("名前：{}", person.name);
        println!("生年：{}", person.birth_year);
        println!("身長：{}", person.height);
        println!("体重：{}", person.weight);
    }

    fn question_2(&self) {
        let staffs = [
            Staff::new("神木隆之介", 'M', 23),
            Staff::new("上白石萌音", 'F', 18),
            Staff::new("長澤まさみ", 'F', 28),
        ];

        println!("名前\t\t性別\t年齢");
        for _ in 0..36 {
            print!("{}", '-');
        }
        println!();
        for staff in staffs.iter() {
            println!("{}\t{}\t{}歳", staff.name, staff.gender, staff.age);
        }
    }

    fn question_3(&self) {
        let get_random_number = || {
            rand::thread_rng().gen_range(0, 101) - 50
        };
        let player_pos = Position::new(
            get_random_number(),
            get_random_number(),
            0.0
        );
        let mut enemy_pos: Vec<Position> = Vec::new();
        for x in 0..5 {
            let mut pos = Position::new(
                get_random_number(),
                get_random_number(),
                0.0
            );
            pos.distance = self.get_distance(&player_pos, &pos);
            enemy_pos.push(pos);
        }

        println!("プレーヤーの座標：x= {}\t\ty= {}\n", player_pos.x, player_pos.y);
        for pos in enemy_pos.iter().enumerate() {
            let str = format!("敵キャラの座標0{}：x= {:5.2}\t\ty= {:5.2}\t\t距離={:5.2}",
                pos.0 as i32, pos.1.x, pos.1.y, pos.1.distance
            );
            println!("{}", str);
        }
    }

    fn question_4(&self) {
        let get_random_number = || {
            rand::thread_rng().gen_range(0, 101) - 50
        };
        let player_pos = Position::new(
            get_random_number(),
            get_random_number(),
            0.0
        );
        let mut enemy_pos: Vec<Position> = Vec::new();
        for x in 0..5 {
            let mut pos = Position::new(
                get_random_number(),
                get_random_number(),
                0.0
            );
            pos.distance = self.get_distance(&player_pos, &pos);
            enemy_pos.push(pos);
        }

        println!("プレーヤーの座標：x= {}\t\ty= {}\n", player_pos.x, player_pos.y);
        for pos in enemy_pos.iter().enumerate() {
            let str = format!("敵キャラの座標0{}：x= {:5.2}\t\ty= {:5.2}\t\t距離={:5.2}",
                              pos.0 as i32, pos.1.x, pos.1.y, pos.1.distance
            );
            println!("{}", str);
        }

        println!("\n並び替え後");
        enemy_pos.sort_by(|x, y| {
            if x.distance > y.distance {
                Ordering::Greater
            } else if x.distance < y.distance {
                Ordering::Less
            } else {
                Ordering::Equal
            }
        });

        for pos in enemy_pos.iter().enumerate() {
            let str = format!("敵キャラの座標0{}：x= {:5.2}\t\ty= {:5.2}\t\t距離={:5.2}",
                              pos.0 as i32, pos.1.x, pos.1.y, pos.1.distance
            );
            println!("{}", str);
        }
    }
}