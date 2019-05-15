from Golem import Golem

class k02(object):
    
    def execute(self, num):
        getattr(self, 'question%d' % num)()

    def question1(self):
        seisuu = 3
        jissuu = 2.6
        moji = 'A'

        print('変数seisuuの値は{}'.format(seisuu))
        print('変数jissuuの値は{}'.format(jissuu))
        print('変数mojiの値は{}'.format(moji))

    def question2(self):
        try:
            print('一つ目の整数は？')
            a = int(input())
            print('二つ目の整数は？')
            b = int(input())

            print('{}÷{}={}...{}'.format(a, b, (int)(a / b), a % b))
        except ValueError as ve:
            print(ve)

    def question3(self):
        try:
            print('一つ目の商品の値段は？')
            priceA = int(input())
            print('個数は？')
            amountA = int(input())
            print('二つ目の商品の値段は？')
            priceB = int(input())
            print('個数は？')
            amountB = int(input())

            total = (priceA * amountA + priceB * amountB) * 1.08
            print('お支払いは税込み￥{}です'.format(total))
        except ValueError as ve:
            print(ve)

    def question4(self):
        try:
            golem = Golem()

            print('ゴーレム　（HP：{}　防御力：{}）'.format(golem.hp, golem.defense))
            print('HP：{}'.format(golem.hp))
            print('今回の攻撃の値を入力してください＞')
            damage = int(input())
            damage = damage - golem.defense if damage - golem.defense > 0 else 0
            print('ダメージは{}です。'.format(damage))
            golem.hp -= damage
            print('残りのHPは{}です。'.format(golem.hp))
        except ValueError as ve:
            print(ve)

