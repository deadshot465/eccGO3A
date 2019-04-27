package com.ecc.gkgo1a;

public class K06_2 implements IExecutable {

    @Override
    public void Execute() {

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < i + 1; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 9; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 9; i > 0; i--)
        {
            for (int j = 0; j < i - 1; j++)
            {
                System.out.print(" ");
            }

            for (int k = 9; k > i - 1; k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

    }
}
