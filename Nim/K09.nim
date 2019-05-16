import algorithm
import math
import os
from strutils import parseInt
import IExecutable

type K09* = ref object of IExecutable

method question1*(this: K09) =
    var ages: array[0..2, int]
    for p in ages.pairs:
        stdout.write p.key + 1, "人目の年齢を入力＞"
        stdout.flushFile
        ages[p.key] = parseInt(readLine(stdin))
    
    for i in 1..25:
        stdout.write "-"
    echo ""

    var average: float
    for p in ages.pairs:
        echo p.key + 1, "人目：", p.val, "歳"
        average += p.val.toFloat
    
    echo "平均年齢：", math.round(average / 3.0, 1), "歳"
    

method question2*(this: K09) =
    var numbers = [8, 3, 12, 7, 9]
    stdout.write "元々の配列："
    for num in numbers:
        stdout.write num, " "
    echo ""

    stdout.write "逆順での表示："
    reverse(numbers)
    for num in numbers:
        stdout.write num, " "
    stdout.flushFile


method question3*(this: K09) =
    var student_scores = [
        [52, 71, 61, 47],
        [6, 84, 81, 20],
        [73, 98, 94, 95]
      ]
    echo "\t|\t科目A\t科目B\t科目C\t科目D"
    for i in 1..45:
        stdout.write "-"
    echo ""
    
    for student in student_scores.pairs:
        stdout.write "学生", student.key + 1, "\t|\t"
        for score in student.val:
            stdout.write score, "\t"
        echo ""

method question4*(this: K09) =
    var student_scores = [
        [52, 71, 61, 47],
        [6, 84, 81, 20],
        [73, 98, 94, 95]
    ]
    var total = 0
    var average: array[0..3, float] = [0.0, 0.0, 0.0, 0.0]
    echo "\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点"
    for i in 1..65:
        stdout.write "-"
    echo ""

    for student in student_scores.pairs:
        stdout.write "学生", student.key + 1, "\t|\t"
        for score in student.val.pairs:
            stdout.write score.val, "\t"
            total += score.val
            average[score.key] += score.val.toFloat
        stdout.write "|\t", total
        total = 0
        echo ""
    stdout.write "平均点\t|\t"
    for score in average:
        stdout.write round(score / 3.0, 1), "\t"
    echo "|"

method question5*(this: K09) {.base.} =
    var numbers: array[0..99, int]
    var count = 0
    for num in numbers.pairs:
        stdout.write num.key + 1, "件目の入力："
        stdout.flushFile
        numbers[num.key] = parseInt(readLine(stdin))
        if numbers[num.key] < 0:
            break
        count += 1
    
    echo "----並び替え後----"

    var sortedNumbers = numbers[..(count - 1)]
    sort(sortedNumbers, system.cmp)
    for num in sortedNumbers:
        echo num

method execute*(this: K09, num: int) =
    case num
    of 1:
        this.question1
    of 2:
        this.question2
    of 3:
        this.question3
    of 4:
        this.question4
    of 5:
        this.question5
    else:
        discard