from executable import executable

class k10(executable):
    def question1(self):
        print('文字列の入力＞', end='')
        input_str = input()
        print('入力された文字列の文字数：%d' % len(input_str))

    def question2(self):
        str = 'STRINGcopy'
        print('コピーしたい文字列：%s' % str)
        copy_str = str
        print('コピー後の文字列：%s' % copy_str)

    def question3(self):
        str = [
            'abcdef', 'GHIJKL', '13579'
            ]
        str_combined = ''
        print('連結したい３つの文字列：')
        for s in str:
            print(s)
            str_combined += s
        print('連結した文字列：%s' % str_combined)

    def question4(self):
        alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        inputString = 'I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.'

        count = 0
        _count = 0

        print('文字列：%s' % inputString)
        print('\n文字頻度')
        for i in alphabets:
            for j in inputString:
                if i == j:
                    count += 1
            print('%s: %d\t' % (i, count), end='')
            count = 0
            _count += 1

            if _count % 4 == 0:
                print()