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
#include "K07.h"
#include "K08.h"
#include "K09.h"
#include "K10.h"
#include "K11.h"
#include "FileControl.h"

void showSelections(int chapter)
{
	for (int i = 1; i < 5; ++i)
	{
		if (chapter < 10)
		{
			std::cout << "\t" << i << ") K0" << chapter << "_" << i << "\n";
			if (chapter == 9)
			{
				std::cout << "\t5) K0" << chapter << "_5\n";
			}
		}
		else
		{
			std::cout << "\t" << i << ") K" << chapter << "_" << i << "\n";
		}
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
	executables.push_back(std::make_unique<K07>());
	executables.push_back(std::make_unique<K08>());
	executables.push_back(std::make_unique<K09>());
	executables.push_back(std::make_unique<K10>());
	executables.push_back(std::make_unique<K11>());
	executables.push_back(std::make_unique<FileControl>());
	
	std::cout << "実行したいプログラムを選択してください。\n";

	int choice = 0;

	for (int i = 1; i <= executables.size(); ++i)
	{
		if (i < 10)
		{
			std::cout << i << ") K0" << i << "\n";
		}
		else
		{
			std::cout << i << ") K" << i << "\n";
		}
	}
	std::cin >> choice;

	showSelections(choice);
	int choice2 = 0;
	std::cin >> choice2;
	executables[choice - 1]->execute(choice2);

	return 0;
}