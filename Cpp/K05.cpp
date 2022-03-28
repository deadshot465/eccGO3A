#include <ctime>
#include <iostream>
#include <random>
#include <stdexcept>

#include "Golem.h"
#include "K05.h"

using namespace std;

K05::K05() = default;


K05::~K05() = default;

void K05::question1() {
    auto salary = 19.0f;
    auto age = 22;

    while (salary < 50.0f) {
        salary *= 1.035f;
        ++age;
    }

    cout << age << "歳で月給" << salary << "万円\n";
}

void K05::question2() {
    try {
        auto choice = 0;

        while (choice != 1) {
            cout << "起きろ～\n";
            cout << "1．起きた　2．あと5分…　3．Zzzz…\t入力：";
            std::cin >> choice;
        }
        cout << "よし、学校へ行こう！\n";
    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}

void K05::question3() {
    try {
        auto choice = 0;

        while (true) {
            cout << "起きろ～\n";
            cout << "1．起きた　2．あと5分…　3．Zzzz…\t入力：";
            std::cin >> choice;
            if (choice == 1) {
                cout << "よし、学校へ行こう！\n";
            }
        }
    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}

void K05::question4() {
    try {
        mt19937 generator(static_cast<mt19937::result_type>(time(nullptr)));
        uniform_int_distribution<> randNumGen(0, 200);

        Golem golem{};
        golem.hp = 300 + randNumGen(generator);

        uniform_int_distribution<>::param_type newRange(0, 100);
        randNumGen.param(newRange);
        auto player_hp = 200 + randNumGen(generator);

        std::cout << "ゴーレム　（HP：" << golem.hp << "　防御力：" << golem.defense << "）\n";

        while (golem.hp > 0) {
            std::cout << "残りHP：" << golem.hp << "\n";
            std::cout << "攻撃手段を選択してください（1．攻撃　2．特技　3．魔法）　＞";
            auto choice = 0;
            std::cin >> choice;

            auto damage = 0;

            switch (choice) {
                case 1: {
                    uniform_int_distribution<>::param_type atkRange(0, 40);
                    randNumGen.param(atkRange);
                    damage = 60 + randNumGen(generator);
                    break;
                }
                case 2: {
                    uniform_int_distribution<>::param_type skillRange(0, 100);
                    randNumGen.param(skillRange);
                    damage = 30 + randNumGen(generator);
                    break;
                }
                case 3: {
                    uniform_int_distribution<>::param_type magicRange(0, 180);
                    randNumGen.param(magicRange);
                    damage = 20 + randNumGen(generator);
                    break;
                }
                default:
                    continue;
            }

            cout << "基礎攻撃力は" << damage << "です。\n";
            damage -= golem.defense;

            if (damage <= 0) {
                damage = 0;
                cout << "ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」\n";
                cout << "ゴーレムがあなたを攻撃しました！攻撃値：" << golem.attack << "\n";
                player_hp -= golem.attack;

                if (player_hp <= 0) {
                    cout << "あなたはゴーレムに負けました！ゲームオーバー！\n";
                    return;
                }
                cout << "あなたの残りHPは：" << player_hp << "\n";
            }

            std::cout << "ダメージは" << damage << "です。\n";
            golem.hp -= damage;
            if (golem.hp < 0) {
                golem.hp = 0;
            }

            std::cout << "残りのHPは" << golem.hp << "です。\n";

            if (golem.hp == 0) {
                cout << "ゴーレムを倒しました！\n";
            }

        }
    }
    catch (const std::exception &ex) {
        std::cout << ex.what();
    }
}
