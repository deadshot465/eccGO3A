"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const IExecutable_1 = require("./IExecutable");
class K03 extends IExecutable_1.IExecutable {
    Question1(rl) {
        try {
            let age;
            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("年齢を入力して下さい＞", (value) => {
                        age = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield question1();
                    if (age < 20) {
                        console.log("未成年なので購入できません。");
                    }
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question2(rl) {
        try {
            let height;
            let weight;
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
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield question1();
                    yield question2();
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
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question3(rl) {
        try {
            let randNum = Math.round(Math.random() * 100);
            console.log("０から９９の範囲の数値が決定されました。");
            let guess;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("決められた数値を予想し、この数値よりも大きな値を入力してください＞", (value) => {
                        guess = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
                    console.log("決められた数値は" + randNum + "です。");
                    console.log(guess > randNum ? "正解です。" : "不正解です。");
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question4(rl) {
        try {
            let randNum = Math.round(Math.random() * 100);
            console.log("０から９９の範囲の数値が決定されました。");
            let guess;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("決められた数値を予想し、この数値よりも大きな値を入力してください＞", (value) => {
                        guess = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
                    console.log("決められた数値は" + randNum + "です。");
                    if (guess > 100 || guess < 0) {
                        console.log("反則です！");
                    }
                    else if (guess > randNum && guess - randNum <= 10) {
                        console.log("大正解です！");
                    }
                    else if (guess < randNum && guess - randNum >= -10) {
                        console.log("惜しい！");
                    }
                    else if (guess == randNum) {
                        console.log("お見事！");
                    }
                    else {
                        console.log(guess > randNum ? "正解です。" : "不正解です。");
                    }
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
}
exports.K03 = K03;
//# sourceMappingURL=K03.js.map