extern crate Rust;
use Rust::K01;
use Rust::K02;
use Rust::K03;
use Rust::K04;
use Rust::K05;
use Rust::K06;
use Rust::Executable;
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
        Box::new(K06::new())
    ];
    println!("実行したいプログラムを選択してください。");
    for n in 1..7 {
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
