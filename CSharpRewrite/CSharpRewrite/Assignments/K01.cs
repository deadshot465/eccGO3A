using CSharpRewrite.Shared;

namespace CSharpRewrite.Assignments;

public class K01 : IQuestion
{
    public void Question1()
    {
        Console.WriteLine("Hello World! ようこそC#言語の世界へ！");
    }

    public void Question2()
    {
        Console.WriteLine("Hello World!");
        Console.WriteLine("ようこそ");
        Console.WriteLine("C#言語の世界へ！");
    }

    public void Question3()
    {
        Console.WriteLine("整数：" + 12345);
        Console.WriteLine("実数：" + 123.456789);
        Console.WriteLine("文字：" + 'X');
        Console.WriteLine("文字列：" + "ABCdef");
    }

    public void Question4()
    {
        Console.WriteLine("              ##");
        Console.WriteLine("             #  #");
        Console.WriteLine("             #  #");
        Console.WriteLine("            #    #");
        Console.WriteLine("           #      #");
        Console.WriteLine("         ##        ##");
        Console.WriteLine("       ##            ##");
        Console.WriteLine("    ###                ###");
        Console.WriteLine(" ###       ##    ##       ###");
        Console.WriteLine("##        #  #  #  #        ##");
        Console.WriteLine("##         ##    ##         ##");
        Console.WriteLine(" ##     #            #     ##");
        Console.WriteLine("  ###     ##########     ###");
        Console.WriteLine("     ###              ###");
        Console.WriteLine("        ##############");
    }
}