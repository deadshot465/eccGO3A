import Executable from "../shared/Executable.ts"
import Golem from "../shared/Golem.ts";
import { getRandomNumber } from "../shared/Utility.ts";

export default class K05 extends Executable {
    question1(): void {
        let salary = 19.0;
        let age = 22;

        while (salary < 50.0) {
            salary *= 1.035;
            age++;
        }

        console.log(`${age}歳で月給${salary}万円`);
    }

    question2(): void {
        let choice = 0;
        do {
            console.log("起きろ～");
            choice = Number.parseInt(prompt("1．起きた　2．あと5分…　3．Zzzz…  入力：") ?? "0");
        } while (choice != 1);
        console.log("よし、学校へ行こう！");
    }

    question3(): void {
        do {
            console.log("起きろ～");
            const choice = Number.parseInt(prompt("1．起きた　2．あと5分…　3．Zzzz…  入力：") ?? "0");
            if (choice === 1) {
                console.log("よし、学校へ行こう！");
            }
        } while (true);
    }

    question4(): void {
        const golem: Golem = {
            hp: 300 + getRandomNumber(201),
            defense: 80,
            attack: 50
        };

        let playerHp = 200 + getRandomNumber(101);

        console.log(`ゴーレム　（HP：${golem.hp}　防御力：${golem.defense}）`);

        while (golem.hp > 0) {
            console.log("残りHP：" + golem.hp);
            const choice = Number.parseInt(prompt("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞") ?? "0");

            const damageFunc = (c: number) => {
                switch (c) {
                    case 1:
                        return 60 + getRandomNumber(41);
                    case 2:
                        return 30 + getRandomNumber(101);
                    case 3:
                        return 20 + getRandomNumber(181);
                    default:
                        return 0;
                }
            };

            let damage = damageFunc(choice);
            console.log(`基礎攻撃力は${damage}です。`);
            damage = damage - golem.defense < 0 ? 0 : damage - golem.defense;

            if (damage === 0) {
                console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                console.log("ゴーレムがあなたを攻撃しました！攻撃値：" + golem.attack);
                playerHp -= golem.attack;

                if (playerHp <= 0) {
                    console.log("あなたはゴーレムに負けました！ゲームオーバー！");
                    return;
                }
                console.log("あなたの残りHPは：" + playerHp);
            }

            console.log(`ダメージは${damage}です`);
            golem.hp = golem.hp - damage < 0 ? 0 : golem.hp - damage;
            console.log(`残りのHPは${golem.hp}です`);

            if (golem.hp === 0) {
                console.log("ゴーレムを倒しました！");
            }
        }
    }
}