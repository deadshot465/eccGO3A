class k02_2(object):
    
    def execute(self):
        try:
            print('一つ目の整数は？')
            a = int(input())
            print('二つ目の整数は？')
            b = int(input())

            print('{}÷{}={}...{}'.format(a, b, (int)(a / b), a % b))
        except ValueError as ve:
            print(ve)



