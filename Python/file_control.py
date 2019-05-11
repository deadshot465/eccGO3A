from fileinput import *
from executable import executable

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