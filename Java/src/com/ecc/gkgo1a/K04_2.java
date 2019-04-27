package com.ecc.gkgo1a;

import java.util.Scanner;

public class K04_2 implements IExecutable {

    @Override
    public void Execute() {
        try
        {
            System.out.print("性別を選択してください。（０：男性　１：女性）＞");
            Scanner in = new Scanner(System.in);
            int gender = in.nextInt();

            switch (gender)
            {
                case 0:
                    System.out.println("あら、格好良いですね。");
                    break;
                case 1:
                    System.out.println("あら、モデルさんみたいですね。");
                    break;
                default:
                    System.out.println("そんな選択肢はありません。");
                    break;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
