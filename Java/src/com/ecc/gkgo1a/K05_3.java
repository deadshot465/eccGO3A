package com.ecc.gkgo1a;

import java.util.Scanner;

public class K05_3 implements IExecutable {

    @Override
    public void Execute() {
        int choice;

        do
        {
            System.out.println("起きろ～");
            System.out.print("1．起きた　2．あと5分…　3．Zzzz…\t入力：");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if (choice == 1)
            {
                System.out.println("よし、学校へ行こう！");
            }

        } while (true);
    }

}
