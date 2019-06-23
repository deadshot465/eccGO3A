import * as readline from 'readline';
import { AttackEnemy } from './Kex_2_Battle';
import { CreateEnemy } from './Kex_2_Enemy';
import { PlayerEx } from './Player';

export class Kex_2 {
    static Execute(rl?: readline.ReadLine) {
        console.log('冒険が今始まる！');
        let player = new PlayerEx();
        let continueGame = new Boolean(true);
        let kills = 0;

        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question('奥に進みますか？（１：奥に進む　０．帰る）＞', (value) => {
                    continueGame = new Boolean(Number.parseInt(value));
                    resolve(continueGame);
                });
            });
        }

        return new Promise(async (resolve, reject) => {
            do {
                console.log(`現HP：${player.hp}`);
                await question();
                if (continueGame.valueOf()) {
                    let type = Math.round(Math.random() * 2);
                    let enemy = CreateEnemy(type);
                    let result: boolean;
                    await AttackEnemy(player, enemy, rl).then((value) => {
                        kills++;
                        result = value;
                    });
                    if (!result) {
                        break;
                    }
                }
            } while (continueGame.valueOf());
            console.log('リ〇ミト！\n')
            console.log(`戦闘回数：${kills}回　残りHP：${player.hp}`);
            resolve();
        });
    }
}