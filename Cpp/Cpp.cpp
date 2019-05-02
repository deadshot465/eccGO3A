#include <iostream>
#include <memory>
#include <vector>

#include "IExecutable.h"
#include "K01.h"
#include "K02.h"
#include "K03.h"
#include "K04.h"
#include "K05.h"
#include "K06.h"

void showSelections(int chapter)
{
	for (int i = 1; i < 5; ++i)
	{
		std::cout << "\t" << i << ") K0" << chapter << "_" << i << "\n";
	}
}

int main()
{
	std::vector<std::unique_ptr<IExecutable>> executables;
	executables.push_back(std::make_unique<K01>());
	executables.push_back(std::make_unique<K02>());
	executables.push_back(std::make_unique<K03>());
	executables.push_back(std::make_unique<K04>());
	executables.push_back(std::make_unique<K05>());
	executables.push_back(std::make_unique<K06>());
	
	std::cout << "実行したいプログラムを選択してください。\n";

	int choice = 0;

	for (int i = 1; i < 7; ++i)
	{
		std::cout << i << ") K0" << i << "\n";
	}
	std::cin >> choice;

	showSelections(choice);
	int choice2 = 0;
	std::cin >> choice2;
	executables[choice - 1]->execute(choice2);

	return 0;
}