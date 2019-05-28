import * as readline from 'readline';
import { K01 } from './K01';
import { K02 } from './K02';
import { K03 } from './K03';
import { K04 } from './K04';
import { K05 } from './K05';
import { K06 } from './K06';
import { K07 } from './K07';
import { K08 } from './K08';
import { K09 } from "./K09";
import { K10 } from "./K10";
import { K11 } from "./K11";
import { Kex } from "./Kex";
import { FileControl } from './FileControl';
import { IExecutable } from './IExecutable';

function ShowSelections(chapter: number) {
    if (chapter < 10) {
        for (let i = 1; i < 5; i++) {
            console.log("\t" + i + ") K0" + chapter + "_" + i);
        }
        if (chapter == 9) {
            console.log(`\t5) K0${chapter}_5`);
        }
    } else {
        for (let i = 1; i < 5; i++) {
            console.log("\t" + i + ") K" + chapter + "_" + i);
        }
    }
}

var executables: Array<IExecutable> = [
    new K01(), new K02(), new K03(), new K04(), new K05(),
    new K06(), new K07(), new K08(), new K09(), new K10(),
    new K11(), new FileControl()
];

console.log("実行したいプログラムを選択してください。\n");

for (let i = 1; i <= executables.length; i++) {
    if (i < 10) {
        console.log(i + ") K0" + i);
    } else {
        console.log(i + ") K" + i);
    }
}
console.log("100) Kex");

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
                if (choice !== 100) {
                    ShowSelections(choice);
                }
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
        if (choice === 100) {
            let kex = new Kex();
            await kex.Execute(rl);
        } else {
            await selectQuestions();
            await executeQuestion();
        }
        
        rl.close();
        process.stdin.setRawMode(true);
        process.stdin.resume();
        process.stdin.on('data', process.exit.bind(process, 0));
    };

    mainProgram();
    
} catch (e) {
    console.log(e);
}