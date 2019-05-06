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
const Golem_1 = require("./Golem");
const IExecutable_1 = require("./IExecutable");
const util_1 = require("util");
class K02 extends IExecutable_1.IExecutable {
    Question1() {
        let seisuu = 3;
        let jissuu = 2.6;
        let moji = 'A';
        console.log("整数seisuuの値は" + seisuu);
        console.log("実数jissuuの値は" + jissuu);
        console.log("文字mojiの値は" + moji);
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question2(rl) {
        try {
            let firstNumber;
            let secondNumber;
            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("一つ目の整数は？", (value) => {
                        firstNumber = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let question2 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("二つ目の整数は？", (value) => {
                        secondNumber = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield question1();
                    yield question2();
                    console.log(firstNumber + "÷" + secondNumber + "="
                        + Math.trunc(firstNumber / secondNumber) + "..." + firstNumber % secondNumber);
                    rl.close();
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
            let priceA = 0;
            let amountA = 0;
            let priceB = 0;
            let amountB = 0;
            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("一つ目の商品の値段は？", (value) => {
                        priceA = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let question2 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("個数は？", (value) => {
                        amountA = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let question3 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("二つ目の商品の値段は？", (value) => {
                        priceB = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let question4 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("個数は？", (value) => {
                        amountB = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield question1();
                    yield question2();
                    yield question3();
                    yield question4();
                    let total = (priceA * amountA + priceB * amountB) * 1.08;
                    console.log("お支払いは税込み￥" + total + "です。");
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
            let golem = new Golem_1.Golem();
            console.log(util_1.format("ゴーレム　（HP：%d　防御力：%d）", golem.hp, golem.defense));
            console.log("HP：" + golem.hp);
            let damage = 0;
            let question1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("今回の攻撃の値を入力してください＞", (value) => {
                        damage = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield question1();
                    damage = damage - golem.defense > 0 ? damage - golem.defense : 0;
                    console.log("ダメージは" + damage + "です。");
                    golem.hp -= damage;
                    console.log("残りのHPは" + golem.hp + "です。");
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
exports.K02 = K02;
//# sourceMappingURL=K02.js.map