from functools import reduce;

class k06(object):
    
    def execute(self, num):
        getattr(self, 'question%d' % num)()

    def question1(self):
        try:
            ages = []
            
            for i in range(0, 5):
                print('{}人目の年齢を入力して下さい：'.format(i + 1))
                age = int(input())
                ages.append(age)

            average = reduce(lambda x, y: x + y, ages) / len(ages)
            
            print('{}人の平均年齢は{}です。'.format(len(ages), average))

        except ValueError as ve:
            print(ve)

    def question2(self):
        for i in range(0, 9):
            for j in range(0, i + 1):
                print('*', end='')
            print('')
        print('')

        for i in range(9, 0, -1):
            for j in range(0, i):
                print('*', end='')
            print('')
        print('')

        for i in range(9, 0, -1):
            for j in range(0, i - 1):
                print(' ', end='')

            for k in range(9, i - 1, -1):
                print('*', end='')
            print('')
        print('')

    def question3(self):
        total = 370
        count = 0

        for i in range(0, int(total / 100) + 1):
            for j in range(0, int(total / 50) + 1):
                for k in range(0, int(total / 10) + 1):
                    if 100 * i + 50 * j + 10 * k == total:
                        print('10円の硬貨{}枚 50円の硬貨{}枚 100円の硬貨{}枚'.format(k, j, i))
                        count += 1

        print('\n以上{}通りを発見しました。'.format(count))

    def question4(self):
        print('\t|\t', end='')

        for i in range(1, 10):
            print('{}\t'.format(i), end='')
        print('')

        for i in range(1, 85):
            print('-', end='')
        print('')

        for i in range(1, 10):
            print('{}\t|\t'.format(i), end='')
            for j in range(1, 10):
                print('{}\t'.format(i * j), end='')
            print('')

