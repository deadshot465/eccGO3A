use crate::shared::traits::executable::Executable;

pub struct K01 {}

impl Executable for K01
{
    fn question_1(&self) -> anyhow::Result<()>
    {
        println!("Hello World!　ようこそRust言語の世界へ！");
        Ok(())
    }

    fn question_2(&self) -> anyhow::Result<()>
    {
        println!("Hello World!");
        println!("ようこそ");
        println!("Rust言語の世界へ！");
        Ok(())
    }

    fn question_3(&self) -> anyhow::Result<()>
    {
        println!("整数：{}", 12345);
        println!("実数：{}", 123.456789);
        println!("文字：{}", 'X');
        println!("文字列：{}", "ABCdef");
        Ok(())
    }

    fn question_4(&self) -> anyhow::Result<()>
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
        Ok(())
    }
}