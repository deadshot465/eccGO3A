from executable import executable

class k07(executable):

    def show_texts(self):
        print("Hello World!")
        print("ようこそ")
        print("Python言語の世界へ！")

    def get_max_value(self, value1, value2, value3):
        temp = value1 if value1 >= value2 else value2
        temp = temp if temp >= value3 else value3
        return temp

    def get_type(self, age):
        if age <= 0:
            return 0
        elif age < 3 or age >= 70:
            return 1
        elif age >= 3 and age <= 15:
            return 2
        elif age >= 60 and age < 70:
            return 3
        else:
            return 4

    def question1(self):
        choice = 1
        try:
            while choice != 0:
                print("メッセージを表示しますか？（０：終了する　１：表示する）＞", end="")
                choice = int(input())
                if choice == 1:
                    self.show_texts()
            print("終了します。")
        except ValueError as ve:
            print(ve)

    def question2(self):
        try:
            numbers = []
            for x in range(1, 4):
                print("{}つ目の値を入力してください。＞".format(x), end="")
                numbers.append(int(input()))

            max_value = self.get_max_value(numbers[0], numbers[1], numbers[2])
            print("{}つの中で最大値は{}です。".format(len(numbers), max_value))

        except ValueError as ve:
            print(ve)

    def question3(self):
        try:
            age = 0
            no = 0
            print("年齢を入力して下さい。＞", end="")
            age = int(input())

            no = self.get_type(age)
            dispatcher = {
                0: "不適切な値が入力されました。",
                1: "入場料金無料です。",
                2: "子供料金で半額です。",
                3: "シニア割引で１割引きです。"
                }

            print(dispatcher.get(no, "通常料金です。"))

        except ValueError as ve:
            print(ve)

