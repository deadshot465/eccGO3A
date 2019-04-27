class k05_3(object):
    
    def execute(self):
        try:
            choice = 0

            while True:
                print('起きろ～')
                print('1．起きた　2．あと5分…　3．Zzzz…\t入力：')
                choice = int(input())
                if choice == 1:
                    print('よし、学校へ行こう！')
        except ValueError as ve:
            print(ve)