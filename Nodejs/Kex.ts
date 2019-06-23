import { PlayerEx } from "./Player";
import * as readline from "readline";
import { AttackGolem } from "./Kex_1sub";

export class Kex {
    Execute(rl?: readline.ReadLine): Promise<any> {
        console.log("冒険が今始まる！");
        let player = new PlayerEx();
        let kills = 0;
        let continue_game = true;

        let question = () => {
            return new Promise((resolve, reject) => {
                rl.question("奥に進みますか？（１：奥に進む　０．帰る）＞",
                    (value) => {
                        continue_game = Boolean(Number.parseInt(value));
                        resolve();
                    });
            });
        };

        return new Promise(async (resolve, reject) => {
            do {

                console.log(`\n現HP：${player.hp}`);
                await question();
                if (continue_game) {
                    let golemLv = Math.round(Math.random() * 4);
                    await AttackGolem(golemLv, player, rl);
                    ++kills;
                    if (player.hp === 0) {
                        break;
                    }
                }

            } while (continue_game)

            console.log("リ〇ミト！\n");
            console.log(`戦闘回数：${kills}　残りHP：${player.hp}`);
            resolve();
        });
    }
}