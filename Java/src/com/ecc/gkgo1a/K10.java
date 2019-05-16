package com.ecc.gkgo1a;

import java.util.Scanner;

public class K10 extends IExecutable {
    @Override
    public void Question1() {
        System.out.print("文字列の入力＞");
        Scanner reader = new Scanner(System.in);
        String inputString = reader.nextLine();
        System.out.println(String.format("入力された文字列の文字数：%d", inputString.length()));
    }

    @Override
    public void Question2() {
        String str = "STRINGcopy";
        System.out.println(String.format("コピーしたい文字列：%s", str));
        String copyStr = str;
        System.out.println(String.format("コピー後の文字列：%s", copyStr));
    }

    @Override
    public void Question3() {
        String[] str = {
                "abcdef", "GHIJKL", "13579"
        };

        StringBuilder sb = new StringBuilder();
        System.out.println("連結したい３つの文字列：");
        for (var s :
                str) {
            System.out.println(s);
            sb.append(s);
        }

        System.out.println(String.format("連結した文字列：%s", sb.toString()));
    }

    @Override
    public void Question4() {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.";
        int count = 0;
        int _count = 0;
        System.out.println(String.format("文字列：%s\n", inputString));
        System.out.println("文字頻度");
        for (var s :
                alphabets.toCharArray()) {
            for (var _s :
                    inputString.toCharArray()) {
                if (s == _s) {
                    count++;
                }
            }
            System.out.print(String.format("%c: %d\t", s, count));
            count = 0;
            _count++;
            if (_count % 4 == 0) {
                System.out.println();
            }
        }
    }
}
