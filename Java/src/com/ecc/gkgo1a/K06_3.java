package com.ecc.gkgo1a;

public class K06_3 implements IExecutable {

    @Override
    public void Execute() {

        int total = 370;
        int count = 0;

        for (int i = 0; i <= total / 100; i++)
        {
            for (int j = 0; j <= total / 50; j++)
            {
                for (int k = 0; k <= total / 10; k++)
                {
                    if (100 * i + 50 * j + 10 * k == total)
                    {
                        System.out.println(String
                                .format("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚", k, j, i));
                        count++;
                    }
                }
            }
        }

        System.out.println("\n以上" + count + "通りを発見しました。");

    }
}
