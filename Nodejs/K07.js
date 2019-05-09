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
const util_1 = require("util");
class K07 extends IExecutable_1.IExecutable {
    ShowText() {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
    }
    GetMaxValue(value1, value2, value3) {
        let temp = value1 >= value2 ? value1 : value2;
        temp = temp >= value3 ? temp : value3;
        return temp;
    }
    GetType(age) {
        if (age <= 0) {
            return 0;
        }
        else if (age < 3 || age >= 70) {
            return 1;
        }
        else if (age >= 3 && age <= 15) {
            return 2;
        }
        else if (age >= 60 && age < 70) {
            return 3;
        }
        else {
            return 4;
        }
    }
    Question1(rl) {
        let choice = 0;
        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("メッセージを表示しますか？（０：終了する　１：表示する）＞", (value) => {
                    choice = Number.parseInt(value);
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            do {
                yield q1();
                if (choice == 1) {
                    this.ShowText();
                }
            } while (choice != 0);
            resolve();
        }));
    }
    Question2(rl) {
        let numbers = new Array();
        let count = 0;
        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question(util_1.format("%dつ目の値を入力してください。＞", count + 1), (value) => {
                    numbers.push(Number.parseInt(value));
                    count++;
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            for (var i = 0; i < 3; i++) {
                yield q1();
            }
            let maxValue = this.GetMaxValue(numbers[0], numbers[1], numbers[2]);
            console.log(util_1.format("%dつの中で最大値は%dです。", numbers.length, maxValue));
            resolve();
        }));
    }
    Question3(rl) {
        let age;
        let no;
        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("年齢を入力して下さい。＞", (value) => {
                    age = Number.parseInt(value);
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            yield q1();
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
        }));
    }
    Question4(rl) {
        return;
    }
}
exports.K07 = K07;
//# sourceMappingURL=K07.js.map