package com.ecc.gkgo1a;

import java.util.Arrays;
import java.util.Scanner;

public class K09 extends IExecutable {
    @Override
    public void Execute(int num) {
        switch (num) {
            case 1:
                Question1();
                break;
            case 2:
                Question2();
                break;
            case 3:
                Question3();
                break;
            case 4:
                Question4();
                break;
            case 5:
                Question5();
                break;
        }
    }

    @Override
    public void Question1() {
        try
        {
            int[] ages = new int[3];
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < 3; i++)
            {
                System.out.print(String.format("%d人目の年齢を入力＞", i + 1));
                ages[i] = in.nextInt();
            }

            for (int i = 0; i < 21; i++)
            {
                System.out.print("-");
            }
            System.out.println();

            for (int i = 0; i < 3; i++)
            {
                System.out.println(String.format("%d人目：%d歳。", i + 1, ages[i]));
            }

            var _average = Arrays.stream(ages).average();
            double average = 0.0f;
            if (_average.isPresent())
            {
                average = _average.getAsDouble();
            }
            System.out.println(String.format("平均年齢：%.1f歳。", average));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void Question2() {
        int[] numbers = {8, 3, 12, 7, 9};
        System.out.print("元々の配列：");
        for (var num :
                numbers) {
            System.out.print(String.format("%d ", num));
        }
        System.out.println();

        System.out.print("逆順での表示：");

        for (int i = numbers.length - 1; i >= 0; i--)
        {
            System.out.print(String.format("%d ", numbers[i]));
        }
    }

    @Override
    public void Question3() {
        int[][] studentScores =
                {
                        { 52, 71, 61, 47 },
                        { 6, 84, 81, 20 },
                        { 73, 98, 94, 95 }
                };

        System.out.println("\t\t|\t科目A\t科目B\t科目C\t科目D");
        for (int i = 0; i < 46; ++i)
        {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < studentScores.length; i++)
        {
            System.out.print(String.format("学生%d\t|\t", i + 1));
            for (int j = 0; j < studentScores[i].length; j++)
            {
                System.out.print(String.format("%d\t\t", studentScores[i][j]));
            }

            System.out.println();
        }
    }

    @Override
    public void Question4() {
        int[][] studentScores =
                {
                        { 52, 71, 61, 47 },
                        { 6, 84, 81, 20 },
                        { 73, 98, 94, 95 }
                };
        int total = 0;
        double[] average = new double[4];

        System.out.println("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点");
        for (int i = 0; i < 66; ++i)
        {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < studentScores.length; i++)
        {
            System.out.print(String.format("学生%d\t|\t", i + 1));
            for (int j = 0; j < studentScores[i].length; j++)
            {
                System.out.print(String.format("%d\t\t", studentScores[i][j]));
                total += studentScores[i][j];
                average[j] += studentScores[i][j];
            }
            System.out.print(String.format("|\t%d", total));
            total = 0;
            System.out.println();
        }
        System.out.print("平均点\t|\t");
        for (var num :
                average) {
            System.out.print(String.format("%.1f\t", num / 3.0));
        }
        System.out.println("|");
    }

    public void Question5() {
        try
        {
            int count = 0;
            int[] numbers = new int[100];
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < numbers.length; i++)
            {
                System.out.print(String.format("%d件目の入力：", i + 1));
                numbers[i] = in.nextInt();
                if (numbers[i] < 0)
                {
                    break;
                }
                count++;
            }

            System.out.println("----並び替え後----");

            var sorted = Arrays.stream(numbers).limit(count).sorted();

            for (var num :
                    sorted.toArray()) {
                System.out.println(num);
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
