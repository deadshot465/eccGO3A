import os
import random
import times
from strutils import parseInt
import Player
import Golem

var GOLEM_HIT = 70
var GOLEM_FLEE = 20
var ATTACK_HIT = 110
var SKILL_HIT = 100
var MAGIC_HIT = 70

proc check_hit_or_miss(hit: int): bool =
    randomize(getTime().toWinTime)
    var val = rand(99)
    return val <= hit - 1

proc attack_golem_ex*(lv: int, player: var Player) =
    var golem = GolemEx(
        hp: lv * 50 + 100,
        defense: lv * 10 + 40,
        attack: lv * 10 + 40,
        hit: GOLEM_HIT,
        flee: GOLEM_FLEE
    )

    echo "ゴーレムLv.", lv + 1, "が現れた！"
    while golem.hp > 0:
        echo "ゴーレム 残りHP：", golem.hp
        stdout.write "武器を選択してください（１．攻撃　２．特技　３．魔法）＞"
        stdout.flushFile
        var choice = parseInt(readLine(stdin))
        randomize(getTime().toWinTime)
        var damage: int
        var is_hit = false

        case choice
        of 1:
            damage = 60 + rand(40)
            is_hit = check_hit_or_miss(ATTACK_HIT - golem.flee)
        of 2:
            damage = 30 + rand(100)
            is_hit = check_hit_or_miss(SKILL_HIT - golem.flee)
        of 3:
            damage = 20 + rand(180)
            is_hit = check_hit_or_miss(MAGIC_HIT - golem.flee)
        else:
            damage = 0
        
        if is_hit:
            damage -= golem.defense
            if damage <= 0:
                damage = 0
            echo damage, "のダメージ！"
            golem.hp -= damage
        else:
            echo "攻撃を外した！"
        
        echo "ゴーレムの攻撃！"
        is_hit = check_hit_or_miss(golem.hit)
        if is_hit:
            var injury = golem.attack - player.defense
            echo injury, "のダメージ！"
            player.hp -= injury
            if player.hp <= 0:
                player.hp = 0
                echo "あなたはゴーレムに負けました！ゲームオーバー！"
                return
        else:
            echo "攻撃を外した！"
        
        echo "プレイヤー残りHP：", player.hp
        if golem.hp <= 0:
            golem.hp = 0
        if golem.hp == 0:
            echo "ゴーレムLv.", lv + 1, "を倒した！"