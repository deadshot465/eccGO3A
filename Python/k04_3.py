class k04_3(object):
    
    def execute(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 3 or age >= 70:
                print('入場料金無料です。')
            elif age >= 3 and age <= 15:
                print('子供料金で半額です。')
            elif age >= 60 and age < 70:
                print('シニア割引で一割引きです。')
            else:
                print('通常料金です。')
        except ValueError as ve:
            print(ve)