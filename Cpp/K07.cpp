#include <iostream>
#include <stdexcept>
#include "K07.h"


K07::K07()
{
}


K07::~K07()
{
}

void showTexts()
{
	std::cout << "Hello World!\n";
	std::cout << "ようこそ\n";
	std::cout << "C++言語の世界へ！\n";
}

void K07::question1()
{
	int choice = 0;
	do
	{
		try {
			std::cout << "メッセージを表示しますか？（０：終了する　１：表示する）＞";
			std::cin >> choice;
			if (choice == 1)
			{
				showTexts();
			}
		}
		catch (const std::exception& ex)
		{
			std::cerr << ex.what();
		}
	} while (choice != 0);
}

int max(int value1, int value2, int value3)
{
	int temp = value1 >= value2 ? value1 : value2;
	temp = temp >= value3 ? temp : value3;
	return temp;
}

void K07::question2()
{
	try {
		int numbers[3] = { 0 };
		int count = 0;

		for (int i = 0; i < 3; ++i)
		{
			std::cout << i + 1 << "つ目の値を入力してください。＞";
			std::cin >> numbers[i];
			++count;
		}

		int maxValue = max(numbers[0], numbers[1], numbers[2]);
		std::cout << count << "つの中で最大値は" << maxValue << "です。";
	}
	catch (const std::exception & ex)
	{
		std::cerr << ex.what();
	}
}

int GetType(int age)
{
	if (age <= 0)
		return 0;
	else if (age < 3 || age >= 70)
		return 1;
	else if (age >= 3 && age <= 15)
		return 2;
	else if (age >= 60 && age < 70)
		return 3;
	else
		return 4;
}

void K07::question3()
{
	try {
		int age = 0;
		int no = 0;
		std::cout << "年齢を入力して下さい。＞";
		std::cin >> age;

		no = GetType(age);
		switch (no)
		{
		case 0:
			printf("不適切な値が入力されました。\n");
			break;
		case 1:
			printf("入場料金無料です。\n");
			break;
		case 2:
			printf("子供料金で半額です。\n");
			break;
		case 3:
			printf("シニア割引で１割引きです。\n");
			break;
		default:
			printf("通常料金です。\n");
			break;
		}
	}
	catch (const std::exception & ex)
	{
		std::cerr << ex.what();
	}
}

void K07::question4()
{
}
