package com.ecc.gkgo1a;

import java.util.Scanner;

public class Main {

    private static void showSelections(int chapter)
    {
        for (int i = 1; i < 5; i++)
        {
            if (chapter < 10)
            {
                System.out.println(String.format("\t%d) K0%d_%d", i, chapter, i));
                if (chapter == 9) {
                    System.out.println(String.format("\t5) K0%d_5", chapter));
                }
            }
            else
            {
                System.out.println(String.format("\t%d) K%d_%d", i, chapter, i));
            }
        }
    }

    public static void main(String[] args) {

        int choice, choice2;
        IExecutable[] executables = {
                new K01(), new K02(), new K03(), new K04(), new K05(),
                new K06(), new K07(), new K08(), new K09(), new K10(),
                new K11(), new FileControl()
        };

        System.out.println("実行したいプログラムを選択してください。");
        for (int i = 1; i <= executables.length; i++)
        {
            if (i < 10)
                System.out.println(String.format("%d) K0%d", i, i));
            else
                System.out.println(String.format("%d) K%d", i, i));
        }
        System.out.println("100) Kex");

        try {
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            if (choice == 100) {
                Kex.Execute();
                return;
            }

            if (choice < 1 || choice > executables.length)
            {
                throw new Exception("無効の選択です。");
            }

            showSelections(choice);

            choice2 = in.nextInt();
            executables[choice - 1].Execute(choice2);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}