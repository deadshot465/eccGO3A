import IExecutable
import re
import strutils

type K11* = ref object of IExecutable

var MAX_PEOPLE = 5

method question1*(this: K11) =
    var ages: seq[int]
    for i in 1..MAX_PEOPLE:
        stdout.write i, "人目の年齢を入力して下さい："
        stdout.flushFile
        ages.add(parseInt(readLine(stdin)))
    
    var average = 0.0
    for i in ages.items:
        average += i.toFloat
    average /= ages.len.toFloat
    echo ages.len, "人の平均年齢は", average, "です。"

method question2*(this: K11) =
    stdout.write "1つ目の文字列を入力して下さい。＞"
    stdout.flushFile
    var str1 = readLine(stdin)
    stdout.write "2つ目の文字列を入力して下さい。＞"
    stdout.flushFile
    var str2 = readLine(stdin)
    str1.add(str2)
    echo str1, "の文字数は", str1.len, "です。"

method question3*(this: K11) =
    var chr: char
    stdout.write "文字を入力して下さい。＞"
    stdout.flushFile
    chr = readChar(stdin)
    var applied = false

    if chr.isDigit:
        echo "この文字は数字です。"
        applied = true
    if chr.isUpperAscii:
        echo "この文字は英大文字です。"
        applied = true
    if chr.isLowerAscii:
        echo "この文字は英小文字です。"
        applied = true
    
    var rx = re"^[A-Fa-f0-9]{6}$"
    if match($chr, rx):
        echo "この文字は16進数として使える文字です。"
        applied = true
    
    rx = re"^(\'[.,!?:;\'""\-()]\')*$"
    if match($chr, rx):
        echo "この文字は区切り文字です。"
        applied = true

    if not applied:
        echo "この文字はよくわからない文字です。"

method question4*(this: K11) =
    var alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var input_string = "I am a STUDENT. I am good at GAME PROGRAMMING."
    var count = 0
    var count2 = 0

    echo "文字列：", input_string
    echo "\n文字頻度"
    for s in alphabets:
        for s2 in input_string:
            if s == s2.toUpperAscii:
                count += 1
        stdout.write s, ": ", count, "\t"
        stdout.flushFile
        count = 0
        count2 += 1
        if count2 mod 4 == 0:
            echo ""