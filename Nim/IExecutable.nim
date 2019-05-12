type IExecutable* = ref object of RootObj

method question1*(this: IExecutable) {.base.} =
    return

method question2*(this: IExecutable) {.base.} =
    return

method question3*(this: IExecutable) {.base.} =
    return

method question4*(this: IExecutable) {.base.} =
    return

method execute*(this: IExecutable, num: int) {.base.} =
    case num
    of 1:
        this.question1
    of 2:
        this.question2
    of 3:
        this.question3
    of 4:
        this.question4
    else:
        discard