package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

type K05 struct {

}

func (k05 K05) question1() {
	age := 22
	salary := 19.0

	for salary < 50.0 {
		salary *= 1.035
		age += 1
	}

	fmt.Println(fmt.Sprintf("%d歳で月給%f万円", age, salary))
}

func (k05 K05) question2() {
	choice := 0

	for choice != 1 {
		fmt.Println("起きろ～")
		fmt.Print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
		var input string
		_, _ = fmt.Scanln(&input)
		choice, _ = strconv.Atoi(input)
	}
	fmt.Println("よし、学校へ行こう！")
}

func (k05 K05) question3() {
	choice := 0

	for true {
		fmt.Println("起きろ～")
		fmt.Print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
		var input string
		_, _ = fmt.Scanln(&input)
		choice, _ = strconv.Atoi(input)
		if choice == 1 {
			fmt.Println("よし、学校へ行こう！")
		}
	}
}

func (k05 K05) question4() {
	golem := Golem{300 + rand.Intn(201), 80, 50}
	player_hp := 200 + rand.Intn(101)

	fmt.Println(fmt.Sprintf("ゴーレム　（HP:%d　防御力：%d）", golem.Hp, golem.Defense))
	for golem.Hp > 0 {
		fmt.Println(fmt.Sprintf("残りHP：%d", golem.Hp))
		fmt.Print("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞")
		var input string
		_, _ = fmt.Scanln(&input)
		choice, _ := strconv.Atoi(input)
		var atk int

		switch choice {
		case 1:
			atk = 60 + rand.Intn(41)
		case 2:
			atk = 30 + rand.Intn(101)
		case 3:
			atk = 20 + rand.Intn(181)
		default:
			continue
		}

		fmt.Println(fmt.Sprintf("基礎攻撃力は%dです。", atk))

		atk -= golem.Defense

		if atk <= 0 {
			atk = 0
			fmt.Println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
			fmt.Println(fmt.Sprintf("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.Attack))
			player_hp -= golem.Attack

			if player_hp <= 0 {
				fmt.Println("あなたはゴーレムに負けました！ゲームオーバー！")
				return
			}
			fmt.Println(fmt.Sprintf("あなたの残りHPは：%d", player_hp))
		}

		fmt.Println(fmt.Sprintf("ダメージは%dです。", atk))
		golem.Hp -= atk

		if golem.Hp < 0 {
			golem.Hp = 0
		}

		fmt.Println(fmt.Sprintf("残りのHPは%dです。", golem.Hp))

		if golem.Hp == 0 {
			fmt.Println("ゴーレムを倒しました！")
		}
	}
}

func (k05 K05) execute(num int) {
	switch num {
	case 1:
		k05.question1()
	case 2:
		k05.question2()
	case 3:
		k05.question3()
	case 4:
		k05.question4()
	}
}