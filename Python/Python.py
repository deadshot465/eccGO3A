from k01_1 import k01_1
from k01_2 import k01_2
from k01_3 import k01_3
from k01_4 import k01_4
from k02_1 import k02_1
from k02_2 import k02_2
from k02_3 import k02_3
from k02_4 import k02_4
from k03_1 import k03_1
from k03_2 import k03_2
from k03_3 import k03_3
from k03_4 import k03_4
from k04_1 import k04_1
from k04_2 import k04_2
from k04_3 import k04_3
from k04_4 import k04_4
from k05_1 import k05_1
from k05_2 import k05_2
from k05_3 import k05_3
from k05_4 import k05_4
from k06_1 import k06_1
from k06_2 import k06_2
from k06_3 import k06_3
from k06_4 import k06_4

def show_selections(chapter):
    j = 1
    for i in range(4 * chapter - 3, 4 * chapter + 1):
        print('\t{}) K0{}_{}'.format(i, chapter, j))
        j += 1

executables = [ k01_1(), k01_2(), k01_3(), k01_4(),
               k02_1(), k02_2(), k02_3(), k02_4(),
               k03_1(), k03_2(), k03_3(), k03_4(),
               k04_1(), k04_2(), k04_3(), k04_4(),
               k05_1(), k05_2(), k05_3(), k05_4(),
               k06_1(), k06_2(), k06_3(), k06_4()
              ]

print("実行したいプログラムを選択してください。")

for x in range(1, 7):
    print('{}) K0{}'.format(x, x))

try:
    choice = int(input())
    show_selections(choice)
    choice = int(input())
    executables[choice - 1].execute()
except ValueError as ve:
    print('無効の選択です。')
    print(ve)