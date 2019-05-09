package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;

public class K07 extends IExecutable {

    private void ShowText() {
        System.out.println("Hello World!");
        System.out.println("ようこそ");
        System.out.println("Java言語の世界へ！");
    }

    private int GetMaxValue(int value1, int value2, int value3) {
        int temp = value1 >= value2 ? value1 : value2;
        temp = temp >= value3 ? temp : value3;
        return temp;
    }

    private int GetType(int age) {
        if (age <= 0)
            return 0;
        else if (age < 3 || age >= 70)
            return 1;
        else if (age >= 3 && age <= 15)
            return 2;
        else if (age >= 60 && age < 70)
            return 3;
        else
            return 4;
    }

    @Override
    public void Question1() {
        int choice;
        try {
            do {
                System.out.print("メッセージを表示しますか？（０：終了する　１：表示する）＞");
                Scanner in = new Scanner(System.in);
                choice = in.nextInt();
                if (choice == 1)
                    ShowText();
            } while (choice != 0);
            System.out.println("終了します。");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Question2() {
        Vector<Integer> numbers = new Vector<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("%dつ目の値を入力してください。＞", i + 1));
            numbers.add(in.nextInt());
        }
        System.out.println(String.format("%dつの中で最大値は%dです。", numbers.size(),
                GetMaxValue(numbers.get(0), numbers.get(1), numbers.get(2))));
    }

    @Override
    public void Question3() {
        int age, no;
        System.out.print("年齢を入力して下さい。＞");
        Scanner in = new Scanner(System.in);
        age = in.nextInt();

        no = GetType(age);
        switch (no)
        {
            case 0:
                System.out.println("不適切な値が入力されました。");
                break;
            case 1:
                System.out.println("入場料金無料です。");
                break;
            case 2:
                System.out.println("子供料金で半額です。");
                break;
            case 3:
                System.out.println("シニア割引で１割引きです。");
                break;
            default:
                System.out.println("通常料金です。");
                break;
        }
    }

    @Override
    public void Question4() {

    }
}
