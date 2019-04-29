package com.ecc.gkgo1a;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class K06 extends IExecutable {

    @Override
    public void Execute(int num)
    {
        super.Execute(num);
    }

    @Override
    public void Question1()
    {
        Vector<Integer> ages = new Vector<>();

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
        {
            System.out.print((i + 1) + "人目の年齢を入力して下さい：");
            ages.add(in.nextInt());
        }

        var _average = ages.stream().mapToDouble(x -> x).average();
        double average = 0;
        if (_average.isPresent())
        {
            average = _average.getAsDouble();
        }

        System.out.println(String.format("%d人の平均年齢は%fです。", ages.size(), average));
    }

    @Override
    public void Question2()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < i + 1; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 9; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 9; i > 0; i--)
        {
            for (int j = 0; j < i - 1; j++)
            {
                System.out.print(" ");
            }

            for (int k = 9; k > i - 1; k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void Question3()
    {
        int total = 370;
        int count = 0;

        for (int i = 0; i <= total / 100; i++)
        {
            for (int j = 0; j <= total / 50; j++)
            {
                for (int k = 0; k <= total / 10; k++)
                {
                    if (100 * i + 50 * j + 10 * k == total)
                    {
                        System.out.println(String
                                .format("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚", k, j, i));
                        count++;
                    }
                }
            }
        }

        System.out.println("\n以上" + count + "通りを発見しました。");
    }

    @Override
    public void Question4()
    {
        System.out.print("\t|\t");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < 85; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 1; i < 10; i++) {
            System.out.print(i + "\t|\t");
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}
