package com.ecc.gkgo1a;

import java.util.Scanner;

public class K03_1 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            System.out.print("年齢を入力してください。＞");
            Scanner in = new Scanner(System.in);
            int age = in.nextInt();
            if (age < 20)
            {
                System.out.println("未成年なので購入できません。");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
