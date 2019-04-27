class k06_3(object):
    
    def execute(self):
        total = 370
        count = 0

        for i in range(0, int(total / 100) + 1):
            for j in range(0, int(total / 50) + 1):
                for k in range(0, int(total / 10) + 1):
                    if 100 * i + 50 * j + 10 * k == total:
                        print('10円の硬貨{}枚 50円の硬貨{}枚 100円の硬貨{}枚'.format(k, j, i))
                        count += 1

        print('\n以上{}通りを発見しました。'.format(count))