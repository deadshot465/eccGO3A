class k04_2(object):
    
    def execute(self):
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