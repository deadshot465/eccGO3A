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
const Player_1 = require("./Player");
const Kex_1sub_1 = require("./Kex_1sub");
class Kex {
    Execute(rl) {
        console.log("冒険が今始まる！");
        let player = new Player_1.PlayerEx();
        let kills = 0;
        let continue_game = true;
        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question("奥に進みますか？（１：奥に進む　０．帰る）＞", (value) => {
                    continue_game = Boolean(Number.parseInt(value));
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            do {
                console.log(`\n現HP：${player.hp}`);
                yield question();
                if (continue_game) {
                    let golemLv = Math.floor(Math.random() * 4);
                    player = yield Kex_1sub_1.AttackGolem(golemLv, player, rl).then((x) => {
                        return x;
                    });
                    ++kills;
                    if (player.hp === 0) {
                        break;
                    }
                }
            } while (continue_game);
            console.log("リ〇ミト！\n");
            console.log(`戦闘回数：${kills}　残りHP：${player.hp}`);
            resolve();
        }));
    }
}
exports.Kex = Kex;
//# sourceMappingURL=Kex.js.map