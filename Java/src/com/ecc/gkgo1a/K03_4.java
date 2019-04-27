package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K03_4 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            Random randomNumber = new Random();
            int n = randomNumber.nextInt(100);
            System.out.println("０から９９の範囲の数値が決定されました。");
            System.out.print("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
            Scanner in = new Scanner(System.in);
            int guess = in.nextInt();
            System.out.println("決められた数値は" + n + "です。");

            if (guess > 100 || guess < 0)
            {
                System.out.println("反則です！");
            }
            else if (guess > n && (guess - n) <= 10)
            {
                System.out.println("大正解！");
            }
            else if (guess < n && (guess - n) >= -10)
            {
                System.out.println("惜しい！");
            }
            else
            {
                System.out.println(guess > n ? "正解です。" : "不正解です。");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
