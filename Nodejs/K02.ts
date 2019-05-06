import { Golem } from './Golem';
import { IExecutable } from "./IExecutable";
import * as readline from 'readline';
import { format } from 'util';

export class K02 extends IExecutable {
    Question1() {
        let seisuu = 3;
        let jissuu = 2.6;
        let moji = 'A';

        console.log("整数seisuuの値は" + seisuu);
        console.log("実数jissuuの値は" + jissuu);
        console.log("文字mojiの値は" + moji);
        return new Promise<string>((resolve, reject) => {
            resolve();
        });
    }

    Question2(rl?: readline.ReadLine) {
        try {
            let firstNumber: number;
            let secondNumber: number;

            let question1 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("一つ目の整数は？", (value) => {
                        firstNumber = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let question2 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("二つ目の整数は？", (value) => {
                        secondNumber = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise<string>(async (resolve, reject) => {
                    await question1();
                    await question2();
                    console.log(firstNumber + "÷" + secondNumber + "="
                        + Math.trunc(firstNumber / secondNumber) + "..." + firstNumber % secondNumber);
                    rl.close();
                    resolve();
                });
            };

            return new Promise<string>(async (resolve, reject) => {
                await showResult();
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question3(rl: readline.ReadLine) {
        try {
            let priceA = 0;
            let amountA = 0;
            let priceB = 0;
            let amountB = 0;

            let question1 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("一つ目の商品の値段は？", (value) => {
                        priceA = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let question2 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("個数は？", (value) => {
                        amountA = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let question3 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("二つ目の商品の値段は？", (value) => {
                        priceB = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let question4 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("個数は？", (value) => {
                        amountB = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await question1();
                    await question2();
                    await question3();
                    await question4();
                    let total = (priceA * amountA + priceB * amountB) * 1.08;
                    console.log("お支払いは税込み￥" + total + "です。");
                    resolve();
                });
            };

            return new Promise<string>(async (resolve, reject) => {
                await showResult();
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question4(rl: readline.ReadLine) {
        try {
            let golem = new Golem();

            console.log(format("ゴーレム　（HP：%d　防御力：%d）", golem.hp, golem.defense));
            console.log("HP：" + golem.hp);

            let damage = 0;

            let question1 = () => {
                return new Promise<string>((resolve, reject) => {
                    rl.question("今回の攻撃の値を入力してください＞", (value) => {
                        damage = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await question1();
                    damage = damage - golem.defense > 0 ? damage - golem.defense : 0;

                    console.log("ダメージは" + damage + "です。");
                    golem.hp -= damage;

                    console.log("残りのHPは" + golem.hp + "です。");
                    resolve();
                });
            }

            return new Promise<string>(async (resolve, reject) => {
                await showResult();
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }
}