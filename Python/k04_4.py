from random import Random, randint

class k04_4(object):
    
    def execute(self):
        try:
            print('＊＊＊おみくじプログラム＊＊＊')
            print('おみくじを引きますか　（はい：１　いいえ：０）　＞')
            choice = int(input())

            if choice >= 1:
                generator = Random()
                oracle = generator.randint(0, 4)

                fortunes = {
                    0: '大吉　とってもいいことがありそう！！',
                    1: '中吉　きっといいことあるんじゃないかな',
                    2: '小吉　少しぐらいはいいことあるかもね',
                    3: '凶　今日はおとなしくておいた方がいいかも',
                    4: '大凶　これじゃやばくない？早く家に帰った方がいいかも'
                    }

                print(fortunes[oracle])

        except ValueError as ve:
            print(ve)