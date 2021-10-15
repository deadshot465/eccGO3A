import { questions } from "./assignments/index.ts";

function showSelection(chapter: number) {
    if (chapter < 10) {
        for (let i = 0; i < 4; i++) {
            console.log(`\t${i + 1}) K0${chapter}_${i + 1}`);
        }

        if (chapter == 9) {
            console.log(`\t5) K0${chapter}_5`);
        }
    } else {
        for (let i = 0; i < 4; i++) {
            console.log(`\t${i + 1}) K${chapter}_${i + 1}`);
        }
    }
}

console.log("実行したいプログラムを選択してください。");

for (let i = 0; i < questions.length; i++) {
    if (i < 10) {
        console.log(`${i + 1}) K0${i + 1}`);
    } else {
        const adjustedNumber = i >= 12 ? i + 3 : i;
        console.log(`${i + 1}) K0${adjustedNumber}`);
    }
}

console.log("100) Kex_1");
console.log("101) Kex_2");
console.log("102) Sort");

const choice = Number.parseInt(prompt("") ?? "0");
switch (choice) {
    case 100:
    case 101:
    case 102:
        break;
    default:
        {
            showSelection(choice);
            const choice2 = Number.parseInt(prompt("") ?? "0");
            questions[choice - 1].execute(choice2);
            break;
        }
}