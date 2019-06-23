import * as readline from 'readline';
import { Attack } from './Attack';
import { ATTACK_HIT, SKILL_HIT, MAGIC_HIT, CheckHitOrMiss } from './Kex_1sub';
import { Enemy } from './Enemy';
import { PlayerEx } from './Player';

export function AttackEnemy(player: PlayerEx, enemy: Enemy, rl?: readline.ReadLine) {
    console.log(`${enemy.Name}Lv.${enemy.Lv + 1}が現れた！`);

    let choice: number;

    let chooseAttack = () => {
        return new Promise<number>((resolve, reject) => {
            rl.question('武器を選択してください（１．攻撃　２．特技　３．魔法）＞', (value) => {
                choice = Number.parseInt(value);
                resolve(choice);
            });
        });
    };

    return new Promise<boolean>(async (resolve, reject) => {

        while (enemy.Hp > 0) {
            console.log(`${enemy.Name} 残りHP：${enemy.Hp}`);

            await chooseAttack();
            let getAttackPower = () => Math.round(Math.random() * 40 + 60);
            let getSkillPower = () => Math.round(Math.random() * 100 + 30);
            let getMagicPower = () => Math.round(Math.random() * 180 + 20);
            let attacks = new Array<Attack>(3);
            let getPowers = [getAttackPower, getSkillPower, getMagicPower];
            let getHits = [ATTACK_HIT, SKILL_HIT, MAGIC_HIT];

            for (let i = 0; i < attacks.length; i++) {
                attacks[i] = new Attack(getPowers[i](), getHits[i]);
            }

            let damage = 0;
            let isHit = false;

            switch (choice) {
                case 1:
                    damage = attacks[0].Damage;
                    isHit = CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
                    break;
                case 2:
                    damage = attacks[1].Damage;
                    isHit = CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
                    break;
                case 3:
                    damage = attacks[2].Damage;
                    isHit = CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
                    break;
            }

            if (isHit) {
                damage -= enemy.Defense;
                damage = damage <= 0 ? 0 : damage;
                console.log(`${damage}のダメージ！`);
                enemy.Hp -= damage;
            } else {
                console.log('攻撃を外した！');
            }

            console.log(`${enemy.Name}の攻撃！`);
            isHit = CheckHitOrMiss(enemy.Hit);
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
            } else {
                console.log('攻撃を外した！');
            }

            console.log(`プレイヤー残りHP：${player.hp}`);
            enemy.Hp = enemy.Hp <= 0 ? 0 : enemy.Hp;
            if (enemy.Hp === 0) {
                console.log(`${enemy.Name}Lv.${enemy.Lv + 1}を倒した！`);
            }
        }

        resolve(true);
    });
}