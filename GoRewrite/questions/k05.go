package questions

import (
	"GoRewrite/shared"
	"fmt"
	"math/rand"
)

type K05 struct {}

func (k K05) question1() {
	var salary float32
	age := 22

	for salary = 19.0; salary < 50.0; salary *= 1.035 {
		age += 1
	}

	fmt.Printf("%d歳で月給%f万円\n", age, salary)
}

func (k K05) question2() {
	var newChoice int
	for newChoice != 1 {
		fmt.Println("起きろ～")
		fmt.Print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
		_, _ = fmt.Scanf("%d", &newChoice)
	}
	fmt.Println("よし、学校へ行こう！")
}

func (k K05) question3() {
	for {
		fmt.Println("起きろ～")
		fmt.Print("1．起きた　2．あと5分…　3．Zzzz…\t入力：")
		var choice int
		_, _ = fmt.Scanf("%d", &choice)
		if choice == 1 {
			fmt.Println("よし、学校へ行こう！")
		}
	}
}

func (k K05) question4() {
	golem := shared.Golem{
		Hp:      300 + rand.Intn(200),
		Defense: 80,
		Attack:  50,
	}
	playerHp := 200 + rand.Intn(100)

	fmt.Printf("ゴーレム　（HP：%d　防御力：%d）\n", golem.Hp, golem.Defense)

	for golem.Hp > 0 {
		fmt.Printf("\nゴーレム残りHP：%d\n", golem.Hp)
		baseDamage := inputDamage(0)
		fmt.Printf("基礎攻撃力は%dです。\n", baseDamage)
		actualDamage := baseDamage - golem.Defense
		if baseDamage - golem.Defense < 0 {
			actualDamage = 0
		}

		if actualDamage == 0 {
			newPlayerHp := damagePlayer(golem.Attack, playerHp)
			if newPlayerHp < 0 {
				fmt.Println("あなたはゴーレムに負けました！ゲームオーバー！")
				return
			}
			playerHp = newPlayerHp
			fmt.Printf("あなたの残りHPは：%d\n", newPlayerHp)
		} else {
			fmt.Printf("ダメージは%dです。\n", actualDamage)
			golem.Hp -= actualDamage
			if golem.Hp < 0 {
				golem.Hp = 0
			}
			fmt.Printf("\n残りのHPは%dです。", golem.Hp)
			if golem.Hp == 0 {
				fmt.Println("\nゴーレムを倒しました！")
			}
		}
	}
}

func (k K05) Execute(number int) {
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

func inputDamage(choice int) int {
	switch choice {
	case 1:
		return 60 + rand.Intn(40)
	case 2:
		return 30 + rand.Intn(100)
	case 3:
		return 20 + rand.Intn(180)
	default:
		fmt.Println("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）＞")
		var newChoice int
		_, _ = fmt.Scanf("%d", &newChoice)
		return inputDamage(newChoice)
	}
}

func damagePlayer(golemAttack int, playerHp int) int {
	fmt.Println("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」")
	fmt.Printf("ゴーレムがあなたを攻撃しました！攻撃値：%d\n", golemAttack)
	return playerHp - golemAttack
}