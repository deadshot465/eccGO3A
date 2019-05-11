extern crate Rust;
use Rust::{Executable, K01, K02, K03, K04, K05, K06, K07, K08, FileControl};
use std::io;

fn show_selection(chapter: usize)
{
    for n in 1..5 {
        println!("\t{}) K0{}_{}", n, chapter, n);
    }

}

fn main() {
    let executables : Vec<Box<Executable>> = vec![
        Box::new(K01::new()),
        Box::new(K02::new()),
        Box::new(K03::new()),
        Box::new(K04::new()),
        Box::new(K05::new()),
        Box::new(K06::new()),
        Box::new(K07::new()),
        Box::new(K08::new()),
        Box::new(FileControl::new())
    ];
    println!("実行したいプログラムを選択してください。");
    for n in 1..executables.len() + 1 {
        println!("{}) K0{}", n, n);
    }

    let mut choice = String::new();
    io::stdin().read_line(&mut choice).expect("入力失敗！");
    let choice = choice.trim().parse::<usize>().expect("入力失敗！");
    show_selection(choice);
    let mut choice2 = String::new();
    io::stdin().read_line(&mut choice2).expect("入力失敗！");
    let choice2 = choice2.trim().parse::<u32>().expect("入力失敗！");

    let test: Option<&Box<Executable>> = executables.get(choice - 1);
    match test {
        Some(x) => x.execute(choice2),
        None => ()
    }
}
