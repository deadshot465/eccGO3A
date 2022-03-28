#include "K11.h"
#include <cctype>
#include <iostream>
#include <string>

using namespace std;

constexpr int MAX_PEOPLE = 3;

void K11::question1() {
    auto age = 0;
    auto average = 0.0f;

    for (int i = 0; i < MAX_PEOPLE; ++i) {
        cout << i + 1 << "人目の年齢を入力して下さい：";
        cin >> age;
        average += static_cast<float>(age);
    }

    cout.setf(ios_base::fixed, ios_base::floatfield);
    cout.precision(1);
    cout << MAX_PEOPLE << "人の平均年齢は" << average / static_cast<float>(MAX_PEOPLE) << "です。";
}

void K11::question2() {
    cout << "1つ目の文字列を入力して下さい。＞";
    string str1;
    cin.clear();
    cin.ignore();
    getline(cin, str1, '\n');


    cout << "2つ目の文字列を入力して下さい。＞";
    string str2;
    cin.clear();
    getline(cin, str2, '\n');


    str1 += str2;
    cout << str1 << "の文字数は" << str1.length() << "です。";
}

void K11::question3() {
    char chr;
    cout << "文字を入力して下さい。＞";
    cin >> chr;
    auto applied = false;

    if (isdigit(chr)) {
        cout << "この文字は数字です。\n";
        applied = true;
    }

    if (isupper(chr)) {
        cout << "この文字は英大文字です。\n";
        applied = true;
    }

    if (islower(chr)) {
        cout << "この文字は英小文字です。\n";
        applied = true;
    }


    if (isxdigit(chr)) {
        cout << "この文字は16進数として使える文字です。\n";
        applied = true;
    }


    if (ispunct(chr)) {
        cout << "この文字は区切り文字です。\n";
        applied = true;
    }

    if (!applied) {
        cout << "この文字はよくわからない文字です。";
    }
}

void K11::question4() {
    string alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    string inputString = "I am a STUDENT. I am good at GAME PROGRAMMING.";

    cout << "文字列：" << inputString << "\n\n";

    cout << "文字頻度\n";

    auto count = 0;
    auto _count = 0;

    auto i = 0;

    for (char alphabet: alphabets) {
        for (char j: inputString) {
            if (alphabet == std::toupper(j)) {
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
