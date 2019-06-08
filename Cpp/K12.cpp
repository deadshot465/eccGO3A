#include "K12.h"

#include <iostream>
#include <cmath>
#include <random>
#include <string>

#include <cstdio>
#include <ctime>

struct Person
{
	std::string name;
	int birthYear;
	float height;
	float weight;
};

struct Staff
{
	std::string name;
	char gender;
	int age;
};

struct Position
{
	int x;
	int y;
	double distance;
};

void K12::question1()
{
	Person person;
	std::cout << "名前を入力してください＞";
	std::cin.clear();
	std::cin.ignore();
	std::getline(std::cin, person.name, '\n');
	std::cout << "生年（西暦）を入力してください＞";
	std::cin >> person.birthYear;
	std::cout << "身長を入力してください＞";
	std::cin >> person.height;
	std::cout << "体重を入力してください＞";
	std::cin >> person.weight;

	std::cout << "プロファイル：\n";
	std::cout << "名前：" << person.name << "\n";
	std::cout << "生年：" << person.birthYear << "\n";
	std::cout << "身長：" << person.height << "\n";
	std::cout << "体重：" << person.weight << "\n";
}

void K12::question2()
{
	Staff staffs[3] = {
		{"神木隆之介", 'M', 23},
		{"上白石萌音", 'F', 18},
		{"長澤まさみ", 'F', 28}
	};

	std::cout << "名前\t\t性別\t年齢\n";
	for (int i = 0; i <= 35; ++i)
	{
		std::cout << '-';
	}
	std::cout << "\n";

	for (const auto& staff : staffs)
	{
		std::cout << staff.name << "\t" << staff.gender << "\t" << staff.age << "歳\n";
	}
}

double getDistance(const Position& playerPos, const Position& enemyPos)
{
	int diffX = playerPos.x - enemyPos.x;
	int diffY = playerPos.y - enemyPos.y;
	return sqrt(diffX * diffX + diffY * diffY);
}

void K12::question3()
{
	std::mt19937 engine(static_cast<std::mt19937::result_type>(time(nullptr)));
	std::uniform_int_distribution<> rand(0, 101);
	auto getRandomNumber = [&]() { return rand(engine) - 50; };

	Position playerPos = {
		getRandomNumber(), getRandomNumber(), 0.0
	};
	Position enemyPos[5] = {};

	for (auto& enemyPo : enemyPos)
	{
		enemyPo.x = getRandomNumber();
		enemyPo.y = getRandomNumber();
		enemyPo.distance = getDistance(playerPos, enemyPo);
	}

	std::cout.setf(std::ios_base::fixed, std::ios_base::floatfield);
	std::cout.precision(2);
	printf("プレーヤーの座標：x= %.2f\t\ty= %.2f\n\n",
		static_cast<float>(playerPos.x), static_cast<float>(playerPos.y));
	for (int i = 0; i < 5; ++i)
	{
		printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
			i, static_cast<float>(enemyPos[i].x),
			static_cast<float>(enemyPos[i].y), static_cast<float>(enemyPos[i].distance));
	}
	
}

void swapPos(Position& a, Position& b)
{
	Position temp = a;
	a = b;
	b = temp;
}

void sortPos(Position* positions, int total)
{
	for (int i = 0; i < total; ++i)
	{
		for (int j = 0; j < total; ++j)
		{
			if (positions[j].distance > positions[i].distance)
			{
				swapPos(positions[i], positions[j]);
			}
		}
	}
}

void K12::question4()
{
	std::mt19937 engine(static_cast<std::mt19937::result_type>(time(nullptr)));
	std::uniform_int_distribution<> rand(0, 101);
	auto getRandomNumber = [&]() { return rand(engine) - 50; };

	Position playerPos = {
		getRandomNumber(), getRandomNumber(), 0.0
	};
	Position enemyPos[5] = {};

	for (auto& enemyPo : enemyPos)
	{
		enemyPo.x = getRandomNumber();
		enemyPo.y = getRandomNumber();
		enemyPo.distance = getDistance(playerPos, enemyPo);
	}

	std::cout.setf(std::ios_base::fixed, std::ios_base::floatfield);
	std::cout.precision(2);
	printf("プレーヤーの座標：x= %.2f\t\ty= %.2f\n\n",
		static_cast<float>(playerPos.x), static_cast<float>(playerPos.y));
	for (int i = 0; i < 5; ++i)
	{
		printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
			i, static_cast<float>(enemyPos[i].x),
			static_cast<float>(enemyPos[i].y), static_cast<float>(enemyPos[i].distance));
	}

	std::cout << "\n並び替え後\n";
	sortPos(enemyPos, 5);
	for (int i = 0; i < 5; ++i)
	{
		printf("敵キャラの座標0%d：x= %5.2f\t\ty= %5.2f\t\t距離=%5.2f\n",
			i, static_cast<float>(enemyPos[i].x),
			static_cast<float>(enemyPos[i].y), static_cast<float>(enemyPos[i].distance));
	}

}
