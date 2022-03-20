package io.github.deadshot465;

import io.github.deadshot465.assignments.K01;
import io.github.deadshot465.assignments.K02;
import io.github.deadshot465.assignments.K03;
import io.github.deadshot465.assignments.K04;
import io.github.deadshot465.assignments.musicians.BandSupervisor;
import io.github.deadshot465.shared.Question;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var questions = new Question[] { new K01(), new K02(), new K03(), new K04() };
        System.out.println("実行したいプログラムを選択してください。");
        for (var i = 0; i < questions.length; i++) {
            if (i < 10) {
                System.out.printf("%d) K0%d\n", i, i);
            } else {
                var addedNumber = i >= 12 ? i + 3 : i;
                System.out.printf("%d) K%d\n", i, addedNumber);
            }
        }

        System.out.println("100) Kex_1");
        System.out.println("101) Kex_2");
        System.out.println("102) Sort");
        System.out.println("103) Band Supervisor");
        final var scanner = new Scanner(System.in);
        final var choice = scanner.nextInt();

        switch (choice) {
            case 100, 101, 102:
                break;
            case 103:
                try {
                    BandSupervisor.startBand(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default: {
                showSelection(choice);
                final var choice2 = scanner.nextInt();
                questions[choice - 1].execute(choice2);
            }
        }
    }

    private static void showSelection(int chapter) {
        for (var i = 1; i <= 4; i++) {
            if (chapter < 10) {
                System.out.printf("\t%d) K0%d_%d\n", i, chapter, i);
            } else {
                System.out.printf("\t%d) K%d_%d\n", i, chapter, i);
            }
        }

        if (chapter == 9) {
            System.out.printf("\t5) K0%d_5\n", chapter);
        }
    }
}
