import os
import random
import times
from strutils import parseInt
import IExecutable

type K04* = ref object of IExecutable

method question1*(this: K04) =
    stdout.write "年齢を入力してください。＞"
    stdout.flushFile
    var age = parseInt(readLine(stdin))
    if age < 3 or age >= 70:
        echo "入場料金無料です。"
    else:
        echo "通常料金です。"

method question2*(this: K04) =
    stdout.write "性別を選択してください。（０：男性　１：女性）＞"
    stdout.flushFile
    var gender = parseInt(readLine(stdin)).toFloat
    case gender
    of 0:
        echo "あら、格好良いですね。"
    of 1:
        echo "あら、モデルさんみたいですね。"
    else:
        echo "そんな選択肢はありません。"

method question3*(this: K04) =
    stdout.write "年齢を入力してください。＞"
    stdout.flushFile
    var age = parseInt(readLine(stdin))
    if age < 3 or age >= 70:
        echo "入場料金無料です。"
    elif age >= 3 and age <= 15:
        echo "子供料金で半額です。"
    elif age >= 60 and age < 70:
        echo "シニア割引で一割引きです。"
    else:
        echo "通常料金です。"

method question4*(this: K04) =
    echo "＊＊＊おみくじプログラム＊＊＊"
    echo "おみくじを引きますか　（はい：１　いいえ：０）　＞"
    var choice = parseInt(readLine(stdin))

    if choice >= 1:
        randomize(getTime().toWinTime)
        var oracle = rand(4)

        case oracle
        of 0:
            echo "大吉　とってもいいことがありそう！！"
        of 1:
            echo "中吉　きっといいことあるんじゃないかな"
        of 2:
            echo "小吉　少しぐらいはいいことあるかもね"
        of 3:
            echo "凶　今日はおとなしくておいた方がいいかも"
        of 4:
            echo "大凶　これじゃやばくない？早く家に帰った方がいいかも"
        else:
            return