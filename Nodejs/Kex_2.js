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
const Kex_2_Battle_1 = require("./Kex_2_Battle");
const Kex_2_Enemy_1 = require("./Kex_2_Enemy");
const Player_1 = require("./Player");
class Kex_2 {
    static Execute(rl) {
        console.log('冒険が今始まる！');
        let player = new Player_1.PlayerEx();
        let continueGame = new Boolean(true);
        let kills = 0;
        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question('奥に進みますか？（１：奥に進む　０．帰る）＞', (value) => {
                    continueGame = new Boolean(Number.parseInt(value));
                    resolve(continueGame);
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            do {
                console.log(`現HP：${player.hp}`);
                yield question();
                if (continueGame.valueOf()) {
                    let type = Math.round(Math.random() * 2);
                    let enemy = Kex_2_Enemy_1.CreateEnemy(type);
                    let result;
                    yield Kex_2_Battle_1.AttackEnemy(player, enemy, rl).then((value) => {
                        kills++;
                        result = value;
                    });
                    if (!result) {
                        break;
                    }
                }
            } while (continueGame.valueOf());
            console.log('リ〇ミト！\n');
            console.log(`戦闘回数：${kills}回　残りHP：${player.hp}`);
            resolve();
        }));
    }
}
exports.Kex_2 = Kex_2;
//# sourceMappingURL=Kex_2.js.map