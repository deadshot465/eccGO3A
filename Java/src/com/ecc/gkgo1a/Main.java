package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;

public class Main {

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
        System.out.println("1) K01");
        System.out.println("2) K02");
        System.out.println("3) K03");
        System.out.println("4) K04");
        System.out.println("5) K05");
        System.out.println("6) K06");

        try {
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("\t1) K01_1");
                    System.out.println("\t2) K01_2");
                    System.out.println("\t3) K01_3");
                    System.out.println("\t4) K01_4");

                    break;
                case 2:
                    System.out.println("\t5) K02_1");
                    System.out.println("\t6) K02_2");
                    System.out.println("\t7) K02_3");
                    System.out.println("\t8) K02_4");

                    break;
                case 3:
                    System.out.println("\t9) K03_1");
                    System.out.println("\t10) K03_2");
                    System.out.println("\t11) K03_3");
                    System.out.println("\t12) K03_4");

                    break;
                case 4:
                    System.out.println("\t13) K04_1");
                    System.out.println("\t14) K04_2");
                    System.out.println("\t15) K04_3");
                    System.out.println("\t16) K04_4");

                    break;
                case 5:
                    System.out.println("\t17) K05_1");
                    System.out.println("\t18) K05_2");
                    System.out.println("\t19) K05_3");
                    System.out.println("\t20) K05_4");

                    break;
                case 6:
                    System.out.println("\t21) K06_1");
                    System.out.println("\t22) K06_2");
                    System.out.println("\t23) K06_3");
                    System.out.println("\t24) K06_4");

                    break;
                default:
                    break;
            }

            choice2 = in.nextInt();
            executables.get(choice2 - 1).Execute();
        }
        catch (Exception ex)
        {
            System.out.println("無効の選択です。");
            System.out.println(ex.getMessage());
        }
    }
}