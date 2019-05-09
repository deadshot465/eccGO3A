import { IExecutable } from './IExecutable';
import * as K08_1 from './K08_1sub';
import { AttackGolem } from './K08_2sub';
import * as readline from 'readline';
import { format } from 'util';

export class K08 extends IExecutable {
    Question1(rl?: readline.ReadLine): Promise<string> {
        try {
            let numbers = new Array<number>();
            let count = 0;
            let choice = 0;

            let inputNumber = () => {
                return new Promise((resolve, reject) => {
                    rl.question(format("%dつ目の値を入力してください。＞", count + 1), (value) => {
                        numbers[count] = Number.parseInt(value);
                        count++;
                        resolve();
                    });
                });
            };

            let inputSelection = () => {
                return new Promise((resolve, reject) => {
                    rl.question("（０：最大値　１：最小値）＞", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            }

            return new Promise(async (resolve, reject) => {
                for (var i = 0; i < 3; i++) {
                    await inputNumber();
                }
                console.log("どちらを調べますか？");
                await inputSelection();
                switch (choice) {
                    case 0:
                        console.log(format("%dの中で最大値は%dです。", numbers.length,
                            K08_1.GetMaxValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    case 1:
                        console.log(format("%dの中で最小値は%dです。", numbers.length,
                            K08_1.GetMinValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    default:
                        break;
                }
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        try {
            console.log("冒険が今始まる！");
            let playerHp = 200 + Math.floor(Math.random() * 100);
            let continueGame = true;

            let goForward = () => {
                return new Promise((resolve, reject) => {
                    rl.question("奥に進みますか？（１：奥に進む　０．帰る）＞", (value) => {
                        continueGame = Boolean(Number.parseInt(value));
                        resolve();
                    });
                });
            };

            return new Promise(async (resolve, reject) => {
                while (continueGame) {
                    if (playerHp == 0) {
                        resolve();
                        return;
                    }
                    console.log(format("あなたのHP：%d", playerHp));
                    await goForward();
                    if (continueGame) {
                        let golemLv = Math.floor(Math.random() * 4);
                        await AttackGolem(golemLv, playerHp, rl).then((value) => {
                            playerHp = value;
                        });
                    }
                }
                console.log("リレ〇ト！");
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        throw new Error("Method not implemented.");
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        throw new Error("Method not implemented.");
    }


}