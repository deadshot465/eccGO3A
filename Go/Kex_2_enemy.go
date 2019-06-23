package main

import "math/rand"

const MaxGolemLevel = 5
const MaxGoblinLevel = 7
const MaxSlimeLevel = 9
const GoblinHit = 85
const GoblinFlee = 40
const SlimeHit = 95
const SlimeFlee = 30

func CreateEnemy(enemyType int) Enemy  {
	enemy := Enemy{}

	switch enemyType {
	case 0:
		lv := rand.Intn(MaxGolemLevel)
		enemy.Lv = lv
		enemy.Hp = lv * 50 + 100
		enemy.Attack = lv * 10 + 40
		enemy.Defense = lv * 10 + 40
		enemy.Hit = GolemHit
		enemy.Flee = GolemFlee
		enemy.Name = "ゴーレム"
	case 1:
		lv := rand.Intn(MaxGoblinLevel)
		enemy.Lv = lv
		enemy.Hp = lv * 30 + 75
		enemy.Attack = lv * 5 + 20
		enemy.Defense = lv * 5 + 20
		enemy.Hit = GoblinHit
		enemy.Flee = GoblinFlee
		enemy.Name = "ゴブリン"
	case 2:
		lv := rand.Intn(MaxSlimeLevel)
		enemy.Lv = lv
		enemy.Hp = lv * 10 + 50
		enemy.Attack = lv * 2 + 10
		enemy.Defense = lv * 2 + 10
		enemy.Hit = SlimeHit
		enemy.Flee = SlimeFlee
		enemy.Name = "スライム"
	}

	return enemy
}
