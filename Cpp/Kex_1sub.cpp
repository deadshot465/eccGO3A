#include "Kex_1sub.h"

#include <iostream>

using std::cin;
using std::cout;
using std::mt19937;
using std::uniform_int_distribution;

bool CheckHitOrMiss(int hit) {
    auto engine = Kex_1sub::GetSeededEngine<>();
    uniform_int_distribution<> generator(0, 99);

    auto value = generator(engine);
    return value <= hit - 1;
}

void Kex_1sub::AttackGolem(int lv, PlayerEx &player) {
    GolemEx golem = {
            lv * 50 + 100,
            lv * 10 + 40,
            GOLEM_ATTACK(lv),
            GOLEM_HIT,
            GOLEM_FLEE
    };

    cout << "ゴーレムLv." << lv + 1 << "が現れた！\n";
    while (golem.Hp > 0) {
        cout << "ゴーレム 残りHP：" << golem.Hp << "\n";
        cout << "武器を選択してください（１．攻撃　２．特技　３．魔法）＞";
        auto choice = 0;
        cin >> choice;
        auto damage = 0;
        auto is_hit = false;

        auto engine = GetSeededEngine<>();
        uniform_int_distribution<> generator(0, 40);

        switch (choice) {
            case 1:
                damage = 60 + generator(engine);
                is_hit = CheckHitOrMiss(ATTACK_HIT - golem.Flee);
                break;
            case 2: {
                uniform_int_distribution<>::param_type param(0, 100);
                generator.param(param);
                damage = 30 + generator(engine);
                is_hit = CheckHitOrMiss(SKILL_HIT - golem.Flee);
                break;
            }
            case 3: {
                uniform_int_distribution<>::param_type param(0, 180);
                generator.param(param);
                damage = 20 + generator(engine);
                is_hit = CheckHitOrMiss(MAGIC_HIT - golem.Flee);
                break;
            }
            default:
                break;
        }

        if (is_hit) {
            damage -= golem.Defense;
            if (damage <= 0)
                damage = 0;
            cout << damage << "のダメージ！\n";
            golem.Hp -= damage;
        } else
            cout << "攻撃を外した！\n";

        cout << "ゴーレムの攻撃！\n";
        is_hit = CheckHitOrMiss(golem.Hit);
        if (is_hit) {
            int injury = golem.Attack - player.Defense;
            cout << injury << "のダメージ！\n";
            player.Hp -= injury;
            if (player.Hp <= 0) {
                player.Hp = 0;
                cout << "あなたはゴーレムに負けました！ゲームオーバー！\n";
                return;
            }
        } else
            cout << "攻撃を外した！\n";

        cout << "プレイヤー残りHP：" << player.Hp << "\n";

        if (golem.Hp <= 0)
            golem.Hp = 0;
        if (golem.Hp == 0)
            cout << "ゴーレムLv." << lv + 1 << "を倒した！\n";
    }
}