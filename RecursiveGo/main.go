package main

import (
	"RecursiveGo/questions"
	"RecursiveGo/shared"
	"RecursiveGo/shared/utility"
	"fmt"
	"strings"
)

func showExecutables(executables []shared.Executable, index int) []string {
	var acc []string
	return utility.ReverseString(innerShowExecutables(executables, index, acc))
}

func innerShowExecutables(executables []shared.Executable, index int, acc []string) []string {
	if len(executables) == 0 {
		return acc
	}
	prefix := "K0"
	if index >= 10 {
		prefix = "K"
	}
	text := fmt.Sprintf("%d) %s%d\t\t", index, prefix, index)
	return innerShowExecutables(executables[1:], index - 1, append(acc, text))
}

func showSelections(chapter int, index int) []string {
	var acc []string
	return utility.ReverseString(innerShowSelection(chapter, index, acc))
}

func innerShowSelection(chapter int, index int, acc []string) []string {
	if index == 0 {
		return acc
	}
	prefix := "K0"
	if chapter >= 10 {
		prefix = "K"
	}
	text := fmt.Sprintf("\t%d) %s%d_%d", index, prefix, chapter, index)
	return innerShowSelection(chapter, index - 1, append(acc, text))
}

func main() {
	executables := []shared.Executable {
		questions.K01{}, questions.K02{}, questions.K03{},
		questions.K04{}, questions.K05{}, questions.K06{},
	}

	fmt.Println("実行したいプログラムを選択してください。")
	fmt.Println(strings.Join(showExecutables(executables, len(executables)), ""))
	fmt.Println("")
	var choice int
	_, _ = fmt.Scanf("%d", &choice)
	fmt.Println(strings.Join(showSelections(choice, 4), "\n"))
	var choice2 int
	_, _ = fmt.Scanf("%d", &choice2)
	executables[choice - 1].Execute(choice2)
}
