package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

type Kex_2 struct {

}

func (kex2 Kex_2) Execute() {
	fmt.Println("冒険が今始まる！")
	player := Player{
		Hp: PlayerHp,
		Defense: PlayerDefense,
	}
	continueGame := 1
	kills := 0

	for continueGame != 0 {
		fmt.Printf("現HP：%d\n", player.Hp)
		fmt.Print("奥に進みますか？（１：奥に進む　０．帰る）＞")
		var reader string
		_, _ = fmt.Scanln(&reader)
		continueGame, _ = strconv.Atoi(reader)
		if continueGame == 1 {
			typeNo := rand.Intn(3)
			enemy := CreateEnemy(typeNo)
			result := AttackEnemy(&player, &enemy)
			kills++
			if !result {
				break
			}
		}
	}

	fmt.Printf("リ〇ミト！\n\n")
	fmt.Printf("戦闘回数：%d回　残りHP：%d\n", kills, player.Hp)
}
