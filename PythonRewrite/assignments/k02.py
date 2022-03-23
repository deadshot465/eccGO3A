from shared.golem import Golem
from shared.question import Question


class K02(Question):
    def question1(self):
        seisuu = 3
        jissuu = 2.6
        moji = 'A'

        print(f'変数seisuuの値は{seisuu}')
        print(f'変数jissuuの値は{jissuu}')
        print(f'変数mojiの値は{moji}')

    def question2(self):
        a = int(input('一つ目の整数は？'))
        b = int(input('二つ目の整数は？'))
        print('{}÷{}={}...{}'.format(a, b, int(a / b), a % b))

    def question3(self):
        price_a = int(input('一つ目の商品の値段は？'))
        amount_a = int(input('個数は？'))
        price_b = int(input('二つ目の商品の値段は？'))
        amount_b = int(input('個数は？'))
        total = (price_a * amount_a + price_b * amount_b) * 1.1
        print(f'お支払いは税込み￥{total}です')

    def question4(self):
        golem = Golem(hp=300, defense=80, attack=50)
        print(f'ゴーレム　（HP：{golem.hp}　防御力：{golem.defense}）')
        print(f'HP：{golem.hp}')
        damage = int(input('今回の攻撃の値を入力してください＞'))
        damage = damage - golem.defense if damage - golem.defense > 0 else 0
        print(f'ダメージは{damage}です。')
        golem.hp -= damage
        print(f'残りのHPは{golem.hp}です。')
