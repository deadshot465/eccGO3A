package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K11 extends IExecutable {

    @Override
    public void Question1() {
        Vector<Integer> ages = new Vector<>();

        Scanner in = new Scanner(System.in);
        int MAX_PEOPLE = 5;
        for (int i = 0; i < MAX_PEOPLE; i++)
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

        System.out.println(String.format("%d人の平均年齢は%.1fです。", ages.size(), average));
    }

    @Override
    public void Question2() {
        System.out.print("1つ目の文字列を入力して下さい。＞");
        Scanner reader = new Scanner(System.in);
        String str1 = reader.nextLine();
        System.out.print("2つ目の文字列を入力して下さい。＞");
        String str2 = reader.nextLine();
        StringBuilder sb = new StringBuilder(str1);
        sb.append(str2);
        System.out.println(String.format("%sの文字数は%dです。", sb.toString(), sb.toString().length()));
    }

    @Override
    public void Question3() {
        char chr;
        System.out.print("文字を入力して下さい。＞");
        Scanner reader = new Scanner(System.in);
        chr = reader.nextLine().charAt(0);
        boolean applied = false;

        if (Character.isDigit(chr))
        {
            System.out.println("この文字は数字です。");
            applied = true;
        }
        if (Character.isUpperCase(chr))
        {
            System.out.println("この文字は英大文字です。");
            applied = true;
        }
        if (Character.isLowerCase(chr))
        {
            System.out.println("この文字は英小文字です。");
            applied = true;
        }
        Pattern pattern = Pattern.compile("^[A-Fa-f0-9]$");
        Matcher matcher = pattern.matcher(Character.toString(chr));
        if (matcher.matches())
        {
            System.out.println("この文字は16進数として使える文字です。");
            applied = true;
        }

        pattern = Pattern.compile("^(.|,|!|\\?|:|;|\"|'|\\|-|\\(|\\)])$");
        matcher = pattern.matcher(Character.toString(chr));
        if (matcher.matches())
        {
            System.out.println("この文字は区切り文字です。");
            applied = true;
        }

        if (!applied)
            System.out.println("この文字はよくわからない文字です。");
    }

    @Override
    public void Question4() {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String inputString = "I am a STUDENT. I am good at GAME PROGRAMMING.";
        int count = 0;
        int _count = 0;
        System.out.println(String.format("文字列：%s\n", inputString));
        System.out.println("文字頻度");
        for (var s :
                alphabets.toCharArray()) {
            for (var _s :
                    inputString.toCharArray()) {
                if (s == Character.toUpperCase(_s)) {
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
