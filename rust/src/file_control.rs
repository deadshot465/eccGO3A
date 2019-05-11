use crate::Executable;
use std::fs::File;
use std::io::Write;

pub struct FileControl {}

impl FileControl {
    pub fn new() -> FileControl {
        FileControl {}
    }
}

impl Executable for FileControl {
    fn question_1(&self) {
        let mut fs = match File::open("output.txt") {
            Ok(x) => x,
            Err(_) => {
                match File::create("output.txt") {
                    Ok(x) => x,
                    Err(e) => {
                        eprintln!("An error occurred: {}", e.to_string());
                        return;
                    }
                }
            }
        };

        let output_string = "This is the string to write.\n";
        let result = fs.write(output_string.as_bytes());
        match result {
            Ok(_) => println!("Completed."),
            Err(e) => {
                eprintln!("An error occurred: {}", e.to_string());
                return;
            }
        };
    }

    fn question_2(&self) {
        unimplemented!()
    }

    fn question_3(&self) {
        unimplemented!()
    }

    fn question_4(&self) {
        unimplemented!()
    }
}