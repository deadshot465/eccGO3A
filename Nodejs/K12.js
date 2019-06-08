"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const IExecutable_1 = require("./IExecutable");
const util_1 = require("util");
class Person {
}
class Staff {
    constructor(name, gender, age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
class Position {
}
class K12 extends IExecutable_1.IExecutable {
    Question1(rl) {
        let person = new Person();
        let q1 = () => {
            return new Promise((resolve, reject) => {
                rl.question("名前を入力してください＞", (value) => {
                    person.name = value;
                    resolve();
                });
            });
        };
        let q2 = () => {
            return new Promise((resolve, reject) => {
                rl.question("生年（西暦）を入力してください＞", (value) => {
                    person.birthYear = Number.parseInt(value);
                    resolve();
                });
            });
        };
        let q3 = () => {
            return new Promise((resolve, reject) => {
                rl.question("身長を入力してください＞", (value) => {
                    person.height = Number.parseFloat(value);
                    resolve();
                });
            });
        };
        let q4 = () => {
            return new Promise((resolve, reject) => {
                rl.question("体重を入力してください＞", (value) => {
                    person.weight = Number.parseFloat(value);
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            yield q1();
            yield q2();
            yield q3();
            yield q4();
            console.log("プロファイル：");
            console.log(`名前：${person.name}`);
            console.log(`生年：${person.birthYear}`);
            console.log(`身長：${person.height}`);
            console.log(`体重：${person.weight}`);
            resolve();
        }));
    }
    Question2(rl) {
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
    GetDistance(playerPos, enemyPos) {
        let diffX = playerPos.x - enemyPos.x;
        let diffY = playerPos.y - enemyPos.y;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }
    Question3(rl) {
        let getRandomNumber = () => {
            return Math.round(Math.random() * 100) - 50;
        };
        let playerPos = new Position();
        playerPos.x = getRandomNumber();
        playerPos.y = getRandomNumber();
        playerPos.distance = 0.0;
        let enemyPos = new Array(5);
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
                let str = util_1.format("敵キャラの座標0%d：x= %d\t\ty= %d\t\t距離=%d", i, enemyPos[i].x, enemyPos[i].y, Math.round(enemyPos[i].distance *
                    100) /
                    100);
                console.log(str);
            }
            resolve();
        });
    }
    Question4(rl) {
        let getRandomNumber = () => {
            return Math.round(Math.random() * 100) - 50;
        };
        let playerPos = new Position();
        playerPos.x = getRandomNumber();
        playerPos.y = getRandomNumber();
        playerPos.distance = 0.0;
        let enemyPos = new Array(5);
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
                console.log(`敵キャラの座標0${i}：x= ${enemyPos[i].x}\t\ty= ${enemyPos[i].y}\t\t距離=${Math.round(enemyPos[i].distance *
                    100) /
                    100}`);
            }
            console.log("\n並び替え後");
            enemyPos.sort((curr, next) => {
                return curr.distance >= next.distance ? 1 : -1;
            });
            for (let i = 0; i < enemyPos.length; i++) {
                console.log(`敵キャラの座標0${i}：x= ${enemyPos[i].x}\t\ty= ${enemyPos[i].y}\t\t距離=${Math.round(enemyPos[i].distance *
                    100) /
                    100}`);
            }
            resolve();
        });
    }
}
exports.K12 = K12;
//# sourceMappingURL=K12.js.map