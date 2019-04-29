package com.ecc.gkgo1a;

public class K01 extends IExecutable
{
    @Override
    public void Execute(int num)
    {
        super.Execute(num);
    }

    @Override
    public void Question1()
    {
        System.out.println("Hello World! ようこそJava言語の世界へ！");
    }

    @Override
    public void Question2()
    {
        System.out.println("Hello World!");
        System.out.println("ようこそ");
        System.out.println("Java言語の世界へ！");
    }

    @Override
    public void Question3()
    {
        System.out.println("整数：" + 12345);
        System.out.println("実数：" + 123.456789);
        System.out.println("文字：" + 'X');
        System.out.println("文字列：" + "ABCdef");
    }

    @Override
    public void Question4()
    {
        System.out.println("              ##");
        System.out.println("             #  #");
        System.out.println("             #  #");
        System.out.println("            #    #");
        System.out.println("           #      #");
        System.out.println("         ##        ##");
        System.out.println("       ##            ##");
        System.out.println("    ###                ###");
        System.out.println(" ###       ##    ##       ###");
        System.out.println("##        #  #  #  #        ##");
        System.out.println("##         ##    ##         ##");
        System.out.println(" ##     #            #     ##");
        System.out.println("  ###     ##########     ###");
        System.out.println("     ###              ###");
        System.out.println("        ##############");
    }
}
