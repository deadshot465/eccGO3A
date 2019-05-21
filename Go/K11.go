package main

import (
	"fmt"
	"strconv"
	"unicode"
)

type K11 struct {}

func (k11 K11) execute(num int) {
	switch num {
	case 1: k11.question1()
	case 2: k11.question2()
	case 3: k11.question3()
	case 4: k11.question4()
	}
}

func (k11 K11) question1() {
	var ages []float32
	maxPeople := 5

	for i := 0; i < maxPeople; i++ {
		fmt.Printf("%d人目の年齢を入力して下さい：", i + 1)
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
	fmt.Printf("%d人の平均年齢は%.1fです。\n", len(ages), average)
}

func (k11 K11) question2() {
	fmt.Print("1つ目の文字列を入力して下さい。＞")
	var str1 string
	_, _ = fmt.Scanln(&str1)
	fmt.Print("2つ目の文字列を入力して下さい。＞")
	var str2 string
	_, _ = fmt.Scanln(&str2)
	str1 += str2
	fmt.Printf("%sの文字数は%dです。\n", str1, len(str1))
}

func (k11 K11) question3() {
	var chr int32
	fmt.Print("文字を入力して下さい。＞")
	_, _ = fmt.Scanf("%c", &chr)
	applied := false

	if unicode.IsDigit(chr) {
		fmt.Println("この文字は数字です。")
		applied	= true
	}
	if unicode.IsUpper(chr) {
		fmt.Println("この文字は英大文字です。")
		applied = true
	}
	if unicode.IsLower(chr) {
		fmt.Println("この文字は英小文字です。")
		applied = true
	}
	_, err := strconv.ParseInt(strconv.Itoa(int(chr)), 16, 64)
	if err == nil {
		fmt.Println("この文字は16進数として使える文字です。")
		applied = true
	}
	if unicode.IsPunct(chr) {
		fmt.Println("この文字は区切り文字です。")
		applied = true
	}
	if !applied {
		fmt.Println("この文字はよくわからない文字です。")
	}
}

func (k11 K11) question4() {
	alphabets := "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	inputStr := "I am a STUDENT. I am good at GAME PROGRAMMING."

	count := 0
	_count := 0

	fmt.Println(fmt.Sprintf("文字列：%s\n", inputStr))
	fmt.Println("文字頻度")
	for i := 0; i < len(alphabets); i++ {
		for j := 0; j < len(inputStr); j++ {
			_s := unicode.ToUpper(rune(inputStr[j]))
			if alphabets[i] == uint8(_s) {
				count++
			}
		}
		fmt.Print(fmt.Sprintf("%c: %d\t", alphabets[i], count))
		count = 0
		_count++
		if _count % 4 == 0 {
			fmt.Println()
		}
	}
}


