from executable import executable
from functools import *

class k09(executable):
    
    def question1(self):
        try:
            ages = []

            for x in range(0, 3):
                print('%d人目の年齢を入力＞' % (x + 1))
                ages.append(int(input()))
        
            print("-" * 20)

            for x in range(0, 3):
                print('{}人目：{}歳'.format(x + 1, ages[x]))

            print('平均年齢：%.1f' % (round(sum(ages) / len(ages), 1)))
        except ValueError as ve:
            print(ve)

    def question2(self):
        numbers = [8, 3, 12, 7, 9]
        print('元々の配列：', end='')
        for x in numbers:
            print('%d ' % x, end='')
        print()

        numbers.reverse()

        print('逆順での表示：', end='')
        for x in numbers:
            print('%d ' % x, end='')
        print()

    def question3(self):
        student_scores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
            ]

        print('\t|\t科目A\t科目B\t科目C\t科目D')
        print('-' * 45)
        
        for x in range(0, len(student_scores)):
            print('学生%d\t|\t' % (x + 1), end='')
            for y in range(0, len(student_scores[x])):
                print('%d\t' % (student_scores[x][y]), end='')
            print()

    def question4(self):
        student_scores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
            ]

        total = 0
        average = [0, 0, 0, 0]

        print('\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点')
        print('-' * 65)

        for x in range(0, len(student_scores)):
            print('学生%d\t|\t' % (x + 1), end='')
            for y in range(0, len(student_scores[x])):
                print('%d\t' % (student_scores[x][y]), end='')
                total += student_scores[x][y]
                average[y] += student_scores[x][y]
            print('|\t%d' % (total), end='')
            total = 0
            print()
        print('平均点\t|\t', end='')
        for x in average:
            print('%.1f\t' % round(x / 3.0, 1), end='')
        print('|')

    def question5(self):
        try:
            numbers = []
            for x in range(0, 100):
                print('%d件目の入力：' % (x + 1), end='')
                numbers.append(int(input()))
                if numbers[x] < 0:
                    break

            print('----並び替え後----')
            numbers.pop()
            numbers.sort()
            for x in numbers:
                print(x)

        except ValueError as ve:
            print(ve)