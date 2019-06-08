package com.ecc.gkgo1a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

class Person {
    String Name;
    int BirthYear;
    float Height;
    float Weight;
}

class Staff {
    String Name;
    char Gender;
    int Age;

    Staff(String name, char gender, int age) {
        Name = name;
        Gender = gender;
        Age = age;
    }
}

class Position implements Comparable<Position> {
    int X;
    int Y;
    double Distance;

    Position(int x, int y) {
        X = x;
        Y = y;
        Distance = 0.0;
    }

    Position() { }

    @Override
    public int compareTo(Position o) {
        return Double.compare(this.Distance, o.Distance);
    }
}

public class K12 extends IExecutable {
    @Override
    public void Question1() {
        Person person = new Person();
        System.out.print("名前を入力してください＞");
        Scanner reader = new Scanner(System.in);
        person.Name = reader.nextLine();
        System.out.print("生年（西暦）を入力してください＞");
        person.BirthYear = reader.nextInt();
        System.out.print("身長を入力してください＞");
        person.Height = reader.nextFloat();
        System.out.print("体重を入力してください＞");
        person.Weight = reader.nextFloat();

        System.out.println("プロファイル：");
        System.out.printf("名前：%s\n", person.Name);
        System.out.printf("生年：%d\n", person.BirthYear);
        System.out.printf("身長：%.1f\n", person.Height);
        System.out.printf("体重：%.1f\n", person.Weight);
    }

    @Override
    public void Question2() {
        Staff[] staffs = {
                new Staff("神木隆之介", 'M', 23),
                new Staff("上白石萌音", 'F', 18),
                new Staff("長澤まさみ", 'F', 28),
                };

        System.out.println("名前\t\t性別\t年齢");
        for (int i = 0; i <= 35; i++) {
            System.out.print('-');
        }
        System.out.println();

        for (var staff:
             staffs) {
            System.out.printf("%s\t%c\t%d歳\n", staff.Name, staff.Gender, staff.Age);
        }

    }

    @Override
    public void Question3() {
        Random random = new Random();
        Supplier<Integer> getRandomNumber = () -> random.nextInt(101) - 50;
        Position playerPos = new Position(getRandomNumber.get(), getRandomNumber.get());
        Position[] enemyPos = new Position[5];
        for (int i = 0; i < enemyPos.length; i++) {
            Position pos = new Position();
            pos.X = getRandomNumber.get();
            pos.Y = getRandomNumber.get();
            pos.Distance = GetDistance(playerPos, pos);
            enemyPos[i] = pos;
        }

        System.out.printf("プレーヤーの座標：x= %5.2f\t\ty= %5.2f\n\n", (float)playerPos.X, (float)playerPos.Y);
        for (int i = 0; i < enemyPos.length; i++) {
            System.out.printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
                    i, (float)enemyPos[i].X, (float)enemyPos[i].Y, enemyPos[i].Distance);
        }
    }

    @Override
    public void Question4() {
        Random random = new Random();
        Supplier<Integer> getRandomNumber = () -> random.nextInt(101) - 50;
        Position playerPos = new Position(getRandomNumber.get(), getRandomNumber.get());
        Position[] enemyPos = new Position[5];
        for (int i = 0; i < enemyPos.length; i++) {
            Position pos = new Position();
            pos.X = getRandomNumber.get();
            pos.Y = getRandomNumber.get();
            pos.Distance = GetDistance(playerPos, pos);
            enemyPos[i] = pos;
        }

        System.out.printf("プレーヤーの座標：x= %5.2f\t\ty= %5.2f\n\n", (float)playerPos.X, (float)playerPos.Y);
        for (int i = 0; i < enemyPos.length; i++) {
            System.out.printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
                    i, (float)enemyPos[i].X, (float)enemyPos[i].Y, enemyPos[i].Distance);
        }

        System.out.println("\n並び替え後");

        var sortedList = Arrays.stream(enemyPos).sorted(Comparator.naturalOrder()).toArray(Position[]::new);
        for (int i = 0; i < sortedList.length; i++) {
            System.out.printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
                    i, (float)sortedList[i].X, (float)sortedList[i].Y, sortedList[i].Distance);
        }
    }

    private double GetDistance(Position playerPos, Position enemyPos) {
        int diffX = playerPos.X - enemyPos.X;
        int diffY = playerPos.Y - enemyPos.Y;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }
}
