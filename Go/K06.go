package main

import (
	"fmt"
	"strconv"
)

type K06 struct {

}

func (k06 K06) question1() {
	var ages []float32
	for i := 0; i < 5; i++ {
		fmt.Print(fmt.Sprintf("%d人目の年齢を入力して下さい：", i + 1))
		var input string
		_, _ = fmt.Scanln(&input)
		age, _ := strconv.Atoi(input)
		ages = append(ages, float32(age))
	}

	var average float32
	for i := 0; i < len(ages); i++ {
		average += ages[i]
	}
	average /= float32(len(ages))
	fmt.Println(fmt.Sprintf("%d人の平均年齢は%fです。", len(ages), average))
}

func (k06 K06) question2() {
	for i := 0; i < 9; i++ {
		for j := 0; j < i+1; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
	fmt.Println()

	for i := 9; i > 0 ; i--  {
		for j := 0; j < i; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
	fmt.Println()

	for i := 9; i > 0; i-- {
		for j := 0; j < i-1; j++ {
			fmt.Print(" ")
		}

		for k := 9; k > i-1; k-- {
			fmt.Print("*")
		}
		fmt.Println()
	}
}

func (k06 K06) question3() {
	total := 370
	var count int

	for i := 0; i <= total/100; i++ {
		for j := 0; j <= total/50; j++ {
			for k := 0; k <= total/10; k++ {
				if 100*i+50*j+10*k == total {
					fmt.Println(fmt.Sprintf("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚", k, j, i))
					count++
				}
			}
		}
	}

	fmt.Println(fmt.Sprintf("\n以上%d通りを発見しました。", count))
}

func (k06 K06) question4() {
	fmt.Print("\t|\t")
	for i := 1; i < 10; i++ {
		fmt.Print(fmt.Sprintf("%d\t", i))
	}
	fmt.Println()

	for i := 0; i < 76; i++ {
		fmt.Print("-")
	}
	fmt.Println()

	for i := 1; i < 10; i++ {
		fmt.Print(fmt.Sprintf("%d\t|\t", i))
		for j := 1; j < 10; j++ {
			fmt.Print(fmt.Sprintf("%d\t", i * j))
		}
		fmt.Println()
	}
}

func (k06 K06) execute(num int) {
	switch num {
	case 1:
		k06.question1()
	case 2:
		k06.question2()
	case 3:
		k06.question3()
	case 4:
		k06.question4()
	}
}