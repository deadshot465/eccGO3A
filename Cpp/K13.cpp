#include "K13.h"
#include <array>
#include <iostream>
#include <random>


void K13::question1() {
    auto a = 10;
    auto p = &a;
    std::cout << "aの値：" << a << "\n";
    std::cout << "aのアドレス：" << &a << "\n";
    std::cout << "pの値：" << p << "\n";
    std::cout << "pが参照する変数の値：" << *p << "\n";
    std::cout << "pのアドレス：" << &p << "\n";
}

void K13::question2() {
    int arr[10] = {0};
    auto ptr = arr;
    for (auto i = 0; i < 10; ++i) {
        *ptr = i;
        std::cout << "配列[" << i << "] = " << *ptr << "\n";
        ++ptr;
    }
}

void K13::question3() {
    int data[] = {2, 8, 10, 3, 1, 9, 4, 3, 6, -1};
    auto total = 0;
    auto ptr = data;
    std::cout << "データ：";
    while (*ptr >= 0) {
        std::cout << *ptr << "\t";
        total += *ptr;
        ++ptr;
    }
    std::cout << "\n合計は" << total << "です。";
}

template<typename T = std::mt19937, std::size_t U = T::state_size>
auto GetEngine() -> typename std::enable_if<!!U, T>::type {
    typename T::result_type data[U];
    std::random_device rd;
    std::generate(std::begin(data), std::end(data), std::ref(rd));
    std::seed_seq seeds(std::begin(data), std::end(data));
    T engine(seeds);
    return engine;
}

void K13::question4() {
    auto engine = GetEngine();
    std::uniform_int_distribution<> generator(0, 100);
    auto data = std::array<int, 10>();
    std::generate(std::begin(data), std::end(data), [&]() {
        return generator(engine);
    });

    auto iter = data.begin();
    auto sum = 0;
    std::cout << "データ：";
    while (iter != data.end()) {
        std::cout << *iter << "\t";
        sum += *iter;
        ++iter;
    }

    std::cout << "\n合計は" << sum << "です。";
}
