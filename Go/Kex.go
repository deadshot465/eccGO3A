package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

const PlayerHp int = 500
const PlayerDefense int = 30

type Kex struct {

}

func (kex Kex) Execute() {
	fmt.Println("冒険が今始まる！")
	player := Player{
		Hp:      PlayerHp,
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
		if continueGame != 0 {
			golemLv := rand.Intn(5)
			AttackGolemEx(golemLv, &player)
			kills++
			if player.Hp == 0 {
				break
			}
		}
	}
	fmt.Println("リ〇ミト！")
	fmt.Printf("戦闘回数：%d　残りHP：%d\n", kills, player.Hp)
}