class executable(object):

    def execute(self, num):
        getattr(self, "question%d" % num)()
