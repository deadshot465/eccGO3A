package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static void showSelections(int chapter)
    {
        for (int i = 1; i < 5; i++)
        {
            System.out.println(String.format("\t%d) K0%d_%d", i, chapter, i));
        }
        if (chapter == 9) {
            System.out.println(String.format("\t5) K0%d_5", chapter));
        }
    }

    public static void main(String[] args) {

        int choice, choice2;

        Vector<IExecutable> executables = new Vector<>();
        executables.add(new K01());
        executables.add(new K02());
        executables.add(new K03());
        executables.add(new K04());
        executables.add(new K05());
        executables.add(new K06());
        executables.add(new K07());
        executables.add(new K08());
        executables.add(new K09());
        executables.add(new K10());
        executables.add(new FileControl());

        System.out.println("実行したいプログラムを選択してください。");
        for (int i = 1; i <= executables.size(); i++)
        {
            System.out.println(String.format("%d) K0%d", i, i));
        }

        try {
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            if (choice < 1 || choice > executables.size())
            {
                throw new Exception("無効の選択です。");
            }

            showSelections(choice);

            choice2 = in.nextInt();
            executables.get(choice - 1).Execute(choice2);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}