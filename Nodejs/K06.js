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
class K06 extends IExecutable_1.IExecutable {
    Question1(rl) {
        try {
            let ages = new Array();
            let count = 0;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question(util_1.format("%d人目の年齢を入力して下さい：", count + 1), (value) => {
                        ages[count] = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                for (var i = 0; i < 5; i++) {
                    count = i;
                    yield q1();
                }
                let average = ages.reduce((prev, cur, index, arr) => {
                    return prev + cur;
                }) / ages.length;
                console.log(util_1.format("%d人の平均年齢は%dです。", ages.length, average));
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question2(rl) {
        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < i + 1; j++) {
                process.stdout.write("*");
            }
            console.log();
        }
        console.log();
        for (var i = 9; i > 0; i--) {
            for (var j = 0; j < i; j++) {
                process.stdout.write("*");
            }
            console.log();
        }
        console.log();
        for (var i = 9; i > 0; i--) {
            for (var j = 0; j < i - 1; j++) {
                process.stdout.write(" ");
            }
            for (var k = 9; k > i - 1; k--) {
                process.stdout.write("*");
            }
            console.log();
        }
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question3(rl) {
        let total = 370;
        let count = 0;
        for (var i = 0; i <= Math.trunc(total / 100); i++) {
            for (var j = 0; j <= Math.trunc(total / 50); j++) {
                for (var k = 0; k <= Math.trunc(total / 10); k++) {
                    if (100 * i + 50 * j + 10 * k == total) {
                        console.log(util_1.format("10円の硬貨%d枚 50円の硬貨%d枚 100円の硬貨", k, j, i));
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
    Question4(rl) {
        process.stdout.write("\t|\t");
        for (var i = 1; i < 10; i++) {
            process.stdout.write(i + "\t");
        }
        console.log();
        for (var i = 0; i < 76; i++) {
            process.stdout.write("-");
        }
        console.log();
        for (var i = 1; i < 10; i++) {
            process.stdout.write(i + "\t|\t");
            for (var j = 1; j < 10; j++) {
                process.stdout.write((i * j) + "\t");
            }
            console.log();
        }
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
}
exports.K06 = K06;
//# sourceMappingURL=K06.js.map