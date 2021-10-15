import Executable from "../../shared/Executable.ts"
import { gameLoop } from "./Adventure.ts";
import { getRandomNumber } from "../../shared/Utility.ts";

export default class K08 extends Executable {
    question1(): void {
        const numbers = [0, 0, 0];
        for (let i = 0; i < 3; i++) {
            numbers[i] = Number.parseInt(prompt(`${i + 1}つ目の値を入力してください。＞`) ?? "0");
        }
        console.log("どちらを調べますか？");
        
        switch (Number.parseInt(prompt("（０：最大値　１：最小値）＞") ?? "0")) {
            case 0:
                console.log(`${numbers.length}つの中で最大値は${Math.max(...numbers)}です。`);
                break;
            case 1:
                console.log(`${numbers.length}つの中で最小値は${Math.min(...numbers)}です。`);
                break;
            default:
                break;
        }
    }

    question2(): void {
        console.log("冒険が今始まる！");
        const playerHp = 200 + getRandomNumber(101);
        console.log(gameLoop(playerHp));
    }

    question3(): void {
        return;
    }

    question4(): void {
        return;
    } 
}