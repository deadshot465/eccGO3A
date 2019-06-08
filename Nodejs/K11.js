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
class K11 extends IExecutable_1.IExecutable {
    Question1(rl) {
        try {
            let ages = new Array();
            let count = 0;
            const maxNumber = 5;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question(util_1.format("%d人目の年齢を入力して下さい：", count + 1), (value) => {
                        ages[count] = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                for (var i = 0; i < maxNumber; i++) {
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
        let strs = new Array();
        let count = 1;
        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question(util_1.format("%dつ目の文字列を入力して下さい。＞", count), (value) => {
                    strs.push(value);
                    count++;
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            for (let i = 0; i < 2; i++) {
                yield question();
            }
            let result = strs.join("");
            console.log(util_1.format("%sの文字数は%dです。", result, result.length));
            resolve();
        }));
    }
    Question3(rl) {
        let str;
        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question("文字を入力して下さい。＞", (value) => {
                    str = value;
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            yield question();
            let applied = false;
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
        }));
    }
    Question4(rl) {
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
exports.K11 = K11;
//# sourceMappingURL=K11.js.map