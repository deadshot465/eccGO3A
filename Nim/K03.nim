import os
import random
import times
from strutils import parseInt
import IExecutable

type K03* = ref object of IExecutable

method question1*(this: K03) =
    stdout.write "年齢を入力してください。＞"
    stdout.flushFile
    var age = parseInt(readLine(stdin))
    if age < 20:
        echo "未成年なので購入できません。"

method question2*(this: K03) =
    stdout.write "身長を入力してください。＞"
    stdout.flushFile
    var height = parseInt(readLine(stdin)).toFloat
    height /= 100.0
    stdout.write "体重を入力してください。＞"
    stdout.flushFile
    var weight = parseInt(readLine(stdin)).toFloat
    var standard = height * height * 22.0
    echo "あなたの標準体重は", standard, "です。"

    if weight > standard and (weight - standard) / standard * 100.0 > 14.0:
        echo "太り気味です。"
    elif weight < standard and (weight - standard) / standard * 100.0 < -14.0:
        echo "痩せ気味です。"
    else:
        echo "普通ですね。"

method question3*(this: K03) =
    randomize(getTime().toWinTime)
    var number = rand(99)
    echo "０から９９の範囲の数値が決定されました。"
    stdout.write "決められた数値を予想し、この数値よりも大きな値を入力してください＞"
    stdout.flushFile
    var guess = parseInt(readLine(stdin))
    echo "決められた数値は", number, "です。"

    if guess > number:
        echo "正解です。"
    else:
        echo "不正解です。"

method question4*(this: K03) =
    randomize(getTime().toWinTime)
    var number = rand(99)
    echo "０から９９の範囲の数値が決定されました。"
    stdout.write "決められた数値を予想し、この数値よりも大きな値を入力してください＞"
    stdout.flushFile
    var guess = parseInt(readLine(stdin))
    echo "決められた数値は", number, "です。"

    if guess < 0 or guess > 100:
        echo "反則です！"
    elif guess > number and guess - number <= 10:
        echo "大正解です！"
    elif guess < number and guess - number >= -10:
        echo "惜しい！"
    elif guess == number:
        echo "お見事！"
    else:
        if guess > number:
            echo "正解です。"
        else:
            echo "不正解です。"