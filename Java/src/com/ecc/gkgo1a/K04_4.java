package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K04_4 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            System.out.println("＊＊＊おみくじプログラム＊＊＊");
            System.out.print("おみくじを引きますか　（はい：１　いいえ：０）　＞");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            if (choice >= 1)
            {
                Random randomNumber = new Random();
                int oracle = randomNumber.nextInt(5);
                switch (oracle)
                {
                    case 0:
                        System.out.println("大吉　とってもいいことがありそう！！");
                        break;
                    case 1:
                        System.out.println("中吉　きっといいことあるんじゃないかな");
                        break;
                    case 2:
                        System.out.println("小吉　少しぐらいはいいことあるかもね");
                        break;
                    case 3:
                        System.out.println("凶　今日はおとなしくておいた方がいいかも");
                        break;
                    case 4:
                        System.out.println("大凶　これじゃやばくない？早く家に帰った方がいいかも");
                        break;
                    default:
                        break;
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
