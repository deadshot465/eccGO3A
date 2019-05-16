import IExecutable

type K01* = ref object of IExecutable

method question1*(this: K01) =
    echo "Hello World!　ようこそ　Nim言語の世界へ！"

method question2*(this: K01) =
    echo "Hello World!"
    echo "ようこそ"
    echo "Nim言語の世界へ！"

method question3*(this: K01) =
    echo "整数：", 12345
    echo "実数：", 123.456789
    echo "文字：", 'A'
    echo "文字列：", "ABCdef"

method question4*(this: K01) =
    echo "              ##"
    echo "             #  #"
    echo "             #  #"
    echo "            #    #"
    echo "           #      #"
    echo "         ##        ##"
    echo "       ##            ##"
    echo "    ###                ###"
    echo " ###       ##    ##       ###"
    echo "##        #  #  #  #        ##"
    echo "##         ##    ##         ##"
    echo " ##     #            #     ##"
    echo "  ###     ##########     ###"
    echo "     ###              ###"
    echo "        ##############"