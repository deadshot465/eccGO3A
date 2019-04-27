class k04_1(object):
    
    def execute(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 3 or age >= 70:
                print('入場料金無料です。')
            else:
                print('通常料金です。')
        except ValueError as ve:
            print(ve)