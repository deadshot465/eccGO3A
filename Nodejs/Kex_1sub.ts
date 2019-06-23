import { GolemEx } from "./Golem";
import { PlayerEx } from "./Player"
import * as readline from "readline";

export const ATTACK_HIT = 110;
export const SKILL_HIT = 100;
export const MAGIC_HIT = 70;

export function CheckHitOrMiss(hit: number) {
    let value = Math.round(Math.random() * 99);
    return value <= hit - 1;
}

export function AttackGolem(lv: number, player: PlayerEx, rl?: readline.ReadLine): Promise<any> {
    let golem = new GolemEx(
        lv * 50 + 100,
        lv * 10 + 40,
        lv * 10 + 40
    );

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

    return new Promise(async (resolve, reject) => {
        while (golem.hp > 0) {
            console.log(`ゴーレム 残りHP：${golem.hp}`);
            await question();
            let damage = 0;
            let is_hit = false;

            switch (choice) {
                case 1:
                    damage = 60 + Math.round(Math.random() * 40);
                    is_hit = CheckHitOrMiss(ATTACK_HIT - golem.flee);
                    break;
                case 2:
                    damage = 30 + Math.round(Math.random() * 100);
                    is_hit = CheckHitOrMiss(SKILL_HIT - golem.flee);
                    break;
                case 3:
                    damage = 20 + Math.round(Math.random() * 180);
                    is_hit = CheckHitOrMiss(MAGIC_HIT - golem.flee);
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
            } else { 
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
            } else {
                console.log("攻撃を外した！");
            }

            console.log(`プレイヤー残りHP：${player.hp}`);

            if (golem.hp <= 0)
                golem.hp = 0;
            if (golem.hp === 0)
                console.log(`ゴーレムLv.${lv + 1}を倒した！`);
        }
        resolve();
    });
}