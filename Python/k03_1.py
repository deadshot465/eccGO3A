class k03_1(object):
    
    def execute(self):
        try:
            print('年齢を入力してください。＞')
            age = int(input())
            if age < 20:
                print('未成年なので購入できません。')
        except ValueError as ve:
            print(ve)