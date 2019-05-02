#include "Golem.h"
#include "K02.h"



K02::K02()
{
}


K02::~K02()
{
}
#include <iostream>


void K02::question1()
{
	int seisuu = 3;
	float jissuu = 2.6f;
	char moji = 'A';

	std::cout << "変数seisuuの値は" << seisuu << "\n";
	std::cout << "変数jissuuの値は" << jissuu << "\n";
	std::cout << "変数mojiの値は" << moji << "\n";
}

void K02::question2()
{
	try
	{
		std::cout << "一つ目の整数は？";
		int number1 = 0;
		std::cin >> number1;
		std::cout << "二つ目の整数は？";
		int number2 = 0;
		std::cin >> number2;

		std::cout << number1 << "÷" << number2 << "="
			<< number1 / number2 << "..." << number1 % number2;
	}
	catch (const std::exception& ex)
	{
		std::cout << ex.what();
	}

}

void K02::question3()
{
	try
	{
		std::cout << "一つ目の商品の値段は？";
		int priceA = 0;
		std::cin >> priceA;
		std::cout << "個数は？";
		int amountA = 0;
		std::cin >> amountA;
		std::cout << "二つ目の商品の値段は？";
		int priceB = 0;
		std::cin >> priceB;
		std::cout << "個数は？";
		int amountB = 0;
		std::cin >> amountB;

		float total = (priceA * amountA + priceB * amountB) * 1.08f;
		std::cout << "お支払いは税込み￥" << total << "です。";
	}
	catch (const std::exception& ex)
	{
		std::cout << ex.what();
	}
}

void K02::question4()
{
	try
	{
		Golem golem{};
		std::cout << "ゴーレム　（HP：" << golem.hp << "　防御力：" << golem.defense << "）\n";
		std::cout << "HP：" << golem.hp << "\n";
		std::cout << "今回の攻撃の値を入力してください＞";
		int damage = 0;
		std::cin >> damage;

		damage = damage - golem.defense > 0 ? damage - golem.defense : 0;

		std::cout << "ダメージは" << damage << "です。\n";
		golem.hp -= damage;
		std::cout << "残りのHPは" << golem.hp << "です。\n";
	}
	catch (const std::exception& ex)
	{
		std::cout << ex.what();
	}
}
