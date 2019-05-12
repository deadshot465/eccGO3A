import os
import random
import times
from strutils import parseInt
import Golem, IExecutable, K08_1sub, K08_2sub

type K08* = ref object of IExecutable

method question1*(this: K08) =
    var numbers: seq[int]
    for i in 1..3:
        stdout.write i, "つ目の値を入力してください。＞"
        stdout.flushFile
        numbers.add(parseInt(readLine(stdin)))
    
    echo "どちらを調べますか？"
    stdout.write "（０：最大値　１：最小値）＞"
    stdout.flushFile
    var choice = parseInt(readLine(stdin))
    case choice
    of 0:
        echo numbers.len, "の中で最大値は", get_max_value(numbers[0], numbers[1], numbers[2]), "です。"
    of 1:
        echo numbers.len, "の中で最小値は", get_min_value(numbers[0], numbers[1], numbers[2]), "です。"
    else:
        return

method question2*(this: K08) =
    echo "冒険が今始まる！"
    randomize(getTime().toWinTime)
    var playerHp = 200 + rand(100)
    var continueGame = 1
    while continueGame != 0:
        if playerHp == 0:
            return
        echo "あなたのHP：", playerHp
        stdout.write "奥に進みますか？（１：奥に進む　０．帰る）＞"
        stdout.flushFile
        continueGame = parseInt(readLine(stdin))
        if continueGame == 1:
            var golemLv = rand(4)
            attack_golem(golemLv, playerHp)
    echo "リレ〇ト！"


method question3*(this: K08) =
    return
        
    

method question4*(this: K08) =
    return