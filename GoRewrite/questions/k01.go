package questions

import "fmt"

type K01 struct {}

func (k K01) question1() {
	fmt.Println("Hello World! ようこそGo言語の世界へ！")
}

func (k K01) question2() {
	fmt.Println("Hello World!")
	fmt.Println("ようこそ")
	fmt.Println("Go言語の世界へ！")
}

func (k K01) question3() {
	fmt.Printf("整数：%d\n", 12345)
	fmt.Printf("実数：%f\n", 123.456789)
	fmt.Printf("文字：%c\n", 'A')
	fmt.Printf("文字列：%s\n", "ABCdef")
}

func (k K01) question4() {
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

func (k K01) Execute(number int) {
	switch number {
	case 1:
		k.question1()
	case 2:
		k.question2()
	case 3:
		k.question3()
	case 4:
		k.question4()
	}
}

