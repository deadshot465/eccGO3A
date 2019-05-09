import { Golem } from './Golem';
import * as readline from 'readline';
import { format } from 'util';

export function AttackGolem(lv: number, playerHp: number, rl?: readline.ReadLine): Promise<number> {
    try {
        var golem = new Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30);
        console.log(format("ゴーレムLv.%dが現れた！", lv + 1));
        let choice = 0;

        let selectAttackMethod = () => {
            return new Promise((resolve, reject) => {
                rl.question("武器を選択してください（１．攻撃　２．特技　３．魔法）＞", (value) => {
                    choice = Number.parseInt(value);
                    resolve();
                });
            });
        };

        return new Promise<number>(async (resolve, reject) => {
            while (golem.hp > 0) {
                console.log(format("\n残りHP：%d", golem.hp));
                await selectAttackMethod();
                let damage = 0;
                switch (choice) {
                    case 1:
                        damage = Number(AttackMethod.Attack);
                        break;
                    case 2:
                        damage = Number(AttackMethod.Skill);
                        break;
                    case 3:
                        damage = Number(AttackMethod.Magic);
                        break;
                    default:
                        break;
                }
                damage -= golem.defense;

                if (damage <= 0) {
                    damage = 0;
                    console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                    console.log(format("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.attack));
                    playerHp = DamagePlayer(playerHp, golem.attack);
                    if (playerHp <= 0) {
                        playerHp = 0;
                        console.log("あなたはゴーレムに負けました！ゲームオーバー！");
                        resolve(playerHp);
                        return;
                    }
                    console.log(format("あなたの残りHPは：%d", playerHp));
                }
                console.log(format("ダメージは%dです。", damage));
                golem.hp -= damage;

                if (golem.hp <= 0)
                    golem.hp = 0;
                if (golem.hp == 0)
                    console.log(format("ゴーレムLv.%dを倒した！", lv + 1));
            }
            resolve(playerHp);
        });

    } catch (e) {
        console.error(e);
    }
}

enum AttackMethod {
    Attack = 65,
    Skill = 99,
    Magic = 133
}

function DamagePlayer(playerHp: number, attackPower: number): number {
    return playerHp - attackPower;
}