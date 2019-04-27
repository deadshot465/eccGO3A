class k02_3(object):
    
    def execute(self):
        try:
            print('一つ目の商品の値段は？')
            priceA = int(input())
            print('個数は？')
            amountA = int(input())
            print('二つ目の商品の値段は？')
            priceB = int(input())
            print('個数は？')
            amountB = int(input())

            total = (priceA * amountA + priceB * amountB) * 1.08
            print('お支払いは税込み￥{}です'.format(total))
        except ValueError as ve:
            print(ve)


