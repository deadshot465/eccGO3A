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
const Attack_1 = require("./Attack");
const Kex_1sub_1 = require("./Kex_1sub");
function AttackEnemy(player, enemy, rl) {
    console.log(`${enemy.Name}Lv.${enemy.Lv + 1}が現れた！`);
    let choice;
    let chooseAttack = () => {
        return new Promise((resolve, reject) => {
            rl.question('武器を選択してください（１．攻撃　２．特技　３．魔法）＞', (value) => {
                choice = Number.parseInt(value);
                resolve(choice);
            });
        });
    };
    return new Promise((resolve, reject) => __awaiter(this, void 0, void 0, function* () {
        while (enemy.Hp > 0) {
            console.log(`${enemy.Name} 残りHP：${enemy.Hp}`);
            yield chooseAttack();
            let getAttackPower = () => Math.round(Math.random() * 40 + 60);
            let getSkillPower = () => Math.round(Math.random() * 100 + 30);
            let getMagicPower = () => Math.round(Math.random() * 180 + 20);
            let attacks = new Array(3);
            let getPowers = [getAttackPower, getSkillPower, getMagicPower];
            let getHits = [Kex_1sub_1.ATTACK_HIT, Kex_1sub_1.SKILL_HIT, Kex_1sub_1.MAGIC_HIT];
            for (let i = 0; i < attacks.length; i++) {
                attacks[i] = new Attack_1.Attack(getPowers[i](), getHits[i]);
            }
            let damage = 0;
            let isHit = false;
            switch (choice) {
                case 1:
                    damage = attacks[0].Damage;
                    isHit = Kex_1sub_1.CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
                    break;
                case 2:
                    damage = attacks[1].Damage;
                    isHit = Kex_1sub_1.CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
                    break;
                case 3:
                    damage = attacks[2].Damage;
                    isHit = Kex_1sub_1.CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
                    break;
            }
            if (isHit) {
                damage -= enemy.Defense;
                damage = damage <= 0 ? 0 : damage;
                console.log(`${damage}のダメージ！`);
                enemy.Hp -= damage;
            }
            else {
                console.log('攻撃を外した！');
            }
            console.log(`${enemy.Name}の攻撃！`);
            isHit = Kex_1sub_1.CheckHitOrMiss(enemy.Hit);
            if (isHit) {
                let injury = enemy.Attack - player.defense;
                injury = injury <= 0 ? 0 : injury;
                console.log(`${injury}のダメージ！`);
                player.hp -= injury;
                if (player.hp <= 0) {
                    player.hp = 0;
                    console.log(`あなたは${enemy.Name}に負けました！ゲームオーバー！`);
                    resolve(false);
                    return;
                }
            }
            else {
                console.log('攻撃を外した！');
            }
            console.log(`プレーヤー残りHP：${player.hp}`);
            enemy.Hp = enemy.Hp <= 0 ? 0 : enemy.Hp;
            if (enemy.Hp === 0) {
                console.log(`${enemy.Name}Lv.${enemy.Lv + 1}を倒した！`);
            }
        }
        resolve(true);
    }));
}
exports.AttackEnemy = AttackEnemy;
//# sourceMappingURL=Kex_2_Battle.js.map