package questions

import (
	"fmt"
	"math/rand"
)

type K04 struct {}

func (k K04) question1() {
	fmt.Print("年齢を入力してください。＞")
	var age int
	_, _ = fmt.Scanf("%d", &age)
	if age < 3 || age >= 70 {
		fmt.Println("入場料金無料です。")
	} else {
		fmt.Println("通常料金です。")
	}
}

func (k K04) question2() {
	fmt.Print("性別を選択してください。（０：男性　１：女性）＞")
	var gender int
	_, _ = fmt.Scanf("%d", &gender)
	switch gender {
	case 0:
		fmt.Println("あら、格好良いですね。")
	case 1:
		fmt.Println("あら、モデルさんみたいですね。")
	default:
		fmt.Println("そんな選択肢はありません。")
	}
}

func (k K04) question3() {
	fmt.Print("年齢を入力してください。＞")
	var age int
	_, _ = fmt.Scanf("%d", &age)

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

func (k K04) question4() {
	fmt.Println("＊＊＊おみくじプログラム＊＊＊")
	fmt.Print("おみくじを引きますか　（はい：１　いいえ：０）　＞")
	var choice int
	_, _ = fmt.Scanf("%d", &choice)

	if choice == 0 {
		return
	}

	oracle := rand.Intn(5)

	switch oracle {
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
	default:
		break
	}
}

func (k K04) Execute(number int) {
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

