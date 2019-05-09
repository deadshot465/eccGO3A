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
const K08_1 = require("./K08_1sub");
const K08_2sub_1 = require("./K08_2sub");
const util_1 = require("util");
class K08 extends IExecutable_1.IExecutable {
    Question1(rl) {
        try {
            let numbers = new Array();
            let count = 0;
            let choice = 0;
            let inputNumber = () => {
                return new Promise((resolve, reject) => {
                    rl.question(util_1.format("%dつ目の値を入力してください。＞", count + 1), (value) => {
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
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                for (var i = 0; i < 3; i++) {
                    yield inputNumber();
                }
                console.log("どちらを調べますか？");
                yield inputSelection();
                switch (choice) {
                    case 0:
                        console.log(util_1.format("%dの中で最大値は%dです。", numbers.length, K08_1.GetMaxValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    case 1:
                        console.log(util_1.format("%dの中で最小値は%dです。", numbers.length, K08_1.GetMinValue(numbers[0], numbers[1], numbers[2])));
                        break;
                    default:
                        break;
                }
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question2(rl) {
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
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                while (continueGame) {
                    if (playerHp == 0) {
                        resolve();
                        return;
                    }
                    console.log(util_1.format("あなたのHP：%d", playerHp));
                    yield goForward();
                    if (continueGame) {
                        let golemLv = Math.floor(Math.random() * 4);
                        yield K08_2sub_1.AttackGolem(golemLv, playerHp, rl).then((value) => {
                            playerHp = value;
                        });
                    }
                }
                console.log("リレ〇ト！");
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question3(rl) {
        throw new Error("Method not implemented.");
    }
    Question4(rl) {
        throw new Error("Method not implemented.");
    }
}
exports.K08 = K08;
//# sourceMappingURL=K08.js.map