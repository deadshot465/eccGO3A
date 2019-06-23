import { IExecutable } from './IExecutable';
import * as readline from 'readline';

export class K03 extends IExecutable {

    Question1(rl?: readline.ReadLine): Promise<string> {
        try {

            let age: number;

            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("年齢を入力して下さい＞", (value) => {
                        age = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await question1();
                    if (age < 20) {
                        console.log("未成年なので購入できません。");
                    }
                    resolve();
                });
            };

            return new Promise(async (resolve, reject) => {
                await showResult();
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        try {

            let height: number;
            let weight: number;

            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("身長を入力して下さい＞", (value) => {
                        height = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let question2 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("体重を入力して下さい＞", (value) => {
                        weight = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await question1();
                    await question2();
                    height /= 100.0;
                    let standard = height * height * 22.0;
                    console.log("あなたの標準体重は" + standard + "です。");

                    if (weight > standard && (weight - standard) / standard * 100.0 > 14.0) {
                        console.log("太り気味です。");
                    }
                    else if (weight < standard && (weight - standard) / standard * 100.0 < -14.0) {
                        console.log("痩せ気味です。");
                    }
                    else {
                        console.log("普通ですね。");
                    }
                    resolve();
                });
            };

            return new Promise(async (resolve, reject) => {
                await showResult();
                resolve();
            });

        } catch (e) {
            console.error(e);
        }
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        try {
            let randNum = Math.round(Math.random() * 100);

            console.log("０から９９の範囲の数値が決定されました。");

            let guess: number;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("決められた数値を予想し、この数値よりも大きな値を入力してください＞", (value) => {
                        guess = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await q1();
                    console.log("決められた数値は" + randNum + "です。");
                    console.log(guess > randNum ? "正解です。" : "不正解です。");
                    resolve();
                });
            };

            return new Promise(async (resolve, reject) => {
                await showResult();
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        try {
            let randNum = Math.round(Math.random() * 100);

            console.log("０から９９の範囲の数値が決定されました。");

            let guess: number;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("決められた数値を予想し、この数値よりも大きな値を入力してください＞", (value) => {
                        guess = Number.parseInt(value);
                        resolve();
                    });
                });
            };

            let showResult = () => {
                return new Promise(async (resolve, reject) => {
                    await q1();
                    console.log("決められた数値は" + randNum + "です。");

                    if (guess > 100 || guess < 0) {
                        console.log("反則です！");
                    } else if (guess > randNum && guess - randNum <= 10) {
                        console.log("大正解です！");
                    } else if (guess < randNum && guess - randNum >= -10) {
                        console.log("惜しい！");
                    } else if (guess == randNum) {
                        console.log("お見事！");
                    } else {
                        console.log(guess > randNum ? "正解です。" : "不正解です。");
                    }

                    resolve();
                });
            };

            return new Promise(async (resolve, reject) => {
                await showResult();
                resolve();
            });
        } catch (e) {
            console.error(e);
        }
    }

}