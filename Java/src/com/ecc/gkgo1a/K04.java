package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;

public class K04 extends IExecutable {

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

            if (age < 3 || age >= 70)
            {
                System.out.println("入場料金無料です。");
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

    @Override
    public void Question2()
    {
        try
        {
            System.out.print("性別を選択してください。（０：男性　１：女性）＞");
            Scanner in = new Scanner(System.in);
            int gender = in.nextInt();

            switch (gender)
            {
                case 0:
                    System.out.println("あら、格好良いですね。");
                    break;
                case 1:
                    System.out.println("あら、モデルさんみたいですね。");
                    break;
                default:
                    System.out.println("そんな選択肢はありません。");
                    break;
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

    @Override
    public void Question4()
    {
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
