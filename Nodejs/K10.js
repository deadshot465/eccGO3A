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
class K10 extends IExecutable_1.IExecutable {
    Question1(rl) {
        let inputString;
        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("文字列の入力＞", (value) => {
                    inputString = value;
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            yield q1();
            console.log(`入力された文字列の文字数：${inputString.length}`);
            resolve();
        }));
    }
    Question2(rl) {
        let str = "STRINGcopy";
        console.log(`コピーしたい文字列：${str}`);
        let copyStr = str;
        console.log(`コピー後の文字列：${copyStr}`);
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question3(rl) {
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
    Question4(rl) {
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
exports.K10 = K10;
//# sourceMappingURL=K10.js.map