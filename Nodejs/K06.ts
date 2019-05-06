import { IExecutable } from './IExecutable';
import * as readline from 'readline';
import { format } from 'util';

export class K06 extends IExecutable {

    Question1(rl?: readline.ReadLine): Promise<string> {
        try {
            let ages = new Array<number>();
            let count = 0;

            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question(format("%d人目の年齢を入力して下さい：", count + 1), (value) => {
                        ages[count] = Number.parseInt(value);
                        resolve();
                    });
                });
            }

            return new Promise(async (resolve, reject) => {
                for (var i = 0; i < 5; i++) {
                    count = i;
                    await q1();
                }
                let average = ages.reduce((prev, cur, index, arr) => {
                    return prev + cur;
                }) / ages.length;
                console.log(format("%d人の平均年齢は%dです。", ages.length, average));
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        for (var i = 0; i < 9; i++)
        {
            for (var j = 0; j < i + 1; j++)
            {
                process.stdout.write("*");
            }
            console.log();
        }
        console.log();

        for (var i = 9; i > 0; i--)
        {
            for (var j = 0; j < i; j++)
            {
                process.stdout.write("*");
            }
            console.log();
        }
        console.log();

        for (var i = 9; i > 0; i--)
        {
            for (var j = 0; j < i - 1; j++)
            {
                process.stdout.write(" ");
            }

            for (var k = 9; k > i - 1; k--)
            {
                process.stdout.write("*");
            }
            console.log();
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let total = 370;
        let count = 0;

        for (var i = 0; i <= Math.trunc(total / 100); i++) {
            for (var j = 0; j <= Math.trunc(total / 50); j++) {
                for (var k = 0; k <= Math.trunc(total / 10); k++) {
                    if (100 * i + 50 * j + 10 * k == total) {
                        console.log(format("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨", k, j, i));
                        count++;
                    }
                }
            }
        }

        console.log("\n以上" + count + "通りを発見しました。");
        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {

        process.stdout.write("\t|\t");

        for (var i = 1; i < 10; i++)
        {
            process.stdout.write(i + "\t");
        }
        console.log();

        for (var i = 0; i < 76; i++)
        {
            process.stdout.write("-");
        }
        console.log();

        for (var i = 1; i < 10; i++)
        {
            process.stdout.write(i + "\t|\t");
            for (var j = 1; j < 10; j++)
            {
                process.stdout.write((i * j) + "\t");
            }
            console.log();
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

}