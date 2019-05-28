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
const K09_1 = require("./K09");
const K10_1 = require("./K10");
const K11_1 = require("./K11");
const Kex_1 = require("./Kex");
const FileControl_1 = require("./FileControl");
function ShowSelections(chapter) {
    if (chapter < 10) {
        for (let i = 1; i < 5; i++) {
            console.log("\t" + i + ") K0" + chapter + "_" + i);
        }
        if (chapter == 9) {
            console.log(`\t5) K0${chapter}_5`);
        }
    }
    else {
        for (let i = 1; i < 5; i++) {
            console.log("\t" + i + ") K" + chapter + "_" + i);
        }
    }
}
var executables = [
    new K01_1.K01(), new K02_1.K02(), new K03_1.K03(), new K04_1.K04(), new K05_1.K05(),
    new K06_1.K06(), new K07_1.K07(), new K08_1.K08(), new K09_1.K09(), new K10_1.K10(),
    new K11_1.K11(), new FileControl_1.FileControl()
];
console.log("実行したいプログラムを選択してください。\n");
for (let i = 1; i <= executables.length; i++) {
    if (i < 10) {
        console.log(i + ") K0" + i);
    }
    else {
        console.log(i + ") K" + i);
    }
}
console.log("100) Kex");
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
                if (choice !== 100) {
                    ShowSelections(choice);
                }
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
        if (choice === 100) {
            let kex = new Kex_1.Kex();
            yield kex.Execute(rl);
        }
        else {
            yield selectQuestions();
            yield executeQuestion();
        }
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