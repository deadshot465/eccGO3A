from random import Random
from kex_1sub import attack_golem
from player import PlayerEx


class kex(object):
    @staticmethod
    def execute():
        rand = Random()
        print('冒険が今始まる！')

        player = PlayerEx()
        continue_game = True
        kills = 0
        while continue_game:
            print('現HP：%d' % player.hp)
            print('奥に進みますか？（１：奥に進む　０．帰る）＞', end='')
            continue_game = bool(int(input()))
            if continue_game:
                golem_lv = rand.randint(0, 4)
                attack_golem(golem_lv, player)
                kills += 1
                if player.hp == 0:
                    break
        print('リ〇ミト！\n')
        print('戦闘回数：%d　残りHP：%d' % (kills, player.hp))
