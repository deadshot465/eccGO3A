from executable import executable
from functools import reduce
import re


class k11(executable):
    MAX_PEOPLE = 5

    def question1(self):
        try:
            ages = []

            for i in range(0, self.MAX_PEOPLE):
                age = int(input('{}人目の年齢を入力して下さい：'.format(i + 1)))
                ages.append(age)

            average = reduce(lambda x, y: x + y, ages) / len(ages)

            print('{}人の平均年齢は{}です。'.format(len(ages), average))

        except ValueError as ve:
            print(ve)

    def question2(self):
        str1 = input('1つ目の文字列を入力して下さい。＞')
        str2 = input('2つ目の文字列を入力して下さい。＞')
        str1 = str1 + str2
        print("{}の文字数は{}です。".format(str1, len(str1)))

    def question3(self):
        char = input('文字を入力して下さい。＞')
        applied = False
        if char.isdigit():
            print('この文字は数字です。')
            applied = True
        if char.isupper():
            print('この文字は英大文字です。')
            applied = True
        if char.islower():
            print('この文字は英小文字です。')
            applied = True
        if re.search('^[A-Fa-f0-9]$', char) is not None:
            print('この文字は16進数として使える文字です。')
            applied = True
        if re.search('^(.|,|!?|:|;|"|\'|-|\(|\))$', char) is not None:
            print('この文字は区切り文字です。')
            applied = True
        if not applied:
            print('この文字はよくわからない文字です。')

    def question4(self):
        alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        input_string = 'I am a STUDENT. I am good at GAME PROGRAMMING.'

        count = 0
        _count = 0

        print('文字列：%s' % input_string)
        print('\n文字頻度')
        for i in alphabets:
            for j in input_string:
                if i == j.upper():
                    count += 1
            print('%s: %d\t' % (i, count), end='')
            count = 0
            _count += 1

            if _count % 4 == 0:
                print()
