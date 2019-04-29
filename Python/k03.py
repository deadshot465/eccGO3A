from random import Random, randint

class k03(object):
    
    def execute(self, num):
        getattr(self, 'question%d' % num)()

    def question1(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 20:
                print('未成年なので購入できません。')
        except ValueError as ve:
            print(ve)

    def question2(self):
        try:
            print('身長を入力してください。＞')
            height = float(input())
            height /= 100.0
            print('体重を入力してください。＞')
            weight = float(input())
            standard = height * height * 22.0
            print('あなたの標準体重は{}です。'.format(standard))

            if weight > standard and (weight - standard) / standard * 100 > 14:
                print('太り気味です。')
            elif weight < standard and (weight - standard) / standard * 100 < -14:
                print('痩せ気味です。')
            else:
                print('普通ですね。')

        except ValueError as ve:
            print(ve)

    def question3(self):
        try:
            generator = Random()
            number = generator.randint(0, 99)
            print('０から９９の範囲の数値が決定されました。')
            print('決められた数値を予想し、この数値よりも大きな値を入力してください＞')
            
            guess = int(input())
            print('決められた数値は{}です。'.format(number))
            print('正解です。' if guess > number else '不正解です。')
        except ValueError as ve:
            print(ve)

    def question4(self):
        try:
            generator = Random()
            number = generator.randint(0, 99)
            print('０から９９の範囲の数値が決定されました。')
            print('決められた数値を予想し、この数値よりも大きな値を入力してください＞')
            
            guess = int(input())
            print('決められた数値は{}です。'.format(number))

            if guess > 100 or guess < 0:
                print('反則です！')
            elif guess > number and guess - number <= 10:
                print('大正解！')
            elif guess < number and guess - number >= -10:
                print('惜しい！')
            elif guess == number:
                print('お見事！')
            else:
                print('正解です。' if guess > number else '不正解です。')
        except ValueError as ve:
            print(ve)

