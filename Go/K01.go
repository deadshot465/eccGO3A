package main

import "fmt"

type K01 struct {}

func (k01 K01) question1() {
	fmt.Println("Hello World!　ようこそGo言語の世界へ！")
}

func (k01 K01) question2() {
	fmt.Println("Hello World!")
	fmt.Println("ようこそ")
	fmt.Println("Go言語の世界へ！")
}

func (k01 K01) question3() {
	fmt.Println(fmt.Sprintf("整数：%d", 12345))
	fmt.Println(fmt.Sprintf("実数：%f", 123.456789))
	fmt.Println(fmt.Sprintf("文字：%c", 'A'))
	fmt.Println(fmt.Sprintf("文字列：%s", "ABCdef"))
}

func (k01 K01) question4() {
	fmt.Println("              ##")
	fmt.Println("             #  #")
	fmt.Println("             #  #")
	fmt.Println("            #    #")
	fmt.Println("           #      #")
	fmt.Println("         ##        ##")
	fmt.Println("       ##            ##")
	fmt.Println("    ###                ###")
	fmt.Println(" ###       ##    ##       ###")
	fmt.Println("##        #  #  #  #        ##")
	fmt.Println("##         ##    ##         ##")
	fmt.Println(" ##     #            #     ##")
	fmt.Println("  ###     ##########     ###")
	fmt.Println("     ###              ###")
	fmt.Println("        ##############")
}

func (k01 K01) execute(num int) {
	switch num {
	case 1:
		k01.question1()
	case 2:
		k01.question2()
	case 3:
		k01.question3()
	case 4:
		k01.question4()
	default:
		break
	}
}