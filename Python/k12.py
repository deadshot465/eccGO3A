from executable import executable
from random import *
from math import *


class Person(object):
    def __init__(self, name='', birth_year=0, height=0, weight=0):
        self.name = name
        self.birth_year = birth_year
        self.height = height
        self.weight = weight


class Staff(object):
    def __init__(self, name='', gender='', age=0):
        self.name = name
        self.gender = gender
        self.age = age


class Position(object):
    def __init__(self, x=0, y=0, distance=0.0):
        self.x = x
        self.y = y
        self.distance = distance

    def __gt__(self, other):
        return self.distance > other.distance

    def __lt__(self, other):
        return self.distance < other.distance

    def __ge__(self, other):
        return self.distance >= other.distance

    def __le__(self, other):
        return self.distance <= other.distance

    def __eq__(self, other):
        return self.distance == other.distance

    def __ne__(self, other):
        return self.distance != other.distance


class k12(executable):
    def question1(self):
        person = Person()
        person.name = input('名前を入力してください＞')
        person.birth_year = int(input('生年（西暦）を入力してください＞'))
        person.height = float(input('身長を入力してください＞'))
        person.weight = float(input('体重を入力してください＞'))

        print('プロファイル：')
        print('名前：%s' % person.name)
        print('生年：%d' % person.birth_year)
        print('身長：%.1f' % person.height)
        print('体重：%.1f' % person.weight)

    def question2(self):
        staffs = [
            Staff('神木隆之介', 'M', 23),
            Staff('上白石萌音', 'F', 18),
            Staff('長澤まさみ', 'F', 28)
        ]

        print('名前\t\t性別\t年齢')
        print('-' * 35)
        for staff in staffs:
            print('%s\t%s\t%d歳' % (staff.name, staff.gender, staff.age))

    def get_distance(self, player, enemy):
        diff_x = player.x - enemy.x
        diff_y = player.y - enemy.y
        return sqrt(diff_x ** 2 + diff_y ** 2)

    def question3(self):
        rand = Random()
        get_random_number = lambda: rand.randint(0, 100) - 50
        player_pos = Position(get_random_number(), get_random_number())
        enemy_pos = [Position() for x in range(0, 5)]
        for i in range(0, 5):
            enemy_pos[i].x = get_random_number()
            enemy_pos[i].y = get_random_number()
            enemy_pos[i].distance = self.get_distance(player_pos, enemy_pos[i])

        print('プレーヤーの座標：x= %.2f\t\ty= %.2f\n' % (player_pos.x, player_pos.y))
        i = 0
        for pos in enemy_pos:
            print('敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f'
                  % (i, pos.x, pos.y, pos.distance))
            i += 1

    def question4(self):
        rand = Random()
        get_random_number = lambda: rand.randint(0, 100) - 50
        player_pos = Position(get_random_number(), get_random_number())
        enemy_pos = [Position() for x in range(0, 5)]
        for i in range(0, 5):
            enemy_pos[i].x = get_random_number()
            enemy_pos[i].y = get_random_number()
            enemy_pos[i].distance = self.get_distance(player_pos, enemy_pos[i])

        print('プレーヤーの座標：x= %.2f\t\ty= %.2f\n' % (player_pos.x, player_pos.y))
        i = 0
        for pos in enemy_pos:
            print('敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f'
                  % (i, pos.x, pos.y, pos.distance))
            i += 1

        i = 0
        print('\n並び替え後')
        enemy_pos.sort()
        for pos in enemy_pos:
            print('敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f'
                  % (i, pos.x, pos.y, pos.distance))
            i += 1
