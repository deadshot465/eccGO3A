require "./IExecutable"

class K01 < IExecutable
    def question_1()
        puts "Hello World!　ようこそCrystal言語の世界へ！"
    end

    def question_2()
        puts "Hello World!"
        puts "ようこそ"
        puts "Crystal言語の世界へ！"
    end

    def question_3()
        puts "整数：#{12345}"
        puts "実数：#{123.456789}"
        puts "文字：#{'A'}"
        puts "文字列：#{"ABCdef"}"
    end

    def question_4()
        puts "              ##"
        puts "             #  #"
        puts "             #  #"
        puts "            #    #"
        puts "           #      #"
        puts "         ##        ##"
        puts "       ##            ##"
        puts "    ###                ###"
        puts " ###       ##    ##       ###"
        puts "##        #  #  #  #        ##"
        puts "##         ##    ##         ##"
        puts " ##     #            #     ##"
        puts "  ###     ##########     ###"
        puts "     ###              ###"
        puts "        ##############"
    end
end