class k05_2(object):
    
    def execute(self):
        try:
            choice = 0

            while choice != 1:
                print('起きろ～')
                print('1．起きた　2．あと5分…　3．Zzzz…\t入力：')
                choice = int(input())

            print('よし、学校へ行こう！')

        except ValueError as ve:
            print(ve)