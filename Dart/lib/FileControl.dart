import 'dart:io';
import 'package:Dart/Executable.dart';

class FileControl extends Executable {
  @override
  void Question1() {
    File file = File('output.txt');
    file.writeAsString("This is the string to output.");
  }

  @override
  void Question2() {
    // TODO: implement Question2
  }

  @override
  void Question3() {
    // TODO: implement Question3
  }

  @override
  void Question4() {
    // TODO: implement Question4
  }

}