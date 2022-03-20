package io.github.deadshot465.assignments;

import io.github.deadshot465.shared.Question;

public class K01 implements Question {
    @Override
    public void question1() {
        System.out.println("Hello World! ようこそJava言語の世界へ！");
    }

    @Override
    public void question2() {
        System.out.println("Hello World!");
        System.out.println("ようこそ");
        System.out.println("Java言語の世界へ！");
    }

    @Override
    public void question3() {
        System.out.println("整数：" + 12345);
        System.out.println("実数：" + 123.456789);
        System.out.println("文字：" + 'X');
        System.out.println("文字列：" + "ABCdef");
    }

    @Override
    public void question4() {
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
