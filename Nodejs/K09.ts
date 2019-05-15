import { IExecutable } from "./IExecutable";
import * as readline from "readline";
import { format } from "util";

export class K09 extends IExecutable {
    Execute(num: number, rl?: readline.ReadLine): Promise<string> {
        switch (num) {
            case 1:
                return new Promise(async (resolve, reject) => {
                await this.Question1(rl);
                resolve();
                });
            case 2:
                return new Promise(async (resolve, reject) => {
                await this.Question2(rl);
                resolve();
                });
            case 3:
                return new Promise(async (resolve, reject) => {
                await this.Question3(rl);
                resolve();
                });
            case 4:
                return new Promise(async (resolve, reject) => {
                await this.Question4(rl);
                resolve();
                });
            case 5:
                return new Promise(async (resolve, reject) => {
                await this.Question5(rl);
                resolve();
                });
            default:
                break;
        }
    }

    Question1(rl?: readline.ReadLine): Promise<string> {
        try {
            let ages = new Array<number>();
            let count = 0;

            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question(`${count + 1}人目の年齢を入力＞`,
                        (value) => {
                            ages.push(Number.parseInt(value));
                            count++;
                            resolve();
                        });
                });
            };

            return new Promise(async (resolve, reject) => {
                for (var i = 0; i < 3; i++) {
                    await q1();
                }

                for (var j = 0; j < 21; j++) {
                    process.stdout.write("-");
                }
                console.log();

                for (var k = 0; k < 3; k++) {
                    console.log(`${k + 1}人目${ages[k]}歳。`);
                }
                console.log(format("平均年齢：%d",
                    ages.reduce((prev, curr, index, arr) => {
                        return prev + curr;
                    }) /
                    ages.length));
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        let numbers = [8, 3, 12, 7, 9];
        process.stdout.write("元々の配列：");
        for (var num of numbers) {
            process.stdout.write(num + " ");
        }
        console.log();

        process.stdout.write("逆順での表示：");
        for (var num of numbers.reverse()) {
            process.stdout.write(num + " ");
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let studentScores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ];

        console.log("\t|\t科目A\t科目B\t科目C\t科目D");

        for (var i = 0; i < 46; i++)
        {
            process.stdout.write("-");
        }
        console.log();

        for (var i = 0; i < studentScores.length; i++)
        {
            process.stdout.write(`学生${i + 1}\t|\t`);
            for (var j = 0; j < studentScores[0].length; j++) {

                process.stdout.write(`${studentScores[i][j]}\t`);

            }

            console.log();
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        let studentScores = [
            [52, 71, 61, 47],
            [6, 84, 81, 20],
            [73, 98, 94, 95]
        ];

        let average = [0, 0, 0, 0];
        let total = 0;

        console.log("\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点");

        for (var i = 0; i < 66; i++) {
            process.stdout.write("-");
        }
        console.log();

        for (var i = 0; i < studentScores.length; i++) {

            process.stdout.write(`学生${i + 1}\t|\t`);
            for (var j = 0; j < studentScores[i].length; j++) {

                process.stdout.write(`${studentScores[i][j]}\t`);
                total += studentScores[i][j];
                average[j] += studentScores[i][j];

            }
            process.stdout.write(`|\t${total}`);
            total = 0;
            console.log();

        }

        process.stdout.write("平均点\t|\t");
        for (var avg of average) {
            process.stdout.write(`${Math.round(avg / 3.0)}\t`);
        }
        process.stdout.write("|");

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question5(rl?: readline.ReadLine): Promise<string> {
        try {

            let numbers = new Array<number>();
            let count = 0;

            let input = () => {
                return new Promise<boolean>((resolve, reject) => {
                    rl.question(`${count + 1}件目の入力：`, (value) => {
                        numbers[count] = Number.parseInt(value);
                        if (numbers[count] < 0) {
                            resolve(false);
                            return;
                        }
                        count++;
                        resolve(true);
                    });
                });
            };

            return new Promise(async (resolve, reject) => {
                for (var i = 0; i < 100; i++) {
                    let result = await input();
                    if (!result) {
                        break;
                    }
                }
                console.log("----並び替え後----");
                numbers.pop();
                numbers = numbers.sort((x, y) => x - y);
                for (var j = 0; j < count; j++) {
                    console.log(numbers[j]);
                }
                resolve();
            });

        } catch (e) {
            console.error(e);
        } 
    }
}