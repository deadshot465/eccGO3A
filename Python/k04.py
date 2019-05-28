from random import Random, randint

class k04(object):
    
    def execute(self, num):
        getattr(self, 'question%d' % num)()

    def question1(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 3 or age >= 70:
                print('入場料金無料です。')
            else:
                print('通常料金です。')
        except ValueError as ve:
            print(ve)

    def question2(self):
        try:
            print('性別を選択してください。（０：男性　１：女性）＞')
            gender = int(input())
            
            gender_dispatch = {
                0: 'あら、格好良いですね。',
                1: 'あら、モデルさんみたいですね。'
                }

            print(gender_dispatch.get(gender, 'そんな選択肢はありません。'))

        except ValueError as ve:
            print(ve)

    def question3(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 3 or age >= 70:
                print('入場料金無料です。')
            elif 3 <= age <= 15:
                print('子供料金で半額です。')
            elif 60 <= age < 70:
                print('シニア割引で一割引きです。')
            else:
                print('通常料金です。')
        except ValueError as ve:
            print(ve)

    def question4(self):
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

