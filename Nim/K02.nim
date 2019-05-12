import os
from strutils import parseInt
import IExecutable, Golem

type K02* = ref object of IExecutable

method question1*(this: K02) =
    var seisuu = 3
    var jissuu: float32 = 2.6
    var moji = 'A'
    echo "変数seisuuの値は", seisuu
    echo "変数jissuuの値は", jissuu
    echo "変数mojiの値は", moji

method question2*(this: K02) =
    stdout.write "一つ目の整数は？"
    stdout.flushFile
    var a = parseInt(readLine(stdin))
    stdout.write "二つ目の整数は？"
    stdout.flushFile
    var b = parseInt(readLine(stdin))
    echo a, "÷", b, "=", a div b, "...", a mod b

method question3*(this: K02) =
    stdout.write "一つ目の商品の値段は？"
    stdout.flushFile
    var priceA = parseInt(readLine(stdin))
    stdout.write "個数は？"
    stdout.flushFile
    var amountA = parseInt(readLine(stdin))
    stdout.write "二つ目の商品の値段は？"
    stdout.flushFile
    var priceB = parseInt(readLine(stdin))
    stdout.write "個数は？"
    stdout.flushFile
    var amountB = parseInt(readLine(stdin))
    var total = (priceA * amountA + priceB * amountB).toFloat * 1.08
    echo "お支払いは税込み￥", total, "です"

method question4*(this: K02) =
    var golem = Golem(hp: 300, defense: 80, attack: 50)
    
    echo "ゴーレム　（HP：", golem.hp, "　防御力：", golem.defense, "）"
    echo "HP：", golem.hp
    stdout.write "今回の攻撃の値を入力してください＞"
    stdout.flushFile
    var damage = parseInt(readLine(stdin))
    damage -= golem.defense
    echo "ダメージは", damage, "です。"
    golem.hp -= damage
    echo "残りのHPは", golem.hp, "です。"