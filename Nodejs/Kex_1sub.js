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
const Golem_1 = require("./Golem");
exports.ATTACK_HIT = 110;
exports.SKILL_HIT = 100;
exports.MAGIC_HIT = 70;
function CheckHitOrMiss(hit) {
    let value = Math.round(Math.random() * 99);
    return value <= hit - 1;
}
exports.CheckHitOrMiss = CheckHitOrMiss;
function AttackGolem(lv, player, rl) {
    let golem = new Golem_1.GolemEx(lv * 50 + 100, lv * 10 + 40, lv * 10 + 40);
    console.log(`ゴーレムLv.${lv + 1}が現れた！`);
    let choice = 0;
    let question = () => {
        return new Promise((resolve, reject) => {
            rl.question("武器を選択してください（１．攻撃　２．特技　３．魔法）＞", (value) => {
                choice = Number.parseInt(value);
                resolve();
            });
        });
    };
    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
        while (golem.hp > 0) {
            console.log(`ゴーレム 残りHP：${golem.hp}`);
            yield question();
            let damage = 0;
            let is_hit = false;
            switch (choice) {
                case 1:
                    damage = 60 + Math.round(Math.random() * 40);
                    is_hit = CheckHitOrMiss(exports.ATTACK_HIT - golem.flee);
                    break;
                case 2:
                    damage = 30 + Math.round(Math.random() * 100);
                    is_hit = CheckHitOrMiss(exports.SKILL_HIT - golem.flee);
                    break;
                case 3:
                    damage = 20 + Math.round(Math.random() * 180);
                    is_hit = CheckHitOrMiss(exports.MAGIC_HIT - golem.flee);
                    break;
                default:
                    break;
            }
            if (is_hit) {
                damage -= golem.defense;
                if (damage <= 0)
                    damage = 0;
                console.log(`${damage}のダメージ！`);
                golem.hp -= damage;
            }
            else {
                console.log("攻撃を外した！");
            }
            console.log("ゴーレムの攻撃！");
            is_hit = CheckHitOrMiss(golem.hit);
            if (is_hit) {
                let injury = golem.attack - player.defense;
                console.log(`${injury}のダメージ！`);
                player.hp -= injury;
                if (player.hp <= 0) {
                    player.hp = 0;
                    console.log("あなたはゴーレムに負けました！ゲームオーバー！");
                    resolve();
                    return;
                }
            }
            else {
                console.log("攻撃を外した！");
            }
            console.log(`プレイヤー残りHP：${player.hp}`);
            if (golem.hp <= 0)
                golem.hp = 0;
            if (golem.hp === 0)
                console.log(`ゴーレムLv.${lv + 1}を倒した！`);
        }
        resolve();
    }));
}
exports.AttackGolem = AttackGolem;
//# sourceMappingURL=Kex_1sub.js.map