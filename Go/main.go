package main

import (
	"fmt"
	"strconv"
)

func showSelection(chapter int) {
	for i := 1; i < 5; i++ {
		fmt.Println(fmt.Sprintf("\t%d) K0%d_%d", i, chapter, i))
	}
	if chapter == 9 {
		fmt.Println(fmt.Sprintf("\t5) K0%d_5", chapter))
	}
}

func main() {
	var choice int
	var choice2 int
	var inputText string

	executable := []IExecutable {
		K01{}, K02{}, K03{}, K04{}, K05{}, K06{}, K07{}, K08{}, K09{}, FileControl{},
	}

	fmt.Println("実行したいプログラムを選択してください。")
	for i := 1; i <= len(executable); i++ {
		fmt.Println(fmt.Sprintf("%d) K0%d", i, i))
	}


	_, _ = fmt.Scanln(&inputText)
	choice, _ = strconv.Atoi(inputText)

	if choice < 1 || choice > len(executable) {
		fmt.Println("無効の選択です。")
		return
	}

	showSelection(choice)

	_, _ = fmt.Scanln(&inputText)
	choice2, _ = strconv.Atoi(inputText)

	executable[choice - 1].execute(choice2)
}
