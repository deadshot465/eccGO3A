from functools import reduce

class k06_1(object):
    
    def execute(self):
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