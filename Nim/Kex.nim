from strutils import parseInt
import Kex_1sub
import os
import Player
import random
import times

var PLAYER_INITIAL_HP = 500
var PLAYER_DEFENSE = 30

type Kex* = ref object of RootObj

method execute*(this: Kex) =
    echo "冒険が今始まる！"
    var player = Player(hp: PLAYER_INITIAL_HP, defense: PLAYER_DEFENSE)
    var continue_game = 1
    var kills = 0
    randomize(getTime().toWinTime)

    while continue_game != 0:
        echo "現HP：", player.hp
        stdout.write "奥に進みますか？（１：奥に進む　０．帰る）＞"
        stdout.flushFile
        continue_game = parseInt(readLine(stdin))
        if continue_game != 0:
            var golem_lv = rand(4)
            attack_golem_ex(golem_lv, player)
            kills += 1
            if player.hp == 0:
                break
    
    echo "リ〇ミト！"
    echo "戦闘回数：", kills, "　残りHP：", player.hp