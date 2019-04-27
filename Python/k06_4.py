class k06_4(object):
    
    def execute(self):
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
