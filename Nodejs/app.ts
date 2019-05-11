import * as readline from 'readline';
import { K01 } from './K01';
import { K02 } from './K02';
import { K03 } from './K03';
import { K04 } from './K04';
import { K05 } from './K05';
import { K06 } from './K06';
import { K07 } from './K07';
import { K08 } from './K08';
import { FileControl } from './FileControl';
import { IExecutable } from './IExecutable';

function ShowSelections(chapter: number) {
    for (let i = 1; i < 5; i++) {
        console.log("\t" + i + ") K0" + chapter + "_" + i);
    }
}

var executables: Array<IExecutable> = new Array<IExecutable>();
executables[0] = new K01();
executables[1] = new K02();
executables[2] = new K03();
executables[3] = new K04();
executables[4] = new K05();
executables[5] = new K06();
executables[6] = new K07();
executables[7] = new K08();
executables[8] = new FileControl();

console.log("実行したいプログラムを選択してください。\n");

for (let i = 1; i <= executables.length; i++) {
    console.log(i + ") K0" + i);
}

try {
    let rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let choice: number;
    let choice2: number;

    let selectChapter = () => {
        return new Promise<string>((resolve, reject) => {
            rl.question("", (value) => {
                choice = Number.parseInt(value);
                ShowSelections(choice);
                resolve();
            });
        });
    };

    let selectQuestions = () => {
        return new Promise<string>((resolve, reject) => {
            rl.question("", (value) => {
                choice2 = Number.parseInt(value);
                resolve();
            });
        });
    };

    let executeQuestion = () => {
        return new Promise<string>(async (resolve, reject) => {
            await executables[choice - 1].Execute(choice2, rl);
            resolve();
        });
    };

    let mainProgram = async () => {
        await selectChapter();
        await selectQuestions();
        await executeQuestion();
        rl.close();
        process.stdin.setRawMode(true);
        process.stdin.resume();
        process.stdin.on('data', process.exit.bind(process, 0));
    };

    mainProgram();
    
} catch (e) {
    console.log(e);
}