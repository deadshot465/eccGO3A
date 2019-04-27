package com.ecc.gkgo1a;

public class K01_3 implements IExecutable {

    @Override
    public void Execute()
    {
        System.out.println("整数：" + 12345);
        System.out.println("実数：" + 123.456789);
        System.out.println("文字：" + 'X');
        System.out.println("文字列：" + "ABCdef");
    }
}
