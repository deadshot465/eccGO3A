package com.ecc.gkgo1a;

public class K06_4 implements IExecutable {

    @Override
    public void Execute() {

        System.out.print("\t|\t");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < 85; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 1; i < 10; i++) {
            System.out.print(i + "\t|\t");
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();


        }
    }
}
