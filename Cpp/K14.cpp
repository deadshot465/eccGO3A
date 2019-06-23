#include "K14.h"
#include <iostream>
#include <string>

void K14::question1()
{
	std::string str = "ABCDEFGH!!";
	std::cout << "検索対象の文字列＞" << str << "\n";
	std::cout << "検索する１文字を入力してください＞";
	std::cin.ignore();
	std::cin.clear();
	char searchChar;
	std::cin >> searchChar;
	auto index = str.find(searchChar);
	if (index != std::string::npos)
	{
		auto subStr = str.substr(index);
		std::cout << "検索文字以降の文字列：" << subStr << "\n";
	}
	else
	{
		std::cout << "文字列が見つかりませんでした。\n";
	}
}

void swapLargerValue(int& a, int& b)
{
	if (a >= b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
}

void K14::question2()
{
	std::cout << "一つ目の値を入力＞";
	int a = 0;
	std::cin >> a;
	std::cout << "二つ目の値を入力＞";
	int b = 0;
	std::cin >> b;
	swapLargerValue(a, b);
	std::cout << "並び替え結果：" << a << ", " << b << "\n";
}

bool checkRange(float a, float b, float& distance)
{
	distance = sqrtf(a * a + b * b);
	return distance < 10;
}

void K14::question3()
{
	std::cout << "座標をカンマ区切りで入力してください＞";
	float a = 0;
	float b = 0;
	scanf_s("%f, %f", &a, &b);
	float distance = 0.0f;
	bool result = checkRange(a, b, distance);
	std::cout.setf(std::ios_base::fixed, std::ios_base::floatfield);
	std::cout.precision(2);
	std::cout << "距離は" << distance << "なので、範囲" << (result ? "内" : "外") << "です。\n";
}

void K14::question4()
{
	std::cout << "１つ目の文字列を入力＞";
	std::cin.clear();
	std::cin.ignore();
	std::string strA;
	std::getline(std::cin, strA, '\n');
	std::cout << "２つ目の文字列を入力＞";
	std::cin.clear();
	std::string strB;
	std::getline(std::cin, strB, '\n');
	std::cout << (strA == strB ? "同じ文字列です。" : "違う文字列です。");
}
