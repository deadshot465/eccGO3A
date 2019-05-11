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
const readline = require("readline");
const K01_1 = require("./K01");
const K02_1 = require("./K02");
const K03_1 = require("./K03");
const K04_1 = require("./K04");
const K05_1 = require("./K05");
const K06_1 = require("./K06");
const K07_1 = require("./K07");
const K08_1 = require("./K08");
const FileControl_1 = require("./FileControl");
function ShowSelections(chapter) {
    for (let i = 1; i < 5; i++) {
        console.log("\t" + i + ") K0" + chapter + "_" + i);
    }
}
var executables = new Array();
executables[0] = new K01_1.K01();
executables[1] = new K02_1.K02();
executables[2] = new K03_1.K03();
executables[3] = new K04_1.K04();
executables[4] = new K05_1.K05();
executables[5] = new K06_1.K06();
executables[6] = new K07_1.K07();
executables[7] = new K08_1.K08();
executables[8] = new FileControl_1.FileControl();
console.log("実行したいプログラムを選択してください。\n");
for (let i = 1; i <= executables.length; i++) {
    console.log(i + ") K0" + i);
}
try {
    let rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let choice;
    let choice2;
    let selectChapter = () => {
        return new Promise((resolve, reject) => {
            rl.question("", (value) => {
                choice = Number.parseInt(value);
                ShowSelections(choice);
                resolve();
            });
        });
    };
    let selectQuestions = () => {
        return new Promise((resolve, reject) => {
            rl.question("", (value) => {
                choice2 = Number.parseInt(value);
                resolve();
            });
        });
    };
    let executeQuestion = () => {
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            yield executables[choice - 1].Execute(choice2, rl);
            resolve();
        }));
    };
    let mainProgram = () => __awaiter(this, void 0, void 0, function* () {
        yield selectChapter();
        yield selectQuestions();
        yield executeQuestion();
        rl.close();
        process.stdin.setRawMode(true);
        process.stdin.resume();
        process.stdin.on('data', process.exit.bind(process, 0));
    });
    mainProgram();
}
catch (e) {
    console.log(e);
}
//# sourceMappingURL=app.js.map