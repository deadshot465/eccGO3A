package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

type K04 struct {

}

func (k04 K04) question1() {
	fmt.Print("年齢を入力してください。＞")
	var input string
	_, _ = fmt.Scanln(&input)
	age, _ := strconv.Atoi(input)

	if age < 3 || age >= 70 {
		fmt.Println("入場料金無料です。")
	} else {
		fmt.Println("通常料金です。")
	}
}

func (k04 K04) question2() {
	fmt.Print("性別を選択してください。（０：男性　１：女性）＞")
	var input string
	_, _ = fmt.Scanln(&input)
	var choice, _ = strconv.Atoi(input)

	switch choice {
	case 0:
		fmt.Println("あら、格好良いですね。")
	case 1:
		fmt.Println("あら、モデルさんみたいですね。")
	default:
		fmt.Println("そんな選択肢はありません。")
	}
}

func (k04 K04) question3() {
	fmt.Print("年齢を入力してください。＞")
	var input string
	_, _ = fmt.Scanln(&input)
	age, _ := strconv.Atoi(input)

	if age < 3 || age >= 70 {
		fmt.Println("入場料金無料です。")
	} else if age >= 3 && age <= 15 {
		fmt.Println("子供料金で半額です。")
	} else if age >= 60 && age < 70 {
		fmt.Println("シニア割引で一割引きです。")
	} else {
		fmt.Println("通常料金です。")
	}
}

func (k04 K04) question4() {
	fmt.Println("＊＊＊おみくじプログラム＊＊＊")
	fmt.Print("おみくじを引きますか　（はい：１　いいえ：０）　＞")
	var input string
	_, _ = fmt.Scanln(&input)
	choice, _ := strconv.Atoi(input)

	if choice >= 1 {
		randNumber := rand.Intn(5)
		switch randNumber {
		case 0:
			fmt.Println("大吉　とってもいいことがありそう！！")
		case 1:
			fmt.Println("中吉　きっといいことあるんじゃないかな")
		case 2:
			fmt.Println("小吉　少しぐらいはいいことあるかもね")
		case 3:
			fmt.Println("凶　今日はおとなしくておいた方がいいかも")
		case 4:
			fmt.Println("大凶　これじゃやばくない？早く家に帰った方がいいかも")
		}
	}
}

func (k04 K04) execute(num int) {
	switch num {
	case 1:
		k04.question1()
	case 2:
		k04.question2()
	case 3:
		k04.question3()
	case 4:
		k04.question4()
	}
}