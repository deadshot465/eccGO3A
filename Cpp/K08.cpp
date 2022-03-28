#include <ctime>
#include <iostream>
#include <random>
#include <stdexcept>
#include <vector>
#include "K08.h"
#include "K08_1sub.h"
#include "K08_2sub.h"

using namespace std;

K08::K08() = default;

K08::~K08() = default;

void K08::question1() {
    try {
        auto numbers = vector<int>();
        for (int i = 0; i < 3; ++i) {
            cout << i + 1 << "つ目の値を入力してください。＞";
            auto num = 0;
            cin >> num;
            numbers.push_back(num);
        }

        cout << "どちらを調べますか？\n";
        cout << "（０：最大値　１：最小値）＞";
        auto choice = 0;
        cin >> choice;
        switch (choice) {
            case 0:
                cout << numbers.size() << "の中で最大値は"
                     << K08_1sub::GetMaxValue(numbers[0], numbers[1], numbers[2]) << "です。";
                break;
            case 1:
                cout << numbers.size() << "の中で最小値は"
                     << K08_1sub::GetMinValue(numbers[0], numbers[1], numbers[2]) << "です。";
                break;
            default:
                break;
        }
    }
    catch (const exception &ex) {
        cerr << ex.what();
    }
}

void K08::question2() {
    try {
        cout << "冒険が今始まる！\n";
        mt19937 gen(static_cast<mt19937::result_type>(time(nullptr)));
        uniform_int_distribution<> rand(0, 101);
        auto playerHp = 200 + rand(gen);
        auto continueGame = true;

        while (continueGame) {
            if (playerHp == 0)
                return;

            cout << "あなたのHP：" << playerHp << "\n";
            cout << "奥に進みますか？（１：奥に進む　０．帰る）＞";
            auto choice = 0;
            cin >> choice;
            continueGame = static_cast<bool>(choice);
            if (continueGame) {
                uniform_int_distribution<>::param_type golemParam(0, 5);
                rand.param(golemParam);
                auto golemLv = rand(gen);
                K08_2sub::AttackGolem(golemLv, playerHp);
            }
        }
        cout << "リレ〇ト！\n";
    }
    catch (const exception &ex) {
        cerr << ex.what();
    }
}

void K08::question3() {
}

void K08::question4() {
}
