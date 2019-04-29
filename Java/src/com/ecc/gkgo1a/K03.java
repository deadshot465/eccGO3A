package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K03 extends IExecutable {

    @Override
    public void Execute(int num)
    {
        super.Execute(num);
    }

    @Override
    public void Question1()
    {
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

    @Override
    public void Question2()
    {
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

    @Override
    public void Question3()
    {
        try
        {
            Random randomNumber = new Random();
            int n = randomNumber.nextInt(100);
            System.out.println("０から９９の範囲の数値が決定されました。");
            System.out.print("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
            Scanner in = new Scanner(System.in);
            int guess = in.nextInt();
            System.out.println("決められた数値は" + n + "です。");

            System.out.println(guess > n ? "正解です。" : "不正解です。");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Question4()
    {
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
            else if (guess == n)
            {
                System.out.println("お見事！");
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
