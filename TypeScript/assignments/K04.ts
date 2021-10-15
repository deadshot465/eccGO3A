import Executable from "../shared/Executable.ts"
import { getRandomNumber } from "../shared/Utility.ts";

export default class K04 extends Executable {
    question1(): void {
        const age = Number.parseInt(prompt("年齢を入力して下さい＞") ?? "0");
        if (age < 3 || age >= 70) {
            console.log("入場料金無料です。");
        } else {
            console.log("通常料金です。");
        }
    }

    question2(): void {
        const gender = Number.parseInt(prompt("性別を選択してください。（０：男性　１：女性）＞") ?? "2");
        switch (gender) {
            case 0:
                console.log("あら、格好良いですね。");
                break;
            case 1:
                console.log("あら、モデルさんみたいですね。");
                break;
            default:
                console.log("そんな選択肢はありません。");
                break;    
        }
    }

    question3(): void {
        const age = Number.parseInt(prompt("年齢を入力して下さい＞") ?? "0");

        if (age < 3 || age >= 70) {
            console.log("入場料金無料です。");
        } else if (age >= 3 && age <= 15) {
            console.log("子供料金で半額です。");
        } else if (age >= 60 && age < 70) {
            console.log("シニア割引で一割引きです。");
        } else {
            console.log("通常料金です。");
        }
    }

    question4(): void {
        console.log("＊＊＊おみくじプログラム＊＊＊");
        const choice = Number.parseInt(prompt("おみくじを引きますか　（はい：１　いいえ：０）　＞") ?? "0");

        if (choice == 0) return;

        const oracle = getRandomNumber(5);
        switch (oracle) {
            case 0:
                console.log("大吉　とってもいいことがありそう！！");
                break;
            case 1:
                console.log("中吉　きっといいことあるんじゃないかな");
                break;
            case 2:
                console.log("小吉　少しぐらいはいいことあるかもね");
                break;
            case 3:
                console.log("凶　今日はおとなしくておいた方がいいかも");
                break;
            case 4:
                console.log("大凶　これじゃやばくない？早く家に帰った方がいいかも");
                break;
            default:
                break;
        }
    }
}