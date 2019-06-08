package main

import (
	"fmt"
	"math"
	"math/rand"
	"sort"
	"strconv"
)

type K12 struct {}

type Person struct {
	Name string
	BirthYear int
	Height float32
	Weight float32
}

type Staff struct {
	Name string
	Gender uint8
	Age int
}

func newStaff(name string, gender uint8, age int) *Staff {
	_staff := new(Staff)
	_staff.Name = name
	_staff.Gender = gender
	_staff.Age = age
	return _staff
}

type Position struct {
	X int
	Y int
	Distance float64
}

func (k12 K12) execute(num int) {
	switch num {
	case 1: k12.question1()
	case 2: k12.question2()
	case 3: k12.question3()
	case 4: k12.question4()
	}
}

func (k12 K12) question1() {
	var person Person
	fmt.Print("名前を入力してください＞")
	_, _ = fmt.Scanln(&person.Name)
	fmt.Print("生年（西暦）を入力してください＞")
	var reader string
	_, _ = fmt.Scanln(&reader)
	person.BirthYear, _ = strconv.Atoi(reader)
	fmt.Print("身長を入力してください＞")
	_, _ = fmt.Scanln(&reader)
	num, _ := strconv.ParseFloat(reader, 32)
	person.Height = float32(num)
	fmt.Print("体重を入力してください＞")
	_, _ = fmt.Scanln(&reader)
	num, _ = strconv.ParseFloat(reader, 32)
	person.Weight = float32(num)

	fmt.Println("プロファイル")
	fmt.Printf("名前：%s\n", person.Name)
	fmt.Printf("生年：%d\n", person.BirthYear)
	fmt.Printf("身長：%.1f\n", person.Height)
	fmt.Printf("体重：%.1f\n", person.Weight)
}

func (k12 K12) question2() {
	staffs := [3]*Staff{
		newStaff("神木隆之介", 'M', 23),
		newStaff("上白石萌音", 'F', 18),
		newStaff("長澤まさみ", 'F', 28),
	}

	fmt.Println("名前\t\t性別\t年齢")
	for i := 0; i < 35; i++ {
		fmt.Print("-")
	}
	fmt.Println()

	for i := 0; i < len(staffs); i++ {
		fmt.Printf("%s\t%c\t%d歳\n", staffs[i].Name, staffs[i].Gender, staffs[i].Age)
	}
}

func getDistance(playerPos Position, enemyPos Position) float64 {
	diffX := playerPos.X - enemyPos.X
	diffY := playerPos.Y - enemyPos.Y
	return math.Sqrt(float64(diffX * diffX + diffY * diffY))
}

func (k12 K12) question3() {
	getRandomNumber := func() int {
		return rand.Intn(101) - 50
	}

	playerPos := Position{
		getRandomNumber(),
		getRandomNumber(),
		0.0,
	}

	var enemyPos []Position
	for i := 0; i < 5; i++ {
		pos := Position{
			getRandomNumber(),
			getRandomNumber(),
			0.0,
		}
		pos.Distance = getDistance(playerPos, pos)
		enemyPos = append(enemyPos, pos)
	}

	fmt.Printf("プレーヤーの座標：x= %d\t\ty= %d\n", playerPos.X, playerPos.Y)
	for i := 0; i < len(enemyPos); i++ {
		fmt.Printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
			i, float32(enemyPos[i].X), float32(enemyPos[i].Y), enemyPos[i].Distance)
	}
}

func (k12 K12) question4() {
	getRandomNumber := func() int {
		return rand.Intn(101) - 50
	}

	playerPos := Position{
		getRandomNumber(),
		getRandomNumber(),
		0.0,
	}

	var enemyPos []Position
	for i := 0; i < 5; i++ {
		pos := Position{
			getRandomNumber(),
			getRandomNumber(),
			0.0,
		}
		pos.Distance = getDistance(playerPos, pos)
		enemyPos = append(enemyPos, pos)
	}

	fmt.Printf("プレーヤーの座標：x= %d\t\ty= %d\n", playerPos.X, playerPos.Y)
	for i := 0; i < len(enemyPos); i++ {
		fmt.Printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
			i, float32(enemyPos[i].X), float32(enemyPos[i].Y), enemyPos[i].Distance)
	}

	sort.Slice(enemyPos, func(i, j int) bool {
		return enemyPos[i].Distance < enemyPos[j].Distance
	})

	fmt.Println("\n並び替え後")
	for i := 0; i < len(enemyPos); i++ {
		fmt.Printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離= %5.2f\n",
			i, float32(enemyPos[i].X), float32(enemyPos[i].Y), enemyPos[i].Distance)
	}
}

