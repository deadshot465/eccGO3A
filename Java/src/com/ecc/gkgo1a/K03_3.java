package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K03_3 implements IExecutable {

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

            System.out.println(guess > n ? "正解です。" : "不正解です。");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
