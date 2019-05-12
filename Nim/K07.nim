import os
from strutils import parseInt
import Golem, IExecutable

type K07* = ref object of IExecutable

proc show_text() =
    echo "Hello World!"
    echo "ようこそ"
    echo "Nim言語の世界へ！"

proc get_max_value(v1: int, v2: int, v3: int): int =
    var temp = if v1 >= v2: v1 else: v2
    temp = if temp >= v3: temp else: v3
    return temp

proc get_type(age: int): int =
    if age <= 0:
        return 0
    elif age < 3 or age >= 70:
        return 1
    elif age >= 3 and age <= 15:
        return 2
    elif age >= 60 and age < 70:
        return 3
    else:
        return 4

method question1*(this: K07) =
    var choice = 1
    while choice != 0:
        stdout.write "メッセージを表示しますか？（０：終了する　１：表示する）＞"
        stdout.flushFile
        choice = parseInt(readLine(stdin))
        if choice == 1:
            show_text()
    echo "終了します。"

method question2*(this: K07) =
    var numbers: seq[int]
    for i in 1..3:
        stdout.write i, "つ目の値を入力してください。＞"
        stdout.flushFile
        numbers.add(parseInt(readLine(stdin)))
    echo numbers.len, "つの中で最大値は", get_max_value(numbers[0], numbers[1], numbers[2]), "です。"


method question3*(this: K07) =
    var age = 0;
    var no = 0;
    stdout.write "年齢を入力して下さい。＞"             
    stdout.flushFile
    age = parseInt(readLine(stdin))

    no = get_type(age)
    case no
    of 0:
        echo "不適切な値が入力されました。"
    of 1:
        echo "入場料金無料です。"
    of 2:
        echo "子供料金で半額です。"
    of 3:
        echo "シニア割引で１割引きです。"
    else:
        echo "通常料金です。"
        
    

method question4*(this: K07) =
    return