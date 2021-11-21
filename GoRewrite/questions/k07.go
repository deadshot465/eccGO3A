package questions

import (
	"GoRewrite/shared/utility"
	"fmt"
)

type K07 struct {}

func (k K07) question1() {
	var choice int
	for {
		fmt.Println("メッセージを表示しますか？（０：終了する　１：表示する）＞")
		_, _ = fmt.Scanf("%d", &choice)
		if choice == 1 {
			showTexts()
		} else if choice == 0 {
			break
		}
	}
	fmt.Println("終了します。")
}

func (k K07) question2() {
	var numbers []int
	for i := 0; i < 3; i++ {
		fmt.Printf("%dつ目の値を入力してください。＞", i + 1)
		var input int
		_, _ = fmt.Scanf("%d", &input)
		numbers = append(numbers, input)
	}
	count := len(numbers)
	fmt.Printf("%dつの中で最大値は%dです。", count, utility.FindMaxValue(numbers))
}

func (k K07) question3() {
	var age int
	fmt.Print("年齢を入力して下さい。＞")
	_, _ = fmt.Scanf("%d", &age)
	fmt.Println(getAgeMessage(age))
}

func (k K07) question4() {
	return
}

func (k K07) Execute(number int) {
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

func showTexts() {
	fmt.Println("Hello World!")
	fmt.Println("ようこそ")
	fmt.Println("Go言語の世界へ！")
}

func getAgeMessage(age int) string {
	if age < 3 || age >= 70 {
		return "入場料金無料です。"
	} else if age >= 3 && age <= 15 {
		return "子供料金で半額です。"
	} else if age >= 60 && age < 70 {
		return "シニア割引で一割引きです。"
	} else {
		return "通常料金です。"
	}
}