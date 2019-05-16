from fileinput import *
from executable import executable
import time

class FileControl(executable):
    
    def question1(self):
        try:
            fs = open("output.txt", "w")
            output_string = 'This is the string to write.\n'
            fs.writelines(output_string)
            fs.close()
            print("Completed.")
        except Exception as ex:
            print(ex)

    def question2(self):
        begin = time.time()
        multiply = 1.0
        for x in range(1, 151):
            multiply = multiply * x
        end = time.time()
        print(end - begin)