package com.ecc.gkgo1a;

import java.util.Scanner;

public class K03_2 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            System.out.print("身長を入力してください。＞");
            Scanner in = new Scanner(System.in);
            double height = in.nextDouble();
            System.out.print("体重を入力してください。＞");
            double weight = in.nextDouble();
            height /= 100.0;
            double standard = height * height * 22.0;
            System.out.println("あなたの標準体重は" + standard + "です。");

            if (weight > standard && (weight - standard) / standard * 100 > 14)
            {
                System.out.println("太り気味です。");
            }
            else if (weight < standard && (weight - standard) / standard * 100 < -14)
            {
                System.out.println("痩せ気味です。");
            }
            else
            {
                System.out.println("普通ですね。");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
