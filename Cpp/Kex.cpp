#include "Kex.h"

#include <iostream>
#include <random>

#include "Kex_1sub.h"

using std::cin;
using std::cout;
using std::mt19937;
using std::uniform_int_distribution;

void Kex::Execute() {
    auto engine = Kex_1sub::GetSeededEngine<>();
    uniform_int_distribution<> generator(0, 4);
    cout << "冒険が今始まる！\n";

    PlayerEx player;
    auto continue_game = true;
    auto kills = 0;

    do {
        cout << "\n現HP：" << player.Hp << "\n";
        cout << "奥に進みますか？（１：奥に進む　０．帰る）＞";
        auto choice = 0;
        cin >> choice;
        continue_game = static_cast<bool>(choice);

        if (continue_game) {
            auto golemLv = generator(engine);
            Kex_1sub::AttackGolem(golemLv, player);
            ++kills;
            if (player.Hp == 0) {
                break;
            }
        }
    } while (continue_game);

    cout << "リ〇ミト！\n\n";
    cout << "戦闘回数：" << kills << "　残りHP：" << player.Hp;
}