package main

import (
	"fmt"
	"strconv"
)

type K07 struct {}

func (k07 K07) showText() {
	fmt.Println("Hello World!")
	fmt.Println("ようこそ")
	fmt.Println("Go言語の世界へ！")
}

func (k07 K07) getMaxValue(value1 int, value2 int, value3 int) int {
	var temp int
	if value1 >= value2 {
		temp = value1
	} else {
		temp = value2
	}

	if temp < value3 {
		temp = value3
	}

	return temp
}

func (k07 K07) getType(age int) int {
	if age <= 0 {
		return 0
	} else if age < 3 || age >= 70 {
		return 1
	} else if age >= 3 && age <= 15 {
		return 2
	} else if age >= 60 && age < 70 {
		return 3
	} else {
		return 4
	}
}

func (k07 K07) execute(num int) {
	switch num {
	case 1: k07.question1()
	case 2: k07.question2()
	case 3: k07.question3()
	case 4: k07.question4()
	}
}

func (k07 K07) question1() {
	choice := 1
	for choice != 0 {
		fmt.Print("メッセージを表示しますか？（０：終了する　１：表示する）＞")
		var input string
		_, _ = fmt.Scanln(&input)
		choice, _ = strconv.Atoi(input)
		if choice == 1 {
			k07.showText()
		}
	}
	fmt.Println("終了します。")
}

func (k07 K07) question2() {
	var numbers []int
	for i := 0; i < 3; i++ {
		fmt.Print(fmt.Sprintf("%dつ目の値を入力してください。＞", i + 1))
		var input string
		_, _ = fmt.Scanln(&input)
		_num, _ := strconv.Atoi(input)
		numbers = append(numbers, _num)
	}

	var maxValue = k07.getMaxValue(numbers[0], numbers[1], numbers[2])
	fmt.Println(fmt.Sprintf("%dつの中で最大値は%dです。", len(numbers), maxValue))
}

func (k07 K07) question3() {
	var age int
	var no int
	fmt.Print("年齢を入力して下さい。＞")
	var input string
	_, _ = fmt.Scanln(&input)
	age, _ = strconv.Atoi(input)

	no = k07.getType(age)
	switch no {
	case 0: fmt.Println("不適切な値が入力されました。")
	case 1: fmt.Println("入場料金無料です。")
	case 2: fmt.Println("子供料金で半額です。")
	case 3: fmt.Println("シニア割引で一割引きです。")
	default: fmt.Println("通常料金です。")
	}
}

func (k07 K07) question4() {
	return
}



