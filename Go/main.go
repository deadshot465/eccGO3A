package main

import (
	"fmt"
	"strconv"
)

func showSelection(chapter int) {
	if chapter < 10 {
		for i := 1; i <= 4; i++ {
			fmt.Printf("\t%d) K0%d_%d\n", i, chapter, i)
		}
		if chapter == 9 {
			fmt.Printf("\t5) K0%d_5\n", chapter)
		}
	} else {
		for i := 1; i <= 4; i++ {
			fmt.Printf("\t%d) K%d_%d\n", i, chapter, i)
		}
	}
}

func main() {
	var choice int
	var choice2 int
	var inputText string

	executable := []IExecutable {
		K01{}, K02{}, K03{}, K04{}, K05{}, K06{}, K07{}, K08{}, K09{}, K10{}, K11{}, FileControl{},
	}

	fmt.Println("実行したいプログラムを選択してください。")
	for i := 1; i <= len(executable); i++ {
		if i < 10 {
			fmt.Println(fmt.Sprintf("%d) K0%d", i, i))
		} else {
			fmt.Println(fmt.Sprintf("%d) K%d", i, i))
		}
	}
	fmt.Println("100) Kex")


	_, _ = fmt.Scanln(&inputText)
	choice, _ = strconv.Atoi(inputText)

	if choice == 100 {
		kex := Kex{}
		kex.Execute()
		return
	} else {
		if choice < 1 || choice > len(executable) {
			fmt.Println("無効の選択です。")
			return
		}

		showSelection(choice)

		_, _ = fmt.Scanln(&inputText)
		choice2, _ = strconv.Atoi(inputText)

		executable[choice - 1].execute(choice2)
	}
}
