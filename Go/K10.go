package main

import "fmt"

type K10 struct {

}

func (k10 K10) execute(num int) {
	switch num {
	case 1:
		k10.question1()
	case 2:
		k10.question2()
	case 3:
		k10.question3()
	case 4:
		k10.question4()
	}
}

func (k10 K10) question1() {
	fmt.Print("文字列の入力＞")
	var inputString string
	_, _ = fmt.Scanln(&inputString)
	fmt.Println(fmt.Sprintf("入力された文字列の文字数：%d", len(inputString)))
}

func (k10 K10) question2() {
	str := "STRINGcopy"
	fmt.Println(fmt.Sprintf("コピーしたい文字列：%s", str))
	copyStr := str
	fmt.Println(fmt.Sprintf("コピー後の文字列：%s", copyStr))
}

func (k10 K10) question3() {
	str := []string{"abcdef", "GHIJKL", "13579"}
	fmt.Println("連結したい３つの文字列：")
	var concatStr string
	for i := 0; i < len(str); i++ {
		fmt.Println(str[i])
		concatStr += str[i]
	}
	fmt.Println(fmt.Sprintf("連結した文字列：%s", concatStr))
}

func (k10 K10) question4() {
	alphabets := "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	inputStr := "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."

	count := 0
	_count := 0

	fmt.Println(fmt.Sprintf("文字列：%s\n", inputStr))
	fmt.Println("文字頻度")
	for i := 0; i < len(alphabets); i++ {
		for j := 0; j < len(inputStr); j++ {
			if alphabets[i] == inputStr[j] {
				count++
			}
		}
		fmt.Print(fmt.Sprintf("%c: %d\t", alphabets[i], count))
		count = 0
		_count++
		if _count % 4 == 0 {
			fmt.Println()
		}
	}
}
