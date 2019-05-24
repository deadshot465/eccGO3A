package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

const AttackHit int = 110
const SkillHit int = 100
const MagicHit int = 70
const GolemHit int = 70
const GolemFlee int = 20

func checkHitOrMiss(hit int) bool {
	val := rand.Intn(100)
	return val <= hit - 1
}

func AttackGolemEx(lv int, player *Player) {
	golem := GolemEx{
		Hp:      lv * 50 + 100,
		Defense: lv * 10 + 40,
		Attack:  lv * 10 + 40,
		Hit:     GolemHit,
		Flee:    GolemFlee,
	}

	fmt.Printf("ゴーレムLv.%dが現れた！\n", lv + 1)
	for golem.Hp > 0 {
		fmt.Printf("ゴーレム 残りHP：%d\n", golem.Hp)
		fmt.Print("武器を選択してください（１．攻撃　２．特技　３．魔法）＞")
		var reader string
		_, _ = fmt.Scanln(&reader)
		choice, _ := strconv.Atoi(reader)
		var damage int
		var is_hit bool
		switch choice {
		case 1:
			damage = 60 + rand.Intn(41)
			is_hit = checkHitOrMiss(AttackHit - golem.Flee)
		case 2:
			damage = 30 + rand.Intn(101)
			is_hit = checkHitOrMiss(SkillHit - golem.Flee)
		case 3:
			damage = 20 + rand.Intn(181)
			is_hit = checkHitOrMiss(MagicHit - golem.Flee)
		default:
			damage = 0
		}

		if is_hit {
			damage -= golem.Defense
			if damage <= 0 {
				damage = 0
			}
			fmt.Printf("%dのダメージ！\n", damage)
			golem.Hp -= damage
		} else {
			fmt.Println("攻撃を外した！")
		}

		fmt.Println("ゴーレムの攻撃！")
		is_hit = checkHitOrMiss(golem.Hit)
		if is_hit {
			injury := golem.Attack - player.Defense
			fmt.Printf("%dのダメージ！\n", injury)
			player.Hp -= injury
			if player.Hp <= 0 {
				player.Hp = 0
				fmt.Println("あなたはゴーレムに負けました！ゲームオーバー！")
				return
			}
		} else {
			fmt.Println("攻撃を外した！")
		}

		fmt.Printf("プレーヤー残りHP：%d\n", player.Hp)
		if golem.Hp <= 0 {
			golem.Hp = 0
		}
		if golem.Hp == 0 {
			fmt.Printf("ゴーレムLv.%dを倒した！\n", lv + 1)
		}
	}
}