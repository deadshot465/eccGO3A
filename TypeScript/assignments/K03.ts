import Executable from "../shared/Executable.ts"
import { getRandomNumber } from "../shared/Utility.ts";

export default class K03 extends Executable {
    question1(): void {
        const age = Number.parseInt(prompt("年齢を入力して下さい＞") ?? "0");
        if (age < 20) {
            console.log("未成年なので購入できません。");
        }
    }

    question2(): void {
        const height = Number.parseFloat(prompt("身長を入力して下さい＞") ?? "0.0") / 100.0;
        const weight = Number.parseFloat(prompt("体重を入力して下さい＞") ?? "0");
        const standard = height * height * 22.0;
        console.log(`あなたの標準体重は${standard}です。`);

        if (weight > standard && (weight - standard) / standard * 100.0 > 14.0) {
            console.log("太り気味です。");
        } else if (weight < standard && (weight - standard) / standard * 100.0 < -14.0) {
            console.log("痩せ気味です。");
        } else {
            console.log("普通ですね。");
        }
    }

    question3(): void {
        const randomNumber = getRandomNumber(100);
        console.log("０から９９の範囲の数値が決定されました。");
        const guess = Number.parseInt(prompt("決められた数値を予想し、この数値よりも大きな値を入力してください＞") ?? "0");
        console.log(`決められた数値は${randomNumber}です。`);
        console.log(guess > randomNumber ? "正解です。" : "不正解です。");
    }

    question4(): void {
        const randomNumber = getRandomNumber(100);
        console.log("０から９９の範囲の数値が決定されました。");
        const guess = Number.parseInt(prompt("決められた数値を予想し、この数値よりも大きな値を入力してください＞") ?? "0");
        console.log(`決められた数値は${randomNumber}です。`);

        if (guess > 100 || guess < 0) {
            console.log("反則です！");
        } else if (guess > randomNumber && guess - randomNumber <= 10) {
            console.log("大正解です！");
        } else if (guess < randomNumber && randomNumber - guess <= 10) {
            console.log("惜しい！");
        } else if (guess == randomNumber) {
            console.log("お見事！");
        } else {
            console.log(guess > randomNumber ? "正解です。" : "不正解です。");
        }
    }
}