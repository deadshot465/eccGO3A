class k03_2(object):
    
    def execute(self):
        try:
            print('身長を入力してください。＞')
            height = float(input())
            height /= 100.0
            print('体重を入力してください。＞')
            weight = float(input())
            standard = height * height * 22.0
            print('あなたの標準体重は{}です。'.format(standard))

            if weight > standard and (weight - standard) / standard * 100 > 14:
                print('太り気味です。')
            elif weight < standard and (weight - standard) / standard * 100 < -14:
                print('痩せ気味です。')
            else:
                print('普通ですね。')

        except ValueError as ve:
            print(ve)