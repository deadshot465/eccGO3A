package main

import (
	"fmt"
	"strconv"
)

func attackGolem(lv int, playerHp *int) {
	golem := Golem{
		Hp: lv * 50 + 100,
		Defense: lv * 10 + 40,
		Attack: lv * 10 + 30,
			}
	attackOptions := make(map[string]int)
	attackOptions["Dagger"] = 65
	attackOptions["Sword"] = 99
	attackOptions["Axe"] = 133

	fmt.Println(fmt.Sprintf("ゴーレムLv.%dが現れた！", lv + 1))
	for golem.Hp > 0 {
		fmt.Println(fmt.Sprintf("\n残りHP：%d", golem.Hp))
		fmt.Print("武器を選択してください（１．短剣　２．長剣　３．斧）＞")
		var inputString string
		_, _ = fmt.Scanln(&inputString)
		choice, _ := strconv.Atoi(inputString)

		damage := 0
		switch choice {
		case 1: damage = attackOptions["Dagger"]
		case 2: damage = attackOptions["Sword"]
		case 3: damage = attackOptions["Axe"]
		}

		damage -= golem.Defense
		if damage <= 0 {
			damage = 0
			fmt.Println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
			fmt.Println(fmt.Sprintf("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.Attack))
			*playerHp -= golem.Attack

			if *playerHp <= 0 {
				*playerHp = 0
				fmt.Println("あなたはゴーレムに負けました！ゲームオーバー！")
				return
			}
			fmt.Println(fmt.Sprintf("あなたの残りHPは：%d", *playerHp))
		}
		fmt.Println(fmt.Sprintf("ダメージは%dです。", damage))
		golem.Hp -= damage

		if golem.Hp <= 0 {
			golem.Hp = 0
		}

		if golem.Hp == 0 {
			fmt.Println(fmt.Sprintf("ゴーレムLv.%dを倒した！", lv + 1))
		}
	}
}
