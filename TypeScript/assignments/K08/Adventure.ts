import Golem from "../../shared/Golem.ts";
import { getRandomNumber } from "../../shared/Utility.ts";

interface ProgressResult {
    playerHp: number | null,
    message: string | null
}

function selectAttack(choice: number): number {
    switch (choice) {
        case 1:
            return 65 + getRandomNumber(36);
        case 2:
            return 50 + getRandomNumber(101);
        case 3:
            return 33 + getRandomNumber(168);
        default:
            return selectAttack(1);
    }
}

function damagePlayer(golemAttack: number, playerHp: number): number {
    console.log("ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」");
    console.log(`ゴーレムがあなたを攻撃しました！攻撃値：${golemAttack}`);
    return playerHp - golemAttack;
}

function battleLoop(golemLevel: number, golem: Golem, playerHp: number): ProgressResult {
    while (golem.hp > 0) {
        console.log(`ゴーレムLv.${golemLevel + 1} 残りHP：${golem.hp}`)
        
        const baseDamage = selectAttack(Number.parseInt(prompt("武器を選択してください（１．攻撃　２．特技　３．魔法）＞") ?? "0"));
        console.log(`基礎ダメージは${baseDamage}です。`);
        const actualDamage = baseDamage - golem.defense < 0 ? 0 : baseDamage - golem.defense;
        console.log(`実際ダメージは${actualDamage}です。`);

        if (actualDamage <= 0) {
            playerHp = damagePlayer(golem.attack, playerHp);
            if (playerHp <= 0) {
                return {
                    message: "あなたはゴーレムに負けました！",
                    playerHp: null
                };
            }
            console.log(`あなたの残りHPは：${playerHp}`);
        } else {
            golem.hp = golem.hp - actualDamage < 0 ? 0 : golem.hp - actualDamage;
        }
    }

    console.log(`ゴーレムLv.${golemLevel + 1}を倒した！`);
    return {
        playerHp: playerHp,
        message: null
    };
}

function engageBattle(playerHp: number): ProgressResult {
    const golemLevel = getRandomNumber(10);
    const golem: Golem = {
        hp: golemLevel * 50 + 100,
        defense: golemLevel * 10 + 40,
        attack: golemLevel * 10 + 30
    };
    console.log(`ゴーレムLv.${golemLevel + 1}が現れた！`);
    return battleLoop(golemLevel, golem, playerHp);
}

export function gameLoop(playerHp: number): string {
    while (playerHp > 0) {
        console.log(`あなたのHP：${playerHp}`);

        switch (Number.parseInt(prompt("奥に進みますか？（１：奥に進む　０．帰る）＞") ?? "0")) {
            case 0:
                return "リレ〇ト！";
            default:
                {
                    const runBattle = () => {
                        const result = engageBattle(playerHp);
                        if (result.playerHp != null) {
                            playerHp = result.playerHp;
                        } else if (result.message != null) {
                            return result.message;
                        }
                        return null;
                    };

                    const result = runBattle();
                    if (result != null) {
                        console.log(result);
                        return "ゲームオーバー！";
                    }
                }
                break;
        }
    }

    return "ゲームオーバー！";
}