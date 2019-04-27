package com.ecc.gkgo1a;

public class K05_1 implements IExecutable {

    @Override
    public void Execute() {
        float salary = 19.0f;
        int age = 22;

        while (salary < 50.0f)
        {
            salary *= 1.035f;
            age++;
        }

        System.out.print(age + "歳で月給" + salary + "万円");
    }

}
