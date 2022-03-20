package io.github.deadshot465.assignments;

import io.github.deadshot465.shared.Golem;
import io.github.deadshot465.shared.Question;

import java.util.Scanner;

public class K02 implements Question {
    @Override
    public void question1() {
        final var seisuu = 3;
        final var jissuu = 2.6f;
        final var moji = 'A';
        System.out.println("変数seisuuの値は" + seisuu);
        System.out.println("変数jissuuの値は" + jissuu);
        System.out.println("変数mojiの値は" + moji);
    }

    @Override
    public void question2() {
        System.out.print("一つ目の整数は？");
        final var in = new Scanner(System.in);
        final var a = in.nextInt();
        System.out.print("二つ目の整数は？");
        final var b = in.nextInt();

        System.out.printf("%d÷%d=%d...%d\n", a, b, a / b, a % b);
    }

    @Override
    public void question3() {
        System.out.print("一つ目の商品の値段は？");
        final var in = new Scanner(System.in);
        final var priceA = in.nextInt();
        System.out.print("個数は？");
        final var amountA = in.nextInt();
        System.out.print("二つ目の商品の値段は？");
        final var priceB = in.nextInt();
        System.out.print("個数は？");
        final var amountB = in.nextInt();

        System.out.printf("お支払いは税込み￥%dです\n", (int)((priceA * amountA + priceB * amountB) * 1.1f));
    }

    @Override
    public void question4() {
        var golem = new Golem(300, 80, 50);
        System.out.printf("ゴーレム　（HP:%d　防御力：%d）\n", golem.hp(), golem.defense());
        System.out.println("HP：" + golem.hp());
        System.out.print("今回の攻撃の値を入力してください＞");
        final var in = new Scanner(System.in);
        var atk = in.nextInt();
        atk = Math.max(atk - golem.defense(), 0);
        System.out.println("ダメージは" + atk + "です");

        golem = new Golem(golem.hp() - atk, golem.defense(), golem.attack());
        System.out.println("残りのHPは" + golem.hp() + "です");
    }
}
