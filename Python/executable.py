class executable(object):

    def execute(self, num):
        getattr(self, "question%d" % num)()

    def question1(self):
        return

    def question2(self):
        return

    def question3(self):
        return

    def question4(self):
        return