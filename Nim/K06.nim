import os
from strutils import parseInt
import Golem, IExecutable

type K06* = ref object of IExecutable

method question1*(this: K06) =
    var ages: seq[int]
    for i in 1..5:
        stdout.write i, "人目の年齢を入力して下さい："
        ages.add(parseInt(readLine(stdin)))

    var average = 0.0
    for i in ages.items:
        average += i.toFloat
    average /= ages.len.toFloat
    echo ages.len, "人の平均年齢は", average, "です。"

method question2*(this: K06) =
    for i in 1..9:
        for j in 1..i:
            stdout.write "*"
            stdout.flushFile
        echo ""
    echo ""

    for i in countdown(9, 1):
        for j in 1..i:
            stdout.write "*"
            stdout.flushFile
        echo ""
    echo ""

    for i in countdown(9, 1):
        for j in countup(1, i - 1):
            stdout.write " "
            stdout.flushFile
        
        for k in countdown(9, i):
            stdout.write "*"
            stdout.flushFile
        echo ""


method question3*(this: K06) =
    var total = 370
    var count = 0
    for i in countup(0, total div 100):
        for j in countup(0, total div 50):
            for k in countup(0, total div 10):
                if 100 * i + 50 * j + 10 * k == total:
                    echo "10円の硬貨", k, "枚 50円の硬貨", j, "枚 100円の硬貨", i, "枚"
                    inc(count)
    echo "\n以上", count, "通りを発見しました。"                
        
    

method question4*(this: K06) =
    stdout.write "\t|\t"
    stdout.flushFile

    for i in 1..9:
        stdout.write i, "\t"
        stdout.flushFile
    echo ""

    for i in 1..85:
        stdout.write "-"
        stdout.flushFile
    echo ""

    for i in 1..9:
        stdout.write i, "\t|\t"
        stdout.flushFile
        for j in 1..9:
            stdout.write i * j, "\t"
        echo ""