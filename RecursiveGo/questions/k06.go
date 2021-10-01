package questions

import (
	"fmt"
	"strings"
)

type K06 struct {}

func (k K06) question1() {
	ages := getAges()
	count := len(ages)
	totalAges := reduceInt(ages, 0)
	fmt.Printf("%d人の平均年齢は%fです。", count, float32(totalAges) / float32(count))
}

func (k K06) question2() {
	var acc []string
	fmt.Println(strings.Join(buildPyramid(0, 8, acc), "\n"))

	fmt.Println("")

	acc = []string {}
	var newAcc []string
	fmt.Println(strings.Join(reverseString(buildPyramid(0, 8, acc), newAcc), "\n"))

	fmt.Println("")
	acc = []string {}
	fmt.Println(strings.Join(buildSpecialPyramid(0, 8, acc), "\n"))
}

func (k K06) question3() {
	var acc []string
	result := mapCombinations(countCombinations(370), acc)
	count := len(result)
	fmt.Println(strings.Join(result, "\n"))
	fmt.Printf("\n以上%d通りを発見しました。\n", count)
}

func (k K06) question4() {

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

func inputAge(no int, amount int, acc []int) []int {
	if amount == 0 {
		return acc
	}

	fmt.Printf("%d人目の年齢を入力して下さい：", no + 1)
	var input int
	_, _ = fmt.Scanf("%d", &input)
	return inputAge(no + 1, amount - 1, append(acc, input))
}

func getAges() []int {
	var ages []int
	return inputAge(0, 5, ages)
}

func reduceInt(arr []int, acc int) int {
	if len(arr) == 0 {
		return acc
	}
	return reduceInt(arr[1:], acc + arr[0])
}

func reverseString(arr []string, acc []string) []string {
	if len(arr) == 0 {
		return acc
	}
	return reverseString(arr[:len(arr) - 1], append(acc, arr[len(arr) - 1]))
}

func buildPyramid(current int, levels int, acc []string) []string {
	if levels == 0 {
		return acc
	}
	return buildPyramid(current + 1, levels - 1, append(acc, strings.Repeat("*", current + 1)))
}

func buildSpecialPyramid(amountOfStars int, amountOfSpaces int, acc []string) []string {
	if amountOfSpaces == 0 {
		return acc
	}

	starLine := strings.Repeat(" ", amountOfSpaces - 1) + strings.Repeat("*", amountOfStars + 1)
	return buildSpecialPyramid(amountOfStars + 1, amountOfSpaces - 1, append(acc, starLine))
}

func countFiftiesAndTens(amount int, remains int, acc [][]int) [][]int {
	if amount < 0 {
		return acc
	}
	tens := (remains - (50 * amount)) / 10
	pair := []int { amount, tens }
	return countFiftiesAndTens(amount - 1, remains, append(acc, pair))
}

func mapHundreds(hundreds int, acc [][]int, newAcc [][]int) [][]int {
	if len(acc) == 0 {
		return newAcc
	}
	triple := []int { hundreds, acc[0][0], acc[0][1] }
	return mapHundreds(hundreds, acc[1:], append(newAcc, triple))
}

func concatArray(arr1 [][]int, arr2 [][]int) [][]int {
	if len(arr2) == 0 {
		return arr1
	}
	return concatArray(append(arr1, arr2[0]), arr2[1:])
}

func countHundreds(amount int, remains int, acc [][]int) [][]int {
	if amount < 0 {
		return acc
	}
	remaining := remains - (100 * amount)
	var newAcc [][]int
	fiftiesAndTens := countFiftiesAndTens(remaining / 50, remaining, newAcc)
	var finalAcc [][]int
	result := mapHundreds(amount, fiftiesAndTens, finalAcc)
	return countHundreds(amount - 1, remains, concatArray(acc, result))
}

func countCombinations(amount int) [][]int {
	var acc [][]int
	return countHundreds(amount / 100, amount, acc)
}

func mapCombinations(result [][]int, acc []string) []string {
	if len(result) == 0 {
		return acc
	}
	item := result[0]
	text := fmt.Sprintf("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨%d枚\n", item[2], item[1], item[0])
	return mapCombinations(result[1:], append(acc, text))
}