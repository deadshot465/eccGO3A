class k06_2(object):
    
    def execute(self):
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