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
const Golem_1 = require("./Golem");
const util_1 = require("util");
class K05 extends IExecutable_1.IExecutable {
    Question1(rl) {
        let salary = 19.0;
        let age = 22;
        while (salary < 50.0) {
            salary *= 1.035;
            age++;
        }
        console.log(util_1.format("%d歳で月給%d万円", age, salary));
        return new Promise((resolve, reject) => {
            resolve();
        });
    }
    Question2(rl) {
        try {
            let choice = 0;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    console.log("起きろ～");
                    rl.question("1．起きた　2．あと5分…　3．Zzzz…  入力：", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                while (choice != 1) {
                    yield q1();
                }
                console.log("よし、学校へ行こう！");
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question3(rl) {
        try {
            let choice = 0;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    console.log("起きろ～");
                    rl.question("1．起きた　2．あと5分…　3．Zzzz…\t入力：", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                while (true) {
                    yield q1();
                    if (choice == 1) {
                        console.log("よし、学校へ行こう！");
                    }
                }
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question4(rl) {
        try {
            let golem = new Golem_1.Golem(300 + Math.round(Math.random() * 200));
            let playerHp = 200 + Math.round(Math.random() * 100);
            console.log(util_1.format("ゴーレム　（HP：%d　防御力：%d）", golem.hp, golem.defense));
            console.log("HP：" + golem.hp);
            let choice = 0;
            let damage = 0;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let attackGolem = () => {
                return new Promise((resolve, reject) => {
                    switch (choice) {
                        case 1:
                            damage = 60 + Math.round(Math.random() * 40);
                            break;
                        case 2:
                            damage = 30 + Math.round(Math.random() * 100);
                            break;
                        case 3:
                            damage = 20 + Math.round(Math.random() * 180);
                            break;
                        default:
                            break;
                    }
                    console.log(util_1.format("基礎攻撃力は%dです。", damage));
                    damage -= golem.defense;
                    if (damage <= 0) {
                        damage = 0;
                        console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                        console.log(util_1.format("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.attack));
                        playerHp -= golem.attack;
                        if (playerHp <= 0) {
                            console.log("あなたはゴーレムに負けました！ゲームオーバー！");
                            resolve();
                        }
                        console.log("あなたの残りHPは：" + playerHp);
                    }
                    console.log(util_1.format("ダメージは%dです。", damage));
                    golem.hp -= damage;
                    if (golem.hp <= 0) {
                        golem.hp = 0;
                    }
                    console.log(util_1.format("残りのHPは%dです。", golem.hp));
                    if (golem.hp == 0) {
                        console.log("ゴーレムを倒しました！");
                    }
                    resolve();
                });
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                while (golem.hp > 0) {
                    yield q1();
                    yield attackGolem();
                }
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
}
exports.K05 = K05;
//# sourceMappingURL=K05.js.map