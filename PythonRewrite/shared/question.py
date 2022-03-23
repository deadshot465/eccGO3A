import abc


class Question(abc.ABC):
    @abc.abstractmethod
    def question1(self):
        pass

    @abc.abstractmethod
    def question2(self):
        pass

    @abc.abstractmethod
    def question3(self):
        pass

    @abc.abstractmethod
    def question4(self):
        pass

    def execute(self, n: int):
        match n:
            case 1:
                self.question1()
            case 2:
                self.question2()
            case 3:
                self.question3()
            case 4:
                self.question4()
            case _:
                pass
