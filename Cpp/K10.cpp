#include <array>
#include <iostream>
#include "K10.h"

using namespace std;

K10::K10() = default;


K10::~K10() = default;

void K10::question1() {
    string inputString;
    cout << "文字列の入力＞";
    cin >> inputString;

    cout << "入力された文字列の文字数：" << inputString.length();
}

void K10::question2() {
    string str = "STRINGcopy";

    cout << "コピーしたい文字列：" << str << "\n";

    string copyStr{str};

    cout << "コピー後の文字列：" << copyStr << "\n";

}

void K10::question3() {

    array<string, 3> str = {
            "abcdef", "GHIJKL", "13579"
    };

    string str_combined;

    cout << "連結したい３つの文字列：\n";
    for (const auto &_str: str) {
        str_combined += _str;
    }

    cout << "連結した文字列：\n" << str_combined;
}

void K10::question4() {
    string alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    string inputString = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING.";

    cout << "文字列：" << inputString << "\n\n";

    cout << "文字頻度\n";

    auto count = 0;
    auto _count = 0;

    auto i = 0;

    for (char alphabet: alphabets) {
        for (char j: inputString) {
            if (alphabet == j) {
                ++_count;
            }
        }

        cout << alphabet << ": " << _count << "\t";
        _count = 0;
        ++count;

        if (count % 4 == 0) {
            printf("\n");
        }
    }
}
