package main

import (
	"RecursiveGo/questions"
	"RecursiveGo/shared"
)

func main() {
	executables := []shared.Executable {
		questions.K01{}, questions.K02{}, questions.K03{},
		questions.K04{}, questions.K05{}, questions.K06{},
	}
	executables[5].Execute(4)
}
