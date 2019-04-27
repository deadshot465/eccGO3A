package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static void showSelections(int chapter)
    {
        int j = 1;

        for (int i = 4 * chapter - 3; i < 4 * chapter + 1; i++)
        {
            System.out.println(String.format("\t%d) K0%d_%d", i, chapter, j));
            j++;
        }
    }

    public static void main(String[] args) {

        int choice, choice2;

        Vector<IExecutable> executables = new Vector<>();
        executables.add(new K01_1());
        executables.add(new K01_2());
        executables.add(new K01_3());
        executables.add(new K01_4());
        executables.add(new K02_1());
        executables.add(new K02_2());
        executables.add(new K02_3());
        executables.add(new K02_4());
        executables.add(new K03_1());
        executables.add(new K03_2());
        executables.add(new K03_3());
        executables.add(new K03_4());
        executables.add(new K04_1());
        executables.add(new K04_2());
        executables.add(new K04_3());
        executables.add(new K04_4());
        executables.add(new K05_1());
        executables.add(new K05_2());
        executables.add(new K05_3());
        executables.add(new K05_4());
        executables.add(new K06_1());
        executables.add(new K06_2());
        executables.add(new K06_3());
        executables.add(new K06_4());

        System.out.println("実行したいプログラムを選択してください。");
        for (int i = 1; i < 7; i++)
        {
            System.out.println(String.format("%d) K0%d", i, i));
        }

        try {
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            if (choice < 1 || choice > 6)
            {
                throw new Exception("無効の選択です。");
            }

            showSelections(choice);

            choice2 = in.nextInt();
            executables.get(choice2 - 1).Execute();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}