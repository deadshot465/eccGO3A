from random import Random, randint

class k03_3(object):
    
    def execute(self):
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