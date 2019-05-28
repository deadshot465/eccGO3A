from k01 import k01
from k02 import k02
from k03 import k03
from k04 import k04
from k05 import k05
from k06 import k06
from k07 import k07
from k08 import k08
from k09 import k09
from k10 import k10
from k11 import k11
from kex import kex
from file_control import FileControl

def show_selections(chapter):
    if chapter < 10:
        for i in range(1, 5):
            print('\t{}) K0{}_{}'.format(i, chapter, i))
        if chapter == 9:
            print('\t5) K0{}_5'.format(chapter))
    else:
        for i in range(1, 5):
            print('\t{}) K{}_{}'.format(i, chapter, i))


executables = [ k01(), k02(), k03(), k04(), k05(),
                k06(), k07(), k08(), k09(), k10(),
                k11(), FileControl() ]

print("実行したいプログラムを選択してください。")

for x in range(1, len(executables) + 1):
    if x < 10:
        print('{}) K0{}'.format(x, x))
    else:
        print('{}) K{}'.format(x, x))
print('100) Kex')

try:
    choice = int(input())
    if choice == 100:
        _kex = kex()
        _kex.execute()
    else:
        show_selections(choice)
        choice2 = int(input())
        executables[choice - 1].execute(choice2)
except ValueError as ve:
    print('無効の選択です。')
    print(ve)