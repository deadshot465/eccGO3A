use crate::Executable;
use crate::read_user_input::read_user_input;
use std::io::Write;

pub struct K09 {}

impl K09 {
    pub fn new() -> K09 {
        K09 {}
    }

    pub fn question_5(&self) {
        let mut count = 0;
        let mut numbers: [i32; 100] = [0; 100];
        for x in 0..numbers.len() {
            print!("{}件目の入力：", x + 1);
            std::io::stdout().flush().unwrap();
            let mut input_string = String::new();
            numbers[x] = match read_user_input(&mut input_string) {
                Ok(x) => x,
                Err(e) => {
                    eprintln!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            };
            if numbers[count] < 0 {
                break;
            }
            count += 1;
        }

        println!("----並び替え後----");
        let mut num_slice = &mut numbers[..count];
        num_slice.sort();

        for x in num_slice.iter() {
            println!("{}", x);
        }
    }

}

impl Executable for K09 {

    fn execute(&self, chapter: u32)
    {
        match chapter
            {
                1 => self.question_1(),
                2 => self.question_2(),
                3 => self.question_3(),
                4 => self.question_4(),
                5 => self.question_5(),
                _ => ()
            }
    }

    fn question_1(&self) {
        let mut ages: [i32; 3] = [0; 3];
        for i in 0..ages.len() {
            print!("{}人目の年齢を入力＞", i + 1);
            std::io::stdout().flush().unwrap();
            let mut input_str = String::new();
            ages[i] = match read_user_input(&mut input_str) {
                Ok(x) => x,
                Err(e) => {
                    eprintln!("エラーが発生しました：{}", e.to_string());
                    return;
                }
            }
        }

        for _ in 0..20 {
            print!("-");
        }
        println!();

        for age in ages.iter().enumerate() {
            println!("{}人目：{}歳", age.0 as i32 + 1, age.1);
        }
        let average: f32 = ages.iter().map(|x| {
            *x as f32
        }).sum::<f32>() / ages.len() as f32;
        println!("平均年齢：{:.1}", average);
    }

    fn question_2(&self) {
        let numbers: [i32; 5] = [8, 3, 12, 7, 9];
        print!("元々の配列：");
        for x in numbers.iter() {
            print!("{} ", x);
        }
        println!();

        print!("逆順での表示：");
        for x in numbers.iter().rev() {
            print!("{} ", x);
        }
        std::io::stdout().flush().unwrap();
    }

    fn question_3(&self) {
        let student_scores: [[i32; 4]; 3] = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ];

        println!("\t\t|\t科目A\t科目B\t科目C\t科目D");
        for _ in 0..45 {
            print!("-");
        }
        println!();

        for student in student_scores.iter().enumerate() {
            print!("学生{}\t|\t", student.0 as i32 + 1);
            for score in student_scores[student.0].iter() {
                print!("{}\t\t", score);
            }
            println!();
        }
    }

    fn question_4(&self) {
        let student_scores: [[i32; 4]; 3] = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ];

        let mut total: i32 = 0;
        let mut average: [f32; 4] = [0.0; 4];

        println!("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点");
        for _ in 0..65 {
            print!("-");
        }
        println!();

        for student in student_scores.iter().enumerate() {
            print!("学生{}\t|\t", student.0 as i32 + 1);
            for score in student_scores[student.0].iter().enumerate() {
                print!("{}\t\t", score.1);
                total += score.1;
                average[score.0] += *score.1 as f32;
            }
            print!("|\t{}", total);
            total = 0;
            println!();
        }
        print!("平均点\t|\t");
        for x in average.iter() {
            print!("{:.1}\t", x / 3.0);
        }
        println!("|");
    }

}