import 'dart:io';
import 'dart:math';
import 'package:Dart/Executable.dart';

class Person {
  String Name;
  int BirthYear;
  double Height;
  double Weight;
}

class Staff {
  String Name;
  String Gender;
  int Age;

  Staff(String name, String gender, int age) {
    Name = name;
    Gender = gender;
    Age = age;
  }
}

class Position {
  int X;
  int Y;
  double Distance;

  Position({int x, int y, double distance = 0.0}) {
    X = x;
    Y = y;
    Distance = distance;
  }
}

class K12 extends Executable {
  @override
  void Question1() {
    Person person = Person();
    stdout.write('名前を入力してください＞');
    person.Name = stdin.readLineSync();
    stdout.write('生年（西暦）を入力してください＞');
    person.BirthYear = int.parse(stdin.readLineSync());
    stdout.write('身長を入力してください＞');
    person.Height = double.parse(stdin.readLineSync());
    stdout.write('体重を入力してください＞');
    person.Weight = double.parse(stdin.readLineSync());
    
    print('プロファイル');
    print('名前：${person.Name}');
    print('生年：${person.BirthYear}');
    print('身長：${person.Height.toStringAsFixed(1)}');
    print('体重：${person.Weight.toStringAsFixed(1)}');
  }

  @override
  void Question2() {
    List<Staff> staffs = [
      Staff('神木隆之介', 'M', 23),
      Staff('上白石萌音', 'F', 18),
      Staff('長澤まさみ', 'F', 28),
    ];

    print("名前\t\t性別\t年齢");

    for (int i = 1; i <= 35; i++) {
      stdout.write('-');
    }
    print('');

    for (var staff in staffs) {
      print('${staff.Name}\t${staff.Gender}\t${staff.Age}歳');
    }
  }

  double GetDistance(Position playerPos, Position enemyPos) {
    int diffX = playerPos.X - enemyPos.X;
    int diffY = playerPos.Y - enemyPos.Y;
    return sqrt(diffX * diffX + diffY * diffY);
  }

  @override
  void Question3() {
    Random random = Random();
    var getRandomNumber = () => random.nextInt(101) - 50;
    Position playerPos = Position(x: getRandomNumber(), y: getRandomNumber());
    List<Position> enemyPos = [];
    for (int i = 0; i < 5; i++) {
      Position pos = Position(
        x: getRandomNumber(),
        y: getRandomNumber()
      );
      pos.Distance = GetDistance(playerPos, pos);
      enemyPos.add(pos);
    }
    
    print('プレーヤーの座標：x= ${playerPos.X}\t\ty= ${playerPos.Y}\n');
    for (int i = 0; i < enemyPos.length; i++) {
      print('敵キャラの座標0%d：x= ${enemyPos[i].X.toString().padLeft(5)}\t\t'
          'y= ${enemyPos[i].Y.toString().padLeft(5)}\t\t距離=${enemyPos[i].Distance.toStringAsFixed(2).padLeft(5)}');
    }
  }

  @override
  void Question4() {
    Random random = Random();
    var getRandomNumber = () => random.nextInt(101) - 50;
    Position playerPos = Position(x: getRandomNumber(), y: getRandomNumber());
    List<Position> enemyPos = [];
    for (int i = 0; i < 5; i++) {
      Position pos = Position(
          x: getRandomNumber(),
          y: getRandomNumber()
      );
      pos.Distance = GetDistance(playerPos, pos);
      enemyPos.add(pos);
    }

    print('プレーヤーの座標：x= ${playerPos.X}\t\ty= ${playerPos.Y}\n');
    for (int i = 0; i < enemyPos.length; i++) {
      print('敵キャラの座標0%d：x= ${enemyPos[i].X.toString().padLeft(5)}\t\t'
          'y= ${enemyPos[i].Y.toString().padLeft(5)}\t\t距離=${enemyPos[i].Distance.toStringAsFixed(2).padLeft(5)}');
    }

    print('\n並び替え後');
    enemyPos.sort((a, b) => a.Distance.compareTo(b.Distance));
    for (int i = 0; i < enemyPos.length; i++) {
      print('敵キャラの座標0%d：x= ${enemyPos[i].X.toString().padLeft(5)}\t\t'
          'y= ${enemyPos[i].Y.toString().padLeft(5)}\t\t距離=${enemyPos[i].Distance.toStringAsFixed(2).padLeft(5)}');
    }
  }

}