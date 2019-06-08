import 'dart:io';
import 'package:Dart/Executable.dart';
import 'package:Dart/FileControl.dart';
import 'package:Dart/K01.dart';
import 'package:Dart/K02.dart';
import 'package:Dart/K03.dart';
import 'package:Dart/K04.dart';
import 'package:Dart/K05.dart';
import 'package:Dart/K06.dart';
import 'package:Dart/K07.dart';
import 'package:Dart/K08.dart';
import 'package:Dart/K09.dart';
import 'package:Dart/K10.dart';
import 'package:Dart/K11.dart';
import 'package:Dart/K12.dart';
import 'package:Dart/Kex.dart';

void ShowSelections(int chapter) {
  if (chapter < 10) {
    for (int i = 1; i <= 4; i++) {
      print("\t$i) K0${chapter}_$i");
    }
    if (chapter == 9) {
      print("\t5) K0${chapter}_5");
    }
  }
  else {
    int addedNumber = chapter >= 12 ? chapter + 3 : chapter;
    for (int i = 1; i <= 4; i++) {
      print("\t$i) K${addedNumber}_$i");
    }
  }
}

main(List<String> arguments) {
  List<Executable> executables =
  <Executable>[K01(), K02(), K03(), K04(), K05(), K06(),
  K07(), K08(), K09(), K10(), K11(), K12(), FileControl()];

  print("実行したいプログラムを選択してください。");
  for (int i = 1; i <= executables.length; i++) {
    if (i < 10) {
      print("$i) K0$i");
    } else {
      int addedNumber = i >= 12 ? i + 3 : i;
      print("$i) K$addedNumber");
    }
  }
  print('100) Kex');
  
  int choice = int.parse(stdin.readLineSync());
  if (choice == 100) {
    Kex kex = Kex();
    kex.Execute();
    return;
  }
  ShowSelections(choice);
  int choice2 = int.parse(stdin.readLineSync());
  executables[choice - 1].Execute(choice2);
}
