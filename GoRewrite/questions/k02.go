package questions

import (
	"GoRewrite/shared"
	"fmt"
)

type K02 struct {}

func (k K02) question1() {
	seisuu := 3
	jissuu := 2.6
	moji := 'A'
	fmt.Printf("変数seisuuの値は%d\n", seisuu)
	fmt.Printf("実数jissuuの値は%f", jissuu)
	fmt.Printf("文字mojiの値は%c\n", moji)
}

func (k K02) question2() {
	fmt.Print("一つ目の整数は？")
	var number1 int
	_, _ = fmt.Scanf("%d", &number1)
	fmt.Print("二つ目の整数は？")
	var number2 int
	_, _ = fmt.Scanf("%d", &number2)
	fmt.Printf("%d ÷ %d = %d ... %d", number1, number2, number1 / number2, number1 % number2)
}

func (k K02) question3() {
	fmt.Print("一つ目の商品の値段は？")
	var priceA float32
	_, _ = fmt.Scanf("%f", &priceA)
	fmt.Print("個数は？")
	var amountA float32
	_, _ = fmt.Scanf("%f", &amountA)

	fmt.Print("二つ目の商品の値段は？")
	var priceB float32
	_, _ = fmt.Scanf("%f", &priceB)
	fmt.Print("個数は？")
	var amountB float32
	_, _ = fmt.Scanf("%f", &amountB)

	total := (priceA * amountA + priceB * amountB) * 1.1
	fmt.Printf("お支払いは税込み￥%fです", total)
}

func (k K02) question4() {
	golem := shared.Golem{
		Hp:      300,
		Defense: 80,
		Attack:  50,
	}

	fmt.Printf("ゴーレム　（HP:%d　防御力：%d）\n", golem.Hp, golem.Defense)
	fmt.Printf("HP：%d\n", golem.Hp)
	fmt.Print("今回の攻撃の値を入力してください＞")
	var attack int
	_, _ = fmt.Scanf("%d", &attack)

	if attack - golem.Defense <= 0 {
		attack = 0
	} else {
		attack = attack - golem.Defense
	}

	fmt.Printf("ダメージは%dです。\n", attack)
	fmt.Printf("残りのHPは%dです。\n", golem.Hp - attack)
}

func (k K02) Execute(number int) {
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

