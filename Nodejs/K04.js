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
class K04 extends IExecutable_1.IExecutable {
    Question1(rl) {
        try {
            let age;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("年齢を入力して下さい＞", (value) => {
                        age = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
                    if (age < 3 || age >= 70) {
                        console.log("入場料金無料です。");
                    }
                    else {
                        console.log("通常料金です。");
                    }
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question2(rl) {
        try {
            let gender;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("性別を選択してください。（０：男性　１：女性）＞", (value) => {
                        gender = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
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
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question3(rl) {
        try {
            let age;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("年齢を入力して下さい＞", (value) => {
                        age = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
                    if (age < 3 || age >= 70) {
                        console.log("入場料金無料です。");
                    }
                    else if (age >= 3 && age <= 15) {
                        console.log("子供料金で半額です。");
                    }
                    else if (age >= 60 && age < 70) {
                        console.log("シニア割引で一割引きです。");
                    }
                    else {
                        console.log("通常料金です。");
                    }
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
    Question4(rl) {
        try {
            console.log("＊＊＊おみくじプログラム＊＊＊");
            let choice;
            let q1 = () => {
                return new Promise((resolve, reject) => {
                    rl.question("おみくじを引きますか　（はい：１　いいえ：０）　＞", (value) => {
                        choice = Number.parseInt(value);
                        resolve();
                    });
                });
            };
            let showResult = () => {
                return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                    yield q1();
                    if (choice >= 1) {
                        let oracle = Math.floor(Math.random() * 4);
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
                    resolve();
                }));
            };
            return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
                yield showResult();
                resolve();
            }));
        }
        catch (e) {
            console.error(e);
        }
    }
}
exports.K04 = K04;
//# sourceMappingURL=K04.js.map