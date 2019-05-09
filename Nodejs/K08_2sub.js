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
const util_1 = require("util");
function AttackGolem(lv, playerHp, rl) {
    try {
        var golem = new Golem_1.Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30);
        console.log(util_1.format("ゴーレムLv.%dが現れた！", lv + 1));
        let choice = 0;
        let selectAttackMethod = () => {
            return new Promise((resolve, reject) => {
                rl.question("武器を選択してください（１．攻撃　２．特技　３．魔法）＞", (value) => {
                    choice = Number.parseInt(value);
                    resolve();
                });
            });
        };
        return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
            while (golem.hp > 0) {
                console.log(util_1.format("\n残りHP：%d", golem.hp));
                yield selectAttackMethod();
                let damage = 0;
                switch (choice) {
                    case 1:
                        damage = Number(AttackMethod.Attack);
                        break;
                    case 2:
                        damage = Number(AttackMethod.Skill);
                        break;
                    case 3:
                        damage = Number(AttackMethod.Magic);
                        break;
                    default:
                        break;
                }
                damage -= golem.defense;
                if (damage <= 0) {
                    damage = 0;
                    console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
                    console.log(util_1.format("ゴーレムがあなたを攻撃しました！攻撃値：%d", golem.attack));
                    playerHp = DamagePlayer(playerHp, golem.attack);
                    if (playerHp <= 0) {
                        playerHp = 0;
                        console.log("あなたはゴーレムに負けました！ゲームオーバー！");
                        resolve(playerHp);
                        return;
                    }
                    console.log(util_1.format("あなたの残りHPは：%d", playerHp));
                }
                console.log(util_1.format("ダメージは%dです。", damage));
                golem.hp -= damage;
                if (golem.hp <= 0)
                    golem.hp = 0;
                if (golem.hp == 0)
                    console.log(util_1.format("ゴーレムLv.%dを倒した！", lv + 1));
            }
            resolve(playerHp);
        }));
    }
    catch (e) {
        console.error(e);
    }
}
exports.AttackGolem = AttackGolem;
var AttackMethod;
(function (AttackMethod) {
    AttackMethod[AttackMethod["Attack"] = 65] = "Attack";
    AttackMethod[AttackMethod["Skill"] = 99] = "Skill";
    AttackMethod[AttackMethod["Magic"] = 133] = "Magic";
})(AttackMethod || (AttackMethod = {}));
function DamagePlayer(playerHp, attackPower) {
    return playerHp - attackPower;
}
//# sourceMappingURL=K08_2sub.js.map