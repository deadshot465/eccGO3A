use crate::executable::Executable;

pub struct K01 {}
impl K01
{
    pub fn new() -> K01
    {
        K01 {}
    }
}

impl Executable for K01
{
    fn question_1(&self)
    {
        println!("Hello World!　ようこそRust言語の世界へ！");
    }

    fn question_2(&self)
    {
        println!("Hello World!");
        println!("ようこそ");
        println!("Rust言語の世界へ！");
    }

    fn question_3(&self)
    {
        println!("整数：{}", 12345);
        println!("実数：{}", 123.456789);
        println!("文字：{}", 'X');
        println!("文字列：{}", "ABCdef");
    }

    fn question_4(&self)
    {
        println!("              ##");
        println!("             #  #");
        println!("             #  #");
        println!("            #    #");
        println!("           #      #");
        println!("         ##        ##");
        println!("       ##            ##");
        println!("    ###                ###");
        println!(" ###       ##    ##       ###");
        println!("##        #  #  #  #        ##");
        println!("##         ##    ##         ##");
        println!(" ##     #            #     ##");
        println!("  ###     ##########     ###");
        println!("     ###              ###");
        println!("        ##############");
    }
}