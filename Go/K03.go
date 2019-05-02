package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

type K03 struct {

}

func (k03 K03) question1() {
	fmt.Print("年齢を入力してください。＞")
	var input string
	_, _ = fmt.Scanln(&input)
	age, _ := strconv.Atoi(input)

	if age < 20 {
		fmt.Println("未成年なので購入できません。")
	}
}

func (k03 K03) question2() {
	fmt.Print("身長を入力してください。＞")
	var input string
	_, _ = fmt.Scanln(&input)
	_result, _ := strconv.Atoi(input)
	height := float32(_result)
	height /= 100.0

	fmt.Print("体重を入力してください。＞")
	_, _ = fmt.Scanln(&input)
	_result, _ = strconv.Atoi(input)
	weight := float32(_result)

	standard := height * height * 22.0
	fmt.Println(fmt.Sprintf("あなたの標準体重は%fです。", standard))

	if weight > standard && (weight - standard) / standard * 100.0 > 14.0 {
		fmt.Println("太り気味です。")
	} else if weight < standard && (weight - standard) / standard * 100.0 < -14.0 {
		fmt.Println("痩せ気味です。")
	} else {
		fmt.Println("普通ですね。")
	}
}

func (k03 K03) question3() {
	randomNumber := rand.Intn(100)
	fmt.Println("０から９９の範囲の数値が決定されました。")
	fmt.Print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")

	var input string
	_, _ = fmt.Scanln(&input)
	guess, _ := strconv.Atoi(input)

	fmt.Println(fmt.Sprintf("決められた数値は%dです", randomNumber))
	if guess > randomNumber {
		fmt.Println("正解です。")
	} else {
		fmt.Println("不正解です。")
	}
}

func (k03 K03) question4() {
	randomNumber := rand.Intn(100)
	fmt.Println("０から９９の範囲の数値が決定されました。")
	fmt.Print("決められた数値を予想し、この数値よりも大きな値を入力してください＞")

	var input string
	_, _ = fmt.Scanln(&input)
	guess, _ := strconv.Atoi(input)

	fmt.Println(fmt.Sprintf("決められた数値は%dです", randomNumber))

	if guess > 100 || guess < 0 {
		fmt.Println("反則です！")
	} else if guess > randomNumber && guess - randomNumber <= 10 {
		fmt.Println("大正解です！")
	} else if guess < randomNumber && guess - randomNumber >= -10 {
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

func (k03 K03) execute(num int) {
	switch num {
	case 1:
		k03.question1()
	case 2:
		k03.question2()
	case 3:
		k03.question3()
	case 4:
		k03.question4()
	}
}