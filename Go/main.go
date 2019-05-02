package main

import (
	"fmt"
	"strconv"
)

func showSelection(chapter int) {
	for i := 1; i < 5; i++ {
		fmt.Println(fmt.Sprintf("\t%d) K%d_%d", i, chapter, i))
	}
}

func main() {
	var choice int
	var choice2 int
	var inputText string

	executable := []IExecutable {
		K01{}, K02{}, K03{}, K04{}, K05{}, K06{},
	}

	fmt.Println("実行したいプログラムを選択してください。")
	for i := 1; i < 7; i++ {
		fmt.Println(fmt.Sprintf("%d) K0%d", i, i))
	}


	_, _ = fmt.Scanln(&inputText)
	choice, _ = strconv.Atoi(inputText)

	if choice < 1 || choice > 6 {
		fmt.Println("無効の選択です。")
		return
	}

	showSelection(choice)

	_, _ = fmt.Scanln(&inputText)
	choice2, _ = strconv.Atoi(inputText)

	executable[choice - 1].execute(choice2)
}
