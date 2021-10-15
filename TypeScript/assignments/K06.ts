import Executable from "../shared/Executable.ts"
import { writeToStdout } from "../shared/Utility.ts";

export default class K06 extends Executable {
    question1(): void {
        const ages = new Array<number>();
        
        for (let i = 0; i < 5; i++) {
            ages.push(Number.parseInt(prompt(`${i + 1}人目の年齢を入力して下さい：`) ?? "0"));
        }

        const sum = ages.reduce((prev, curr) => prev + curr);
        console.log(`${ages.length}人の平均年齢は${sum / ages.length}です。`);
    }

    question2(): void {
        let arr = new Array<string>();
        for (let i = 0; i < 8; i++) {
            const line = new Array<string>();
            for (let j = 0; j < i + 1; j++) {
                line.push('*');
            }
            line.push('\n');
            arr.push(line.join(''));
        }
        console.log(arr.join(''));

        arr = [];
        for (let i = 8; i > 0; i--) {
            const line = new Array<string>();
            for (let j = 0; j < i; j++) {
                line.push('*');
            }
            line.push('\n');
            arr.push(line.join(''));
        }
        console.log(arr.join(''));

        arr = [];
        for (let i = 9; i > 0; i--) {
            const line = new Array<string>();
            for (let j = 0; j < i - 1; j++) {
                line.push(' ');
            }

            for (let k = 8; k > i - 1; k--) {
                line.push('*');
            }
            line.push('\n');
            arr.push(line.join(''));
        }
        console.log(arr.join(''));
    }

    question3(): void {
        const total = 370;
        let count = 0;

        for (let i = 0; i <= Math.trunc(total / 100); i++) {
            for (let j = 0; j <= Math.trunc(total / 50); j++) {
                for (let k = 0; k <= Math.trunc(total / 10); k++) {
                    if (100 * i + 50 * j + 10 * k == total) {
                        console.log(`10円の硬貨${k}枚 50円の硬貨${j}枚 100円の硬貨${i}枚`);
                        count++;
                    }
                }
            }
        }

        console.log("\n以上" + count + "通りを発見しました。");
    }

    question4(): void {
        writeToStdout('\t|\t');
        
        let line = '';
        for (let i = 1; i < 10; i++) {
            line += (i + '\t');
        }
        console.log(line);

        line = '';
        for (let i = 0; i < 85; i++) {
            line += '-';
        }
        console.log(line);

        for (let i = 1; i < 10; i++) {
            line = i + '\t|\t';
            for (let j = 1; j < 10; j++) {
                line += (i * j) + '\t';
            }
            console.log(line);
        }
    }
}