import Foundation

class K01 : Question {
    func question1() {
        print("Hello World! ようこそSwift言語の世界へ！")
    }

    func question2() {
        print("Hello World!")
        print("ようこそ")
        print("Swift言語の世界へ！")
    }

    func question3() {
        print("整数：\(12345)")
        print("実数：\(123.456789)")
        print("文字：\("A")")
        print("文字列：\("ABCdef")")
    }

    func question4() {
        print("              ##")
        print("             #  #")
        print("             #  #")
        print("            #    #")
        print("           #      #")
        print("         ##        ##")
        print("       ##            ##")
        print("    ###                ###")
        print(" ###       ##    ##       ###")
        print("##        #  #  #  #        ##")
        print("##         ##    ##         ##")
        print(" ##     #            #     ##")
        print("  ###     ##########     ###")
        print("     ###              ###")
        print("        ##############")
    }

    func execute(number: Int) {
        switch number {
        case 1:
            question1()
        case 2:
            question2()
        case 3:
            question3()
        case 4:
            question4()
        default:
            break
        }
    }


}