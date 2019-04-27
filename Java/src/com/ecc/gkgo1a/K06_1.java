package com.ecc.gkgo1a;

import java.util.Scanner;
import java.util.Vector;

public class K06_1 implements IExecutable {

    @Override
    public void Execute() {

        Vector<Integer> ages = new Vector<>();

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
        {
            System.out.print((i + 1) + "人目の年齢を入力して下さい：");
            ages.add(in.nextInt());
        }

        var _average = ages.stream().mapToDouble(x -> x).average();
        double average = 0;
        if (_average.isPresent())
        {
            average = _average.getAsDouble();
        }

        System.out.println(String.format("%d人の平均年齢は%fです。", ages.size(), average));

    }
}
