import Executable from "../shared/Executable.ts"
import Golem from "../shared/Golem.ts";

export default class K02 extends Executable {
    question1(): void {
        const seisuu = 3;
        const jissuu = 2.6;
        const moji = 'A';

        console.log("整数seisuuの値は" + seisuu);
        console.log("実数jissuuの値は" + jissuu);
        console.log("文字mojiの値は" + moji);
    }

    question2(): void {
        const firstNumber = Number.parseInt(prompt("一つ目の整数は？") ?? "0");
        const secondNumber = Number.parseInt(prompt("二つ目の整数は？") ?? "0");
        console.log(`${firstNumber} ÷ ${secondNumber} = ${Math.trunc(firstNumber / secondNumber)}...${firstNumber % secondNumber}`);
    }

    question3(): void {
        const priceA = Number.parseFloat(prompt("一つ目の商品の値段は？") ?? "0.0");
        const amountA = Number.parseFloat(prompt("個数は？") ?? "0.0");
        const priceB = Number.parseFloat(prompt("二つ目の商品の値段は？") ?? "0.0");
        const amountB = Number.parseFloat(prompt("個数は？") ?? "0.0");
        const total = (priceA * amountA + priceB * amountB) * 1.1;
        console.log(`お支払いは税込み￥${total}です。`);
    }

    question4(): void {
        const golem: Golem = {
            hp: 300,
            defense: 80,
            attack: 50
        };

        console.log(`ゴーレム　（HP：${golem.hp}　防御力：${golem.defense}）`);
        console.log("HP：" + golem.hp);

        let atk = Number.parseInt(prompt("今回の攻撃の値を入力してください＞") ?? "0");
        atk = atk - golem.defense < 0 ? 0 : atk - golem.defense;
        console.log(`ダメージは${atk}です`);
        golem.hp -= atk;
        console.log(`残りのHPは${golem.hp}です`);
    }
}