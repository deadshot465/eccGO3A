package io.github.deadshot465.assignments;

import io.github.deadshot465.shared.Question;

import java.util.Random;
import java.util.Scanner;

public class K04 implements Question {
    @Override
    public void question1() {
        System.out.print("年齢を入力してください。＞");
        final var in = new Scanner(System.in);
        final var age = in.nextInt();

        System.out.println(age < 3 || age >= 70 ? "入場料金無料です。" : "通常料金です。");
    }

    @Override
    public void question2() {
        System.out.print("性別を選択してください。（０：男性　１：女性）＞");
        final var in = new Scanner(System.in);
        final var gender = in.nextInt();
        System.out.println(switch (gender) {
            case 0 -> "あら、格好良いですね。";
            case 1 -> "あら、モデルさんみたいですね。";
            default -> "そんな選択肢はありません。";
        });
    }

    @Override
    public void question3() {
        System.out.print("年齢を入力してください。＞");
        final var in = new Scanner(System.in);
        final var age = in.nextInt();

        if (age < 3 || age >= 70) {
            System.out.println("入場料金無料です。");
        }
        else if (age <= 15) {
            System.out.println("子供料金で半額です。");
        }
        else if (age >= 60) {
            System.out.println("シニア割引で一割引きです。");
        }
        else {
            System.out.println("通常料金です。");
        }
    }

    @Override
    public void question4() {
        System.out.println("＊＊＊おみくじプログラム＊＊＊");
        System.out.print("おみくじを引きますか　（はい：１　いいえ：０）　＞");
        final var in = new Scanner(System.in);
        final var choice = in.nextInt();

        if (choice == 0) {
            return;
        }

        final var rng = new Random();
        final var oracle = rng.nextInt(0, 5);
        System.out.println(switch (oracle) {
            case 0 -> "大吉　とってもいいことがありそう！！";
            case 1 -> "中吉　きっといいことあるんじゃないかな";
            case 2 -> "小吉　少しぐらいはいいことあるかもね";
            case 3 -> "凶　今日はおとなしくておいた方がいいかも";
            case 4 -> "大凶　これじゃやばくない？早く家に帰った方がいいかも";
            default -> "";
        });
    }
}
