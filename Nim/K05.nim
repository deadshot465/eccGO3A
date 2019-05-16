import os
import random
import times
from strutils import parseInt
import Golem, IExecutable

type K05* = ref object of IExecutable

method question1*(this: K05) =
    var salary: float32 = 19.0
    var age = 22
    while salary < 50.0:
        salary *= 1.035
        inc(age)
    echo age, "歳で月給￥", salary, "万円"

method question2*(this: K05) =
    var choice = 0
    while choice != 1:
        echo "起きろ～"
        stdout.write "1．起きた　2．あと5分…　3．Zzzz…\t入力："
        stdout.flushFile
        choice = parseInt(readLine(stdin))
    echo "よし、学校へ行こう！"

method question3*(this: K05) =
    var choice = 0
    while true:
        echo "起きろ～"
        stdout.write "1．起きた　2．あと5分…　3．Zzzz…\t入力："
        stdout.flushFile
        choice = parseInt(readLine(stdin))
        if choice == 1:
            echo "よし、学校へ行こう！"
    

method question4*(this: K05) =
    randomize(getTime().toWinTime)
    var golem = Golem(hp: 300 + rand(200), defense: 80, attack: 50)
    var player_hp = 200 + rand(100)
        
    echo "ゴーレム　（HP：", golem.hp, "　防御力：", golem.defense, "）"
    while golem.hp > 0:
        stdout.write "攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）＞"
        stdout.flushFile
        var choice = parseInt(readLine(stdin))
        var damage: int
        case choice
        of 1:
            damage = 60 + rand(40)
        of 2:
            damage = 30 + rand(100)
        of 3:
            damage = 20 + rand(180)
        else:
            damage = 0
    
        damage -= golem.defense
        
        if damage <= 0:
            damage = 0
            echo "ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」"
            echo "ゴーレムがあなたを攻撃しました！攻撃値：", golem.attack
            player_hp -= golem.attack

            if player_hp <= 0:
                player_hp = 0
                echo "あなたはゴーレムに負けました！ゲームオーバー！"
                return
            echo "あなたの残りHPは：", player_hp

        echo "ダメージは", damage, "です。"
        golem.hp -= damage

        if golem.hp <= 0:
            golem.hp = 0
        
        echo "残りのHPは", golem.hp, "です。"

        if golem.hp == 0:
            echo "ゴーレムを倒しました！"