#include <ctime>
#include <iostream>
#include <random>
#include <stdexcept>

#include "K03.h"


K03::K03() = default;


K03::~K03() = default;

void K03::question1() {
    try {
        std::cout << "年齢を入力してください。＞";
        auto age = 0;
        std::cin >> age;

        if (age < 20) {
            std::cout << "未成年なので購入できません。\n";
        }
    }
    catch (const std::exception &ex) {
        std::cout << ex.what();
    }
}

void K03::question2() {
    try {
        std::cout << "身長を入力してください。＞";
        auto height = 0.0f;
        std::cin >> height;
        height /= 100.0f;
        std::cout << "体重を入力してください。＞";
        auto weight = 0.0f;
        std::cin >> weight;

        const auto standard = height * height * 22.0f;
        std::cout << "あなたの標準体重は" << standard << "です。\n";

        if (weight > standard && (weight - standard) / standard * 100.0f > 14.0f) {
            std::cout << "太り気味です。\n";
        } else if (weight < standard && (weight - standard) / standard * 100.0f < -14.0f) {
            std::cout << "痩せ気味です。\n";
        } else {
            std::cout << "普通ですね。\n";
        }
    }
    catch (const std::exception &ex) {
        std::cout << ex.what();
    }

}

void K03::question3() {
    try {
        std::mt19937 generator(static_cast<std::mt19937::result_type>(std::time(nullptr)));
        std::uniform_int_distribution<> randNumGen(0, 99);

        const auto randNum = randNumGen(generator);

        std::cout << "０から９９の範囲の数値が決定されました。\n";
        std::cout << "決められた数値を予想し、この数値よりも大きな値を入力してください＞";
        auto guess = 0;
        std::cin >> guess;

        std::cout << "決められた数値は" << randNum << "です。\n";
        std::cout << ((guess > randNum) ? "正解です。\n" : "不正解です。\n");
    }
    catch (const std::exception &ex) {
        std::cout << ex.what();
    }
}

void K03::question4() {
    try {
        std::mt19937 generator(static_cast<std::mt19937::result_type>(std::time(nullptr)));
        std::uniform_int_distribution<> randNumGen(0, 99);

        const auto randNum = randNumGen(generator);

        std::cout << "０から９９の範囲の数値が決定されました。\n";
        std::cout << "決められた数値を予想し、この数値よりも大きな値を入力してください＞";
        auto guess = 0;
        std::cin >> guess;

        std::cout << "決められた数値は" << randNum << "です。\n";

        if (guess < 0 || guess > 100) {
            std::cout << "反則です！";
        } else if (guess > randNum && guess - randNum <= 10) {
            std::cout << "大正解です！";
        } else if (guess < randNum && guess - randNum >= -10) {
            std::cout << "惜しい！";
        } else if (guess == randNum) {
            std::cout << "お見事！";
        } else {
            std::cout << ((guess > randNum) ? "正解です。\n" : "不正解です。\n");
        }
    }
    catch (const std::exception &ex) {
        std::cout << ex.what();
    }
}
