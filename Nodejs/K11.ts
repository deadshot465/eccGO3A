import { IExecutable } from "./IExecutable";
import * as readline from "readline";
import { format } from "util";

export class K11 extends IExecutable {
    Question1(rl?: readline.ReadLine): Promise<string> {
        try {
            let ages = new Array<number>();
            let count = 0;
            const maxNumber = 5;

            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question(format("%d人目の年齢を入力して下さい：", count + 1), (value) => {
                        ages[count] = Number.parseInt(value);
                        resolve();
                    });
                });
            }

            return new Promise(async (resolve, reject) => {
                for (var i = 0; i < maxNumber; i++) {
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

        let strs = new Array<string>();
        let count = 1;

        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question(format("%dつ目の文字列を入力して下さい。＞", count), (value) => {
                    strs.push(value);
                    count++;
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            for (let i = 0; i < 2; i++) {
                await question();
            }

            let result = strs.join("");

            console.log(format("%sの文字数は%dです。", result, result.length));

            resolve();
        });


    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let str: string;

        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question("文字を入力して下さい。＞", (value) => {
                    str = value;
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            await question();
            let applied: boolean = false;
            if (/^[0-9]$/.test(str)) {
                console.log("この文字は数字です。");
                applied = true;
            }
            if (/^[A-Z]$/.test(str)) {
                console.log("この文字は英大文字です。");
                applied = true;
            }
            if (/^[a-z]$/.test(str)) {
                console.log("この文字は英小文字です。");
                applied = true;
            }
            if (/^[A-Fa-f0-9]$/.test(str)) {
                console.log("この文字は16進数として使える文字です。");
                applied = true;
            }
            if (/^(\.|\,|\!|\?|\:|\;|\"|\'|\-|\(|\))*$/g.test(str)) {
                console.log("この文字は区切り文字です。");
                applied = true;
            }
            if (!applied) {
                console.log("この文字はよくわからない文字です。");
                
            }
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        let inputString = "I am a STUDENT. I am good at GAME PROGRAMMING.";

        let count = 0;
        let _count = 0;
        console.log(`文字列：${inputString}\n`);
        console.log("文字頻度");
        for (var i = 0; i < alphabets.length; i++) {
            for (var j = 0; j < inputString.length; j++) {
                if (alphabets[i] === inputString[j].toUpperCase()) {
                    count++;
                }
            }
            process.stdout.write(`${alphabets[i]}: ${count}\t`);
            count = 0;
            _count++;

            if (_count % 4 === 0) {
                console.log();
            }
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }
}