package main

import (
	"fmt"
	"strconv"
)

type K02 struct {

}

func (k02 K02) question1() {
	seisuu := 3
	var jissuu float32 = 2.6
	moji := "A"

	fmt.Println(fmt.Sprintf("変数seisuuの値は%d", seisuu))
	fmt.Println(fmt.Sprintf("実数jissuuの値は%f", jissuu))
	fmt.Println(fmt.Sprintf("文字mojiの値は%s", moji))
}

func (k02 K02) question2() {
	fmt.Print("一つ目の整数は？")
	var input string
	_, _ = fmt.Scanln(&input)
	var a, _ = strconv.Atoi(input)

	fmt.Print("二つ目の整数は？")
	_, _ = fmt.Scanln(&input)
	var b, _ = strconv.Atoi(input)

	fmt.Println(fmt.Sprintf("%d÷%d=%d...%d", a, b, a / b, a % b))
}

func (k02 K02) question3() {
	fmt.Print("一つ目の商品の値段は？")
	var input string
	_, _ = fmt.Scanln(&input)
	priceA, _ := strconv.Atoi(input)
	fmt.Print("個数は？")
	_, _ = fmt.Scanln(&input)
	amountA, _ := strconv.Atoi(input)

	fmt.Print("二つ目の商品の値段は？")
	_, _ = fmt.Scanln(&input)
	priceB, _ := strconv.Atoi(input)
	fmt.Print("個数は？")
	_, _ = fmt.Scanln(&input)
	amountB, _ := strconv.Atoi(input)

	fmt.Println(fmt.Sprintf("お支払いは税込み￥%fです", float32(priceA * amountA + priceB * amountB) * 1.08))
}

func (k02 K02) question4() {
	golem := Golem{300, 80, 50}

	fmt.Println(fmt.Sprintf("ゴーレム　（HP:%d　防御力：%d）", golem.Hp, golem.Defense))
	fmt.Println(fmt.Sprintf("HP：%d", golem.Hp))
	fmt.Print("今回の攻撃の値を入力してください＞")
	var input string
	_, _ = fmt.Scanln(&input)
	atk, _ := strconv.Atoi(input)

	if atk - golem.Defense < 0 {
		atk = 0
	} else {
		atk -= golem.Defense
	}
	fmt.Println(fmt.Sprintf("ダメージは%dです。", atk))
	golem.Hp -= atk
	fmt.Println(fmt.Sprintf("残りのHPは%dです。", golem.Hp))
}

func (k02 K02) execute(num int) {
	switch num {
	case 1:
		k02.question1()
	case 2:
		k02.question2()
	case 3:
		k02.question3()
	case 4:
		k02.question4()
	}
}