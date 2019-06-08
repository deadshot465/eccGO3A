extern crate Rust;
use Rust::{Executable, K01, K02, K03, K04, K05, K06, K07, K08, K09, K10, K11, K12, Kex, FileControl};
use std::io;

fn show_selection(chapter: u32)
{
    if chapter < 10 {
        for i in 1..5 {
            println!("\t{}) K0{}_{}", i, chapter, i);
        }
        if chapter == 9 {
            println!("\t5) K0{}_5", chapter);
        }
    } else {
        let added_number = if chapter >= 12 {
            chapter + 3
        } else {
            chapter
        };
        for i in 1..5 {
            println!("\t{}) K{}_{}", i, added_number, i);
        }
    }
}

fn main() {
    let executables : Vec<Box<Executable>> = vec![
        Box::new(K01::new()), Box::new(K02::new()), Box::new(K03::new()),
        Box::new(K04::new()), Box::new(K05::new()), Box::new(K06::new()),
        Box::new(K07::new()), Box::new(K08::new()), Box::new(K09::new()),
        Box::new(K10::new()), Box::new(K11::new()), Box::new(K12::new()),
        Box::new(FileControl::new())
    ];
    println!("実行したいプログラムを選択してください。");
    for n in 1..executables.len() + 1 {
        if n < 10 { println!("{}) K0{}", n, n); }
        else {
            let added_number = if n >= 12 {
                n + 3
            } else {
                n
            };
            println!("{}) K{}", n, added_number);
        }
    }
    println!("100) Kex");

    let mut choice = String::new();
    io::stdin().read_line(&mut choice).expect("入力失敗！");
    let choice = choice.trim().parse::<u32>().expect("入力失敗！");
    if choice == 100 {
        Kex::execute();
    } else {
        show_selection(choice);
        let mut choice2 = String::new();
        io::stdin().read_line(&mut choice2).expect("入力失敗！");
        let choice2 = choice2.trim().parse::<u32>().expect("入力失敗！");

        let test: Option<&Box<Executable>> = executables.get(choice as usize - 1);
        match test {
            Some(x) => x.execute(choice2),
            None => ()
        }
    }
}
