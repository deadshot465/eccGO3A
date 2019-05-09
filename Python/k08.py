from executable import executable
from k08_1sub import *
from k08_2sub import attack_golem
from random import Random, randint

class k08(executable):

    def question1(self):
        numbers = []

        for x in range(0, 3):
            print('{}つ目の値を入力してください。＞'.format(x + 1), end='')
            numbers.append(int(input()))

        print('どちらを調べますか？')
        print('（０：最大値　１：最小値）＞', end='')
        choice = int(input())

        if choice == 0:
            print('{}の中で最大値は{}です。'.format(len(numbers),
                                         get_max_value(numbers[0], numbers[1], numbers[2])))
        elif choice == 1:
            print('{}の中で最小値は{}です。'.format(len(numbers),
                                         get_min_value(numbers[0], numbers[1], numbers[2])))

    def question2(self):
        print('冒険が今始まる！')
        generator = Random()
        playerHp = 200 + generator.randint(0, 100)
        continueGame = True

        while continueGame: 
            if playerHp == 0:
                return

            print('あなたのHP：{}'.format(playerHp))
            print('奥に進みますか？（１：奥に進む　０．帰る）＞', end='')
            continueGame = bool(int(input()))
            if continueGame == True:
                golemLv = generator.randint(0, 4)
                playerHp = attack_golem(golemLv, playerHp)

        print('リレ〇ト！')