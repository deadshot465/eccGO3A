from k01 import k01
from k02 import k02
from k03 import k03
from k04 import k04
from k05 import k05
from k06 import k06

def show_selections(chapter):
    for i in range(1, 5):
        print('\t{}) K0{}_{}'.format(i, chapter, i))

executables = [ k01(), k02(), k03(), k04(), k05(), k06() ]

print("実行したいプログラムを選択してください。")

for x in range(1, 7):
    print('{}) K0{}'.format(x, x))

try:
    choice = int(input())
    show_selections(choice)
    choice2 = int(input())
    executables[choice - 1].execute(choice2)
except ValueError as ve:
    print('無効の選択です。')
    print(ve)