class k05_1(object):
    
    def execute(self):
        salary = 19.0
        age = 22

        while salary < 50.0:
            salary *= 1.035
            age += 1

        print('{}歳で月給{}万円'.format(age, salary))
