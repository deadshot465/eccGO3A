import IExecutable

type FileControl* = ref object of IExecutable

method question1*(this: FileControl) =
    var outputString = "This is the string to output.\n"
    writeFile("output.txt", outputString)
    echo "Completed."