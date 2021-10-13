use crate::questions::{
    k01::K01, k02::K02, k03::K03, k04::K04, k05::K05, k06::K06, k07::K07, k08::K08,
};
use crate::shared::traits::executable::Executable;
use crate::shared::utility::read_user_input;

mod questions;
mod shared;

fn show_selection(chapter: u32) {
    if chapter < 10 {
        for i in 1..5 {
            println!("\t{}) K0{}_{}", i, chapter, i);
        }
        if chapter == 9 {
            println!("\t5) K0{}_5", chapter);
        }
    } else {
        let added_number = if chapter >= 12 { chapter + 3 } else { chapter };
        for i in 1..5 {
            println!("\t{}) K{}_{}", i, added_number, i);
        }
    }
}

fn main() -> anyhow::Result<()> {
    let executables: Vec<Box<dyn Executable>> = vec![
        Box::new(K01 {}),
        Box::new(K02 {}),
        Box::new(K03 {}),
        Box::new(K04 {}),
        Box::new(K05 {}),
        Box::new(K06 {}),
        Box::new(K07 {}),
        Box::new(K08 {}),
    ];
    println!("実行したいプログラムを選択してください。");
    for n in 1..executables.len() + 1 {
        if n < 10 {
            println!("{}) K0{}", n, n);
        } else {
            let added_number = if n >= 12 { n + 3 } else { n };
            println!("{}) K{}", n, added_number);
        }
    }
    println!("100) Kex");
    println!("101) Kex_2");
    println!("102) Sort");

    let choice = read_user_input::<u32>()?;
    match choice {
        100 | 101 | 102 => Ok(()),
        _ => {
            show_selection(choice);
            let choice2 = read_user_input::<u32>()?;

            match executables.get(choice as usize - 1) {
                Some(x) => x.execute(choice2),
                None => Ok(()),
            }
        }
    }

    /*if choice == 100 {
        Kex::execute();
    } else if choice == 101 {
        Kex_2::execute();
    } else if choice == 102 {
        let mut sort = Sort::new();
        sort.execute();
    }*/
}
