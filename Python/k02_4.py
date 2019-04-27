from Golem import Golem

class k02_4(object):
    
    def execute(self):
        try:
            golem = Golem()

            print('ゴーレム　（HP:{}　防御力：{})'.format(golem.hp, golem.defense))
            print('HP：{}'.format(golem.hp))
            print('今回の攻撃の値を入力してください＞')
            damage = int(input())
            damage = damage - golem.defense if damage - golem.defense > 0 else 0
            print('ダメージは{}です。'.format(damage))
            golem.hp -= damage
            print('残りのHPは{}です。'.format(golem.hp))
        except ValueError as ve:
            print(ve)