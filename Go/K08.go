package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

type K08 struct {}

func (k08 K08) execute(num int) {
	switch num {
	case 1: k08.question1()
	case 2: k08.question2()
	case 3: k08.question3()
	case 4: k08.question4()
	}
}

func (k08 K08) question1() {
	var numbers []int
	var inputString string

	for i := 0; i < 3; i++ {
		fmt.Println(fmt.Sprintf("%dつ目の値を入力してください。＞", i + 1))
		_, _ = fmt.Scanln(&inputString)
		_num, _ := strconv.Atoi(inputString)
		numbers = append(numbers, _num)
	}

	fmt.Println("どちらを調べますか？")
	fmt.Print("（０：最大値　１：最小値）＞")
	_, _ = fmt.Scanln(&inputString)
	choice, _ := strconv.Atoi(inputString)

	switch choice {
	case 0:
		fmt.Println(fmt.Sprintf("%dの中で最大値は%dです。",
			len(numbers), getMaxValue(numbers[0], numbers[1], numbers[2])))
	case 1:
		fmt.Println(fmt.Sprintf("%dの中で最小値は%dです。",
			len(numbers), getMinValue(numbers[0], numbers[1], numbers[2])))
	}
}

func (k08 K08) question2() {
	fmt.Println("冒険が今始まる！")
	playerHp := 200 + rand.Intn(101)
	continueGame := 1
	var inputString string

	for continueGame != 0 {
		if playerHp == 0 {
			return
		}
		fmt.Println(fmt.Sprintf("あなたのHP：%d", playerHp))
		fmt.Print("奥に進みますか？（１：奥に進む　０．帰る）＞")
		_, _ = fmt.Scanln(&inputString)
		continueGame, _ = strconv.Atoi(inputString)
		if continueGame == 1 {
			golemLv := rand.Intn(5)
			attackGolem(golemLv, &playerHp)
		}
	}
	fmt.Println("リレ〇ト！")
}

func (k08 K08) question3() {
	return
}

func (k08 K08) question4() {
	return
}

