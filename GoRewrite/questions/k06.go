package questions

import (
	"fmt"
	"strings"
)

type K06 struct {}

func (k K06) question1() {
	var ages []int
	for i := 0; i < 5; i++ {
		fmt.Printf("%d人目の年齢を入力して下さい：", i + 1)
		var input int
		_, _ = fmt.Scanf("%d", &input)
		ages = append(ages, input)
	}
	count := len(ages)
	var totalAges float32
	for _, age := range ages {
		totalAges += float32(age)
	}
	fmt.Printf("%d人の平均年齢は%fです。", count, totalAges / float32(count))
}

func (k K06) question2() {
	for i := 0; i < 8; i++ {
		for j := 0; j < i + 1; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
	fmt.Println()

	for i := 8; i > 0; i-- {
		for j := 0; j < i; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
	fmt.Println()

	for i := 8; i > 0; i-- {
		for j := 0; j < i - 1; j++ {
			fmt.Print(" ")
		}

		for k := 8; k > i - 1; k-- {
			fmt.Print("*")
		}
		fmt.Println()
	}
	fmt.Println()
}

func (k K06) question3() {
	total := 370
	count := 0

	for i := 0; i <= total / 100; i++ {
		for j := 0; j <= total / 50; j++ {
			for k := 0; k <= total / 10; k++ {
				if i * 100 + j * 50 + k * 10 != total {
					continue
				}
				fmt.Printf("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚\n", k, j, i)
				count += 1
			}
		}
	}
	fmt.Printf("\n以上%d通りを発見しました。", count)
}

func (k K06) question4() {
	fmt.Print("\t|\t")
	for i := 1; i < 10; i++ {
		fmt.Printf("%d\t", i)
	}
	fmt.Println()
	fmt.Println(strings.Repeat("-", 90))
	for i := 1; i < 10; i++ {
		fmt.Printf("%d\t|\t", i)
		for j := 1; j < 10; j++ {
			fmt.Printf("%d\t", i * j)
		}
		fmt.Println()
	}
}

func (k K06) Execute(number int) {
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