from Golem import Golem
from random import Random, randint

class k05(object):
    
    def execute(self, num):
        getattr(self, 'question%d' % num)()

    def question1(self):
        salary = 19.0
        age = 22

        while salary < 50.0:
            salary *= 1.035
            age += 1

        print('{}歳で月給{}万円'.format(age, salary))

    def question2(self):
        try:
            choice = 0

            while choice != 1:
                print('起きろ～')
                print('1．起きた　2．あと5分…　3．Zzzz…\t入力：')
                choice = int(input())

            print('よし、学校へ行こう！')

        except ValueError as ve:
            print(ve)

    def question3(self):
        try:
            choice = 0

            while True:
                print('起きろ～')
                print('1．起きた　2．あと5分…　3．Zzzz…\t入力：')
                choice = int(input())
                if choice == 1:
                    print('よし、学校へ行こう！')
        except ValueError as ve:
            print(ve)
        except KeyboardInterrupt as ki:
            print(ki)

    def question4(self):
        try:
            generator = Random()
            golem = Golem()
            golem.hp = 300 + generator.randint(0, 200)
            
            player_hp = 200 + generator.randint(0, 100)

            print('ゴーレム　（HP:{}　防御力：{}）'.format(golem.hp, golem.defense))

            while golem.hp > 0:
                print('残りHP：{}'.format(golem.hp))
                print('攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞')
                option = int(input())

                if option < 1 or option > 3:
                    continue

                option_dispatch = {
                    1: 60 + generator.randint(0, 40),
                    2: 30 + generator.randint(0, 100),
                    3: 20 + generator.randint(0, 180)
                    }

                damage = option_dispatch[option]
                print('基礎攻撃力は{}です。'.format(damage))
                damage -= golem.defense

                if damage <= 0:
                    damage = 0
                    
                    print('ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」')
                    print('ゴーレムがあなたを攻撃しました！攻撃値：{}'.format(golem.attack))
                    player_hp -= golem.attack

                    if player_hp <= 0:
                        print('あなたはゴーレムに負けました！ゲームオーバー！')
                        return

                    print('あなたの残りHPは：{}'.format(player_hp))

                print('ダメージは{}です。'.format(damage))
                golem.hp -= damage

                if golem.hp < 0:
                    golem.hp = 0

                print('残りのHPは{}です。'.format(golem.hp))

                if golem.hp == 0:
                    print('ゴーレムを倒しました！')

        except ValueError as ve:
            print(ve)

