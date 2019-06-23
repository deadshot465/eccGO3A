package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

func AttackEnemy(player *Player, enemy *Enemy) bool {
	fmt.Printf("%sLv.%dが現れた！\n", enemy.Name, enemy.Lv + 1)

	for enemy.Hp > 0 {
		fmt.Printf("%s 残りHP：%d\n", enemy.Name, enemy.Hp)
		fmt.Print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
		var reader string
		_, _ = fmt.Scanln(&reader)
		choice, _ := strconv.Atoi(reader)
		getAttackPower := func () int {
			return rand.Intn(41) + 60
		}
		getSkillPower := func () int {
			return rand.Intn(101) + 30
		}
		getMagicPower := func () int {
			return rand.Intn(181) + 20
		}
		getPowers := []func () int { getAttackPower, getSkillPower, getMagicPower }
		var attacks []Attack
		getHits := []int { AttackHit, SkillHit, MagicHit }

		for i := 0; i < 3; i++ {
			attacks = append(attacks, Attack { getPowers[i](), getHits[i] })
		}

		damage := 0
		isHit := false

		switch choice {
		case 1:
			damage = attacks[0].Damage
			isHit = CheckHitOrMiss(attacks[0].Hit - enemy.Flee)
		case 2:
			damage = attacks[1].Damage
			isHit = CheckHitOrMiss(attacks[1].Hit - enemy.Flee)
		case 3:
			damage = attacks[2].Damage
			isHit = CheckHitOrMiss(attacks[2].Hit - enemy.Flee)
		}

		if isHit {
			damage -= enemy.Defense
			if damage <= 0 {
				damage = 0
			}
			fmt.Printf("%dのダメージ！\n", damage)
			enemy.Hp -= damage
		} else {
			fmt.Println("攻撃を外した！")
		}

		fmt.Printf("%sの攻撃！\n", enemy.Name)
		isHit = CheckHitOrMiss(enemy.Hit)
		if isHit {
			injury := enemy.Attack - player.Defense
			if injury <= 0 {
				injury = 0
			}
			fmt.Printf("%dのダメージ！\n", injury)
			player.Hp -= injury
			if player.Hp <= 0 {
				player.Hp = 0
				fmt.Printf("あなたは%sに負けました！ゲームオーバー！\n", enemy.Name)
				return false
			}
		} else {
			fmt.Println("攻撃を外した！")
		}

		fmt.Printf("プレイヤー残りHP：%d\n", player.Hp)
		if enemy.Hp <= 0 {
			enemy.Hp = 0
		}
		if enemy.Hp == 0 {
			fmt.Printf("%sLv.%dを倒した！\n", enemy.Name, enemy.Lv + 1)
		}
	}
	return true
}