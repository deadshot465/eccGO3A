import { IExecutable } from './IExecutable';
import * as readline from 'readline';
import { format } from 'util';

export class K07 extends IExecutable {

    ShowText() {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
    }

    GetMaxValue(value1: number, value2: number, value3: number): number {
        let temp = value1 >= value2 ? value1 : value2;
        temp = temp >= value3 ? temp : value3;
        return temp;
    }

    GetType(age: number): number {
        if (age <= 0) {
            return 0;
        } else if (age < 3 || age >= 70) {
            return 1;
        } else if (age >= 3 && age <= 15) {
            return 2;
        } else if (age >= 60 && age < 70) {
            return 3;
        } else {
            return 4;
        }
    }

    Question1(rl?: readline.ReadLine): Promise<string> {
        let choice = 0;

        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("メッセージを表示しますか？（０：終了する　１：表示する）＞", (value) => {
                    choice = Number.parseInt(value);
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            do {
                await q1();
                if (choice == 1) {
                    this.ShowText();
                }
            } while (choice != 0);
            resolve();
        });
    }
    Question2(rl?: readline.ReadLine): Promise<string> {
        let numbers = new Array<number>();
        let count = 0;

        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question(format("%dつ目の値を入力してください。＞", count + 1), (value) => {
                    numbers.push(Number.parseInt(value));
                    count++;
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            for (var i = 0; i < 3; i++) {
                await q1();
            }
            let maxValue = this.GetMaxValue(numbers[0], numbers[1], numbers[2]);
            console.log(format("%dつの中で最大値は%dです。", numbers.length, maxValue));
            resolve();
        });
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let age: number;
        let no: number;

        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("年齢を入力して下さい。＞", (value) => {
                    age = Number.parseInt(value);
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            await q1();
            no = this.GetType(age);

            switch (no) {
                case 0:
                    console.log("不適切な値が入力されました。");
                    break;
                case 1:
                    console.log("入場料金無料です。");
                    break;
                case 2:
                    console.log("子供料金で半額です。");
                    break;
                case 3:
                    console.log("シニア割引で一割引きです。");
                    break;
                default:
                    console.log("通常料金です。");
                    break;
            }
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        return;
    }

}