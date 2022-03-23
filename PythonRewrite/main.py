from assignments import k01, k02, k03
from assignments.musicians import band_supervisor
from shared.question import Question


def show_selection(chapter: int):
    for x in range(1, 5):
        if chapter < 10:
            print(f'\t{x}) K0{chapter}_{x}')
        else:
            print(f'\t{x}) K{chapter}_{x}')

    if chapter == 9:
        print(f'\t5) K0{chapter}_5')


questions: list[Question] = [
    k01.K01(), k02.K02(), k03.K03()
]

if __name__ == '__main__':
    print('実行したいプログラムを選択してください。')

    for x in range(1, len(questions) + 1):
        if x < 10:
            print(f'{x}) K0{x}')
        else:
            added_number = x + 3 if x >= 12 else x
            print(f'{x}) K{added_number}')

    print('100) Kex_1')
    print('101) Kex_2')
    print('102) Sort')
    print('103) Band Supervisor')

    choice = int(input())

    match choice:
        case 100, 101, 102:
            pass
        case 103:
            band_supervisor.start_band(3)
        case _:
            show_selection(choice)
            choice_2 = int(input())
            questions[choice - 1].execute(choice_2)