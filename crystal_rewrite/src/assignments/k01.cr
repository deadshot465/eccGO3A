require "../shared/question"

class K01 < Question
    def question1
        puts "Hello World! ようこそCrystal言語の世界へ！"
    end

    def question2
        puts "Hello World!"
        puts "ようこそ"
        puts "Crystal言語の世界へ！"
    end

    def question3
        puts "整数：#{12_345}"
        puts "実数：#{123.456789}", 
        puts "文字：#{'X'}"
        puts "文字列：#{"ABCdef"}"
    end

    def question4
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