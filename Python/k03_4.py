from random import Random, randint

class k03_4(object):
    
    def execute(self):
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
            else:
                print('正解です。' if guess > number else '不正解です。')
        except ValueError as ve:
            print(ve)