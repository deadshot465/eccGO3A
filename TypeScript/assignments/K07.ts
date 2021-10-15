import Executable from "../shared/Executable.ts"

export default class K07 extends Executable {
    question1(): void {
        let choice = 0;
        do {
            choice = Number.parseInt(prompt("メッセージを表示しますか？（０：終了する　１：表示する）＞") ?? "0");
            if (choice === 1)
                this.showTexts();
        } while (choice != 0);
        console.log("終了します。");
    }

    question2(): void {
        const numbers = [0, 0, 0];
        for (let i = 0; i < 3; i++) {
            numbers[i] = Number.parseInt(prompt(`${i + 1}つ目の値を入力してください。＞`) ?? "0");
        }
        console.log(`${numbers.length}つの中で最大値は${Math.max(...numbers)}です。`);
    }

    question3(): void {
        const age = Number.parseInt(prompt("年齢を入力して下さい。＞") ?? "0");
        console.log(this.getAgeTier(age));
    }

    question4(): void {
        return;
    }

    private showTexts() {
        console.log("Hello World!");
        console.log("ようこそ");
        console.log("TypeScript言語の世界へ！");
    }

    private getMaxValue(value1: number, value2: number, value3: number): number {
        let temp = value1 >= value2 ? value1 : value2;
        temp = temp >= value3 ? temp : value3;
        return temp;
    }

    private getAgeTier(age: number): string {
        if (age <= 0)
            return "不適切な値が入力されました。";
        else if (age < 3 || age >= 70)
            return "入場料金無料です。";
        else if (age >= 3 && age <= 15)
            return "子供料金で半額です。";
        else if (age >= 60 && age < 70)
            return "シニア割引で一割引きです。";
        else
            return "通常料金です。";
    } 
}