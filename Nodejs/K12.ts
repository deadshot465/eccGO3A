import { IExecutable } from "./IExecutable";
import * as readline from "readline";
import { format } from "util";

class Person {
    name: string;
    birthYear: number;
    height: number;
    weight: number;
}

class Staff {
    name: string;
    gender: string;
    age: number;

    constructor(name: string, gender: string, age: number) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

class Position {
    x: number;
    y: number;
    distance: number;
}

export class K12 extends IExecutable {

    Question1(rl?: readline.ReadLine): Promise<string> {
        let person = new Person();

        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("名前を入力してください＞",
                    (value) => {
                        person.name = value;
                        resolve();
                    });
            });
        };

        let q2 = () => {
            return new Promise((resolve, reject) => {
                rl.question("生年（西暦）を入力してください＞",
                    (value) => {
                        person.birthYear = Number.parseInt(value);
                        resolve();
                    });
            });
        };

        let q3 = () => {
            return new Promise((resolve, reject) => {
                rl.question("身長を入力してください＞",
                    (value) => {
                        person.height = Number.parseFloat(value);
                        resolve();
                    });
            });
        };

        let q4 = () => {
            return new Promise((resolve, reject) => {
                rl.question("体重を入力してください＞",
                    (value) => {
                        person.weight = Number.parseFloat(value);
                        resolve();
                    });
            });
        };

        return new Promise(async (resolve, reject) => {
            await q1();
            await q2();
            await q3();
            await q4();

            console.log("プロファイル：");
            console.log(`名前：${person.name}`);
            console.log(`生年：${person.birthYear}`);
            console.log(`身長：${person.height}`);
            console.log(`体重：${person.weight}`);

            resolve();
        });
    }

    Question2(rl?: readline.ReadLine): Promise<string> {
        let staffs = [
            new Staff("神木隆之介", 'M', 23),
            new Staff("上白石萌音", 'F', 18),
            new Staff("長澤まさみ", 'F', 28)
        ];

        console.log("名前\t\t性別\t年齢");
        for (let i = 0; i <= 35; ++i) {
            process.stdout.write("-");
        }
        console.log();

        for (let staff of staffs) {
            console.log(`${staff.name}\t${staff.gender}\t${staff.age}歳`);
        }

        return new Promise((resolve, reject) => {
            resolve();
        });
    }

    GetDistance(playerPos: Position, enemyPos: Position) {
        let diffX = playerPos.x - enemyPos.x;
        let diffY = playerPos.y - enemyPos.y;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    Question3(rl?: readline.ReadLine): Promise<string> {
        let getRandomNumber = () => {
            return Math.round(Math.random() * 100) - 50;
        }
        let playerPos = new Position();
        playerPos.x = getRandomNumber();
        playerPos.y = getRandomNumber();
        playerPos.distance = 0.0;

        let enemyPos = new Array<Position>(5);

        return new Promise((resolve, reject) => {
            for (let i = 0; i < enemyPos.length; i++) {
                let pos = new Position();
                pos.x = getRandomNumber();
                pos.y = getRandomNumber();
                pos.distance = this.GetDistance(playerPos, pos);
                enemyPos[i] = pos;
            }

            console.log(`プレーヤーの座標：x= ${playerPos.x}\t\ty= ${playerPos.y}\n`);
            for (let i = 0; i < enemyPos.length; i++) {

                let str = format("敵キャラの座標0%d：x= %d\t\ty= %d\t\t距離=%d",
                    i,
                    enemyPos[i].x,
                    enemyPos[i].y,
                    Math.round(enemyPos[i].distance *
                        100) /
                    100);

                console.log(str);
            }
            resolve();
        });
    }

    Question4(rl?: readline.ReadLine): Promise<string> {
        let getRandomNumber = () => {
            return Math.round(Math.random() * 100) - 50;
        }
        let playerPos = new Position();
        playerPos.x = getRandomNumber();
        playerPos.y = getRandomNumber();
        playerPos.distance = 0.0;

        let enemyPos = new Array<Position>(5);

        return new Promise((resolve, reject) => {
            for (let i = 0; i < enemyPos.length; i++) {
                let pos = new Position();
                pos.x = getRandomNumber();
                pos.y = getRandomNumber();
                pos.distance = this.GetDistance(playerPos, pos);
                enemyPos[i] = pos;
            }

            console.log(`プレーヤーの座標：x= ${playerPos.x}\t\ty= ${playerPos.y}\n`);
            for (let i = 0; i < enemyPos.length; i++) {
                console.log(
                    `敵キャラの座標0${i}：x= ${enemyPos[i].x}\t\ty= ${enemyPos[i].y}\t\t距離=${Math.round(enemyPos[i].distance *
                        100) /
                    100}`);
            }

            console.log("\n並び替え後");
            enemyPos.sort((curr: Position, next: Position) => {
                return curr.distance >= next.distance ? 1 : -1;
            });
            for (let i = 0; i < enemyPos.length; i++) {
                console.log(
                    `敵キャラの座標0${i}：x= ${enemyPos[i].x}\t\ty= ${enemyPos[i].y}\t\t距離=${Math.round(enemyPos[i].distance *
                        100) /
                    100}`);
            }

            resolve();
        });
    }
}