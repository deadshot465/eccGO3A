package io.github.deadshot465.assignments;

import io.github.deadshot465.shared.Question;

import java.util.Random;
import java.util.Scanner;

public class K03 implements Question {
    @Override
    public void question1() {
        System.out.print("年齢を入力してください。＞");
        final var in = new Scanner(System.in);
        final var age = in.nextInt();
        if (age < 20) {
            System.out.println("未成年なので購入できません。");
        }
    }

    @Override
    public void question2() {
        System.out.print("身長を入力してください。＞");
        final var in = new Scanner(System.in);
        var height = in.nextDouble();
        System.out.print("体重を入力してください。＞");
        final var weight = in.nextDouble();
        height /= 100.0;
        final var standard = height * height * 22.0;
        System.out.println("あなたの標準体重は" + standard + "です。");

        if (weight > standard && (weight - standard) / standard * 100.0 > 14.0) {
            System.out.println("太り気味です。");
        } else if (weight < standard && (weight - standard) / standard * 100.0 < -14.0) {
            System.out.println("痩せ気味です。");
        } else {
            System.out.println("普通ですね。");
        }
    }

    @Override
    public void question3() {
        final var rng = new Random();
        final var n = rng.nextInt(0, 100);
        System.out.println("０から９９の範囲の数値が決定されました。");
        System.out.print("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        final var in = new Scanner(System.in);
        final var guess = in.nextInt();
        System.out.println("決められた数値は" + n + "です。");
        System.out.println(guess > n ? "正解です。" : "不正解です。");
    }

    @Override
    public void question4() {
        final var rng = new Random();
        final var n = rng.nextInt(0, 100);
        System.out.println("０から９９の範囲の数値が決定されました。");
        System.out.print("決められた数値を予想し、この数値よりも大きな値を入力してください＞");
        final var in = new Scanner(System.in);
        final var guess = in.nextInt();
        System.out.println("決められた数値は" + n + "です。");

        if (guess > 100 || guess < 0) {
            System.out.println("反則です！");
        }
        else if (guess > n && (guess - n) <= 10) {
            System.out.println("大正解！");
        }
        else if (guess < n && (guess - n) >= -10) {
            System.out.println("惜しい！");
        }
        else if (guess == n) {
            System.out.println("お見事！");
        }
        else {
            System.out.println(guess > n ? "正解です。" : "不正解です。");
        }
    }
}
