package com.ecc.gkgo1a;

import java.util.Scanner;

public class K02_3 implements IExecutable {

    @Override
    public void Execute() {

        try
        {
            System.out.print("一つ目の商品の値段は？");
            Scanner in = new Scanner(System.in);
            int priceA = in.nextInt();
            System.out.print("個数は？");
            int amountA = in.nextInt();
            System.out.print("二つ目の商品の値段は？");
            int priceB = in.nextInt();
            System.out.print("個数は？");
            int amountB = in.nextInt();

            System.out.println(String.format("お支払いは税込み￥%dです", (int)((priceA * amountA + priceB * amountB) * 1.08f)));

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
