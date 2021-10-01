package questions

import (
	"fmt"
	"math/rand"
)

type K03 struct {}

func (k K03) question1() {
	fmt.Print("年齢を入力してください。＞")
	var age int
	_, _ = fmt.Scanf("%d", &age)
	if age < 20 {
		fmt.Println("未成年なので購入できません。")
	}
}

func (k K03) question2() {
	fmt.Print("身長を入力してください。＞")
	var height float32
	_, _ = fmt.Scanf("%f", &height)
	height /= 100.0

	fmt.Print("体重を入力してください。＞")
	var weight float32
	_, _ = fmt.Scanf("%f", &weight)

	standard := height * height * 22.0
	fmt.Printf("あなたの標準体重は%fです。\n", standard)

	if weight > standard && (weight - standard) / standard * 100.0 >= 14.0 {
		fmt.Println("太り気味です。")
	} else if weight < standard && (weight - standard) / standard * 100.0 <= -14.0 {
		fmt.Println("痩せ気味です。")
	} else {
		fmt.Println("普通ですね。")
	}
}

func (k K03) question3() {
	randomNumber := rand.Intn(100)
	fmt.Println("０から９９の範囲の数値が決定されました。")
	fmt.Print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")

	var guess int
	_, _ = fmt.Scanf("%d", &guess)
	fmt.Printf("決められた数値は%dです\n", randomNumber)
	if guess > randomNumber {
		fmt.Println("正解です。")
	} else {
		fmt.Println("不正解です。")
	}
}

func (k K03) question4() {
	randomNumber := rand.Intn(100)
	fmt.Println("０から９９の範囲の数値が決定されました。")
	fmt.Print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")

	var guess int
	_, _ = fmt.Scanf("%d", &guess)
	fmt.Printf("決められた数値は%dです\n", randomNumber)
	if guess < 0 || guess >= 100 {
		fmt.Println("反則です！")
	} else if guess > randomNumber && guess - randomNumber <= 10 {
		fmt.Println("大正解です！")
	} else if guess < randomNumber && randomNumber - guess <= 10 {
		fmt.Println("惜しい！")
	} else if guess == randomNumber {
		fmt.Println("お見事！")
	} else {
		if guess > randomNumber {
			fmt.Println("正解です。")
		} else {
			fmt.Println("不正解です。")
		}
	}
}

func (k K03) Execute(number int) {
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

