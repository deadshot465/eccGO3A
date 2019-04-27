package com.ecc.gkgo1a;

import java.util.Scanner;

public class K02_2 implements IExecutable {

    @Override
    public void Execute() {

        try
        {
            System.out.print("一つ目の整数は？");
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.print("二つ目の整数は？");
            int b = in.nextInt();

            System.out.println(String.format("%d÷%d=%d...%d", a, b, a / b, a % b));

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
