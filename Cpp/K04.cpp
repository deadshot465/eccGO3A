#include <ctime>
#include <iostream>
#include <random>
#include <stdexcept>

#include "K04.h"

using namespace std;

K04::K04() = default;


K04::~K04() = default;

void K04::question1() {
    try {
        cout << "年齢を入力してください。＞";
        auto age = 0;
        cin >> age;

        if (age < 3 || age >= 70) {
            cout << "入場料金無料です。\n";
        } else {
            cout << "通常料金です。\n";
        }

    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}

void K04::question2() {
    try {
        cout << "性別を選択してください。（０：男性　１：女性）＞";
        auto gender = 0;
        cin >> gender;

        switch (gender) {
            case 0:
                cout << "あら、格好良いですね。\n";
                break;
            case 1:
                cout << "あら、モデルさんみたいですね。\n";
                break;
            default:
                cout << "そんな選択肢はありません。\n";
                break;
        }

    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}

void K04::question3() {
    try {
        cout << "年齢を入力してください。＞";
        auto age = 0;
        cin >> age;

        if (age < 3 || age >= 70) {
            cout << "入場料金無料です。\n";
        } else if (age >= 3 && age <= 15) {
            cout << "子供料金で半額です。\n";
        } else if (age >= 60 && age < 70) {
            cout << "シニア割引で一割引きです。\n";
        } else {
            cout << "通常料金です。\n";
        }

    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}

void K04::question4() {
    try {
        cout << "＊＊＊おみくじプログラム＊＊＊\n";
        cout << "おみくじを引きますか　（はい：１　いいえ：０）＞";
        auto choice = 0;
        cin >> choice;

        if (choice >= 1) {
            mt19937 generator(static_cast<mt19937::result_type>(time(nullptr)));
            uniform_int_distribution<> randNumGen(0, 4);
            const auto oracle = randNumGen(generator);

            switch (oracle) {
                case 0:
                    cout << "大吉　とってもいいことがありそう！！\n";
                    break;
                case 1:
                    cout << "中吉　きっといいことあるんじゃないかな\n";
                    break;
                case 2:
                    cout << "小吉　少しぐらいはいいことあるかもね\n";
                    break;
                case 3:
                    cout << "凶　今日はおとなしくておいた方がいいかも\n";
                    break;
                case 4:
                    cout << "大凶　これじゃやばくない？早く家に帰った方がいいかも\n";
                    break;
                default:
                    break;
            }
        }

    }
    catch (const std::exception &ex) {
        cout << ex.what();
    }
}
