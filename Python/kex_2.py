from random import Random
from kex_2_battle import attack_enemy
from kex_2_enemy import create_enemy
from player import PlayerEx


class Kex_2(object):
    @staticmethod
    def execute():
        random = Random()
        print('冒険が今始まる！')
        player = PlayerEx()
        continue_game = True
        kills = 0

        while continue_game:
            print('現HP：%d' % player.hp)
            continue_game = bool(int(input('奥に進みますか？（１：奥に進む　０．帰る）＞')))
            if continue_game:
                type_no = random.randint(0, 2)
                enemy = create_enemy(type_no)
                result = attack_enemy(player, enemy)
                kills += 1

                if not result:
                    break
        print('リ〇ミト！\n')
        print('戦闘回数：%d回　残りHP：%d' % (kills, player.hp))
