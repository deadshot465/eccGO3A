import { IExecutable } from "./IExecutable"
import * as readline from "readline"

export class K10 extends IExecutable {
    Question1(rl?: readline.ReadLine): Promise<string> {
        let inputString: string;

        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("文字列の入力＞", (value) => {
                    inputString = value;
                    resolve();
                });
            });
        };

        return new Promise(async (resolve, reject) => {
            await q1();
            console.log(`入力された文字列の文字数：${inputString.length}`);
            resolve();
        });
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        let str = "STRINGcopy";
        console.log(`コピーしたい文字列：${str}`);
        let copyStr = str;
        console.log(`コピー後の文字列：${copyStr}`);

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let str = [
            "abcdef", "GHIJKL", "13579"
        ];

        let strCombined = "";

        console.log("連結したい３つの文字列：");
        for (var s of str) {
            console.log(s);
            strCombined += s;
        }

        console.log(`連結した文字列：\n${strCombined}`);

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        let alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        let inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.";

        let count = 0;
        let _count = 0;
        console.log(`文字列：${inputString}\n`);
        console.log("文字頻度");
        for (var i = 0; i < alphabets.length; i++) {
            for (var j = 0; j < inputString.length; j++) {
                if (alphabets[i] === inputString[j]) {
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