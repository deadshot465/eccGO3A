package com.ecc.gkgo1a;

import java.util.Scanner;

public class K04_3 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            System.out.print("年齢を入力してください。＞");
            Scanner in = new Scanner(System.in);
            int age = in.nextInt();

            if (age < 3 || age >= 70)
            {
                System.out.println("入場料金無料です。");
            }
            else if (age >= 3 && age <= 15)
            {
                System.out.println("子供料金で半額です。");
            }
            else if (age >= 60 && age < 70)
            {
                System.out.println("シニア割引で一割引きです。");
            }
            else
            {
                System.out.println("通常料金です。");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
