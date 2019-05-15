package main

import (
	"fmt"
	"sort"
	"strconv"
)

type K09 struct {}

func (k09 K09) execute(num int) {
	switch num {
	case 1: k09.question1()
	case 2: k09.question2()
	case 3: k09.question3()
	case 4: k09.question4()
	case 5: k09.question5()
	}
}

func (k09 K09) question1() {
	var ages [3]int
	var inputString string
	for i := 0; i < 3; i++ {
		fmt.Print(fmt.Sprintf("%d人目の年齢を入力＞", i + 1))
		_, _ = fmt.Scanln(&inputString)
		ages[i], _ = strconv.Atoi(inputString)
	}

	for i := 0; i < 25; i++ {
		fmt.Print("-")
	}
	fmt.Println()

	var average float32
	for i := 0; i < 3; i++ {
		fmt.Println(fmt.Sprintf("%d人目：%d歳", i + 1, ages[i]))
		average += float32(ages[i])
	}
	fmt.Println(fmt.Sprintf("平均年齢：%.1f", average / 3.0))
}

func (k09 K09) question2() {
	numbers := [5]int{8, 3, 12, 7, 9}
	fmt.Print("元々の配列：")
	for i := 0; i < len(numbers); i++ {
		fmt.Print(fmt.Sprintf("%d ", numbers[i]))
	}
	fmt.Println()

	fmt.Print("逆順での表示：")
	for i := len(numbers) - 1; i >= 0; i-- {
		fmt.Print(fmt.Sprintf("%d ", numbers[i]))
	}
}

func (k09 K09) question3() {
	studentScore := [3][4]int{
		{52, 71, 61, 47},
		{6, 84, 81, 20},
		{73, 98, 94, 95},
	}
	fmt.Println("\t\t|\t科目A\t科目B\t科目C\t科目D")
	for i := 0; i < 45; i++ {
		fmt.Print("-")
	}
	fmt.Println()

	for i := 0; i < len(studentScore); i++ {
		fmt.Print(fmt.Sprintf("学生%d\t|\t", i + 1))
		for j := 0; j < len(studentScore[i]); j++ {
			fmt.Print(fmt.Sprintf("%d\t\t", studentScore[i][j]))
		}
		fmt.Println()
	}
}

func (k09 K09) question4() {
	studentScore := [3][4]int{
		{52, 71, 61, 47},
		{6, 84, 81, 20},
		{73, 98, 94, 95},
	}

	total := 0
	var average = [4]float32{0.0, 0.0, 0.0, 0.0}

	fmt.Println("\t\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点")
	for i := 0; i < 65; i++ {
		fmt.Print("-")
	}
	fmt.Println()

	for i := 0; i < len(studentScore); i++ {
		fmt.Print(fmt.Sprintf("学生%d\t|\t", i + 1))
		for j := 0; j < len(studentScore[i]); j++ {
			fmt.Print(fmt.Sprintf("%d\t\t", studentScore[i][j]))
			total += studentScore[i][j]
			average[j] += float32(studentScore[i][j])
		}
		fmt.Print(fmt.Sprintf("|\t%d", total))
		total = 0
		fmt.Println()
	}
	fmt.Print("平均点\t|\t")
	for i := 0; i < len(average); i++ {
		fmt.Print(fmt.Sprintf("%.1f\t", average[i] / 3.0))
	}
	fmt.Println("|")
}

func (k09 K09) question5() {
	count := 0
	var numbers []int
	var inputString string

	for i := 0; i < 100; i++ {
		fmt.Print(fmt.Sprintf("%d件目の入力：", i + 1))
		_, _ = fmt.Scanln(&inputString)
		result, _ := strconv.Atoi(inputString)
		numbers = append(numbers, result)
		if numbers[count] < 0	 {
			break
		}
		count++
	}
	fmt.Println("----並び替え後----")
	numSlice := numbers[:count]
	sort.Ints(numSlice)

	for i := 0; i < len(numSlice); i++ {
		fmt.Println(fmt.Sprintf("%d", numSlice[i]))
	}
}

