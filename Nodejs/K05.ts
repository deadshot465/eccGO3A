import { IExecutable } from './IExecutable';
import { Golem } from './Golem';
import * as readline from 'readline';
import { format } from 'util';

export class K05 extends IExecutable {

    Question1(rl?: readline.ReadLine): Promise<string> {
        let salary = 19.0;
        let age = 22;

        while (salary < 50.0) {
            salary *= 1.035;
            age++;
        }

        console.log(format("%d歳で月給%d万円", age, salary));
        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        try {

            let choice = 0;

            let q1 = () => {
                return new Promise((resolve, reject) => {
                    console.log("起きろ～");
                    rl.question("1．起きた　2．あと5分…　3．Zzzz…  入力：", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            }

            return new Promise(async (resolve, reject) => {
                while (choice != 1) {
                    await q1();
                }
                console.log("よし、学校へ行こう！");
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        try {
            let choice = 0;

            let q1 = () => {
                return new Promise((resolve, reject) => {
                    console.log("起きろ～");
                    rl.question("1．起きた　2．あと5分…　3．Zzzz…\t入力：", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            return new Promise(async (resolve, reject) => {
                while (true) {
                    await q1();
                    if (choice == 1) {
                        console.log("よし、学校へ行こう！");
                    }
                }
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        try {
            let golem = new Golem(300 + Math.round(Math.random() * 200));
            let playerHp = 200 + Math.round(Math.random() * 100);

            console.log(format("ゴーレム　（HP：%d　防御力：%d）", golem.hp, golem.defense));
            console.log("HP：" + golem.hp);

            let choice = 0;
            let damage = 0;

            let q1 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let attackGolem = () => {
                return new Promise((resolve, reject) => {

                    switch (choice) {
                        case 1:
                            damage = 60 + Math.round(Math.random() * 40);
                            break;
                        case 2:
                            damage = 30 + Math.round(Math.random() * 100);
                            break;
                        case 3:
                            damage = 20 + Math.round(Math.random() * 180);
                            break;
                        default:
                            break;
                    }
                    console.log(format("基礎攻撃力は%dです。", damage));

                    damage -= golem.defense;

                    if (damage <= 0) {
                        damage = 0;
                        console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                        console.log(format("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.attack));
                        playerHp -= golem.attack;

                        if (playerHp <= 0) {
                            console.log("あなたはゴーレムに負けました！ゲームオーバー！")
                            resolve();
                        }
                        console.log("あなたの残りHPは：" + playerHp);
                    }

                    console.log(format("ダメージは%dです。", damage));
                    golem.hp -= damage;

                    if (golem.hp <= 0) {
                        golem.hp = 0;
                    }

                    console.log(format("残りのHPは%dです。", golem.hp));

                    if (golem.hp == 0) {
                        console.log("ゴーレムを倒しました！");
                    }
                    resolve();
                });
            };

            return new Promise<string>(async (resolve, reject) => {
                while (golem.hp > 0) {
                    await q1();
                    await attackGolem();
                }
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

}