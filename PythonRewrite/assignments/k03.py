from random import randint

from shared.question import Question


class K03(Question):
    def question1(self):
        age = int(input('年齢を入力してください。＞'))
        if age < 20:
            print('未成年なので購入できません。')

    def question2(self):
        height = float(input('身長を入力してください。＞'))
        height /= 100.0
        weight = float(input('体重を入力してください。＞'))
        standard = height * height * 22.0
        print(f'あなたの標準体重は{standard}です。')

        if weight > standard and (weight - standard) / standard * 100 > 14:
            print('太り気味です。')
        elif weight < standard and (weight - standard) / standard * 100 < -14:
            print('痩せ気味です。')
        else:
            print('普通ですね。')

    def question3(self):
        number = randint(0, 99)
        print('０から９９の範囲の数値が決定されました。')

        guess = int(input('決められた数値を予想し、この数値よりも大きな値を入力してください＞'))
        print('決められた数値は{}です。'.format(number))
        print('正解です。' if guess > number else '不正解です。')

    def question4(self):
        number = randint(0, 99)
        print('０から９９の範囲の数値が決定されました。')
        guess = int(input('決められた数値を予想し、この数値よりも大きな値を入力してください＞'))

        match guess:
            case x if x > 100 or x < 0:
                print('反則です！')
            case x if x > number and x - number <= 10:
                print('大正解！')
            case x if x < number and x - number >= -10:
                print('惜しい！')
            case x if x == number:
                print('お見事！')
            case _:
                print('正解です。' if guess > number else '不正解です。')
