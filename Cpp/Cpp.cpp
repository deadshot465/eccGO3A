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
#include "K12.h"
#include "K13.h"
#include "K14.h"
#include "Kex.h"
#include "Kex_2.h"
#include "Musicians/BandSupervisor.h"
//#include "FileControl.h"
//#include "Sort.h"


void showSelections(int chapter)
{
	if (chapter < 10)
	{
		for (int i = 1; i <= 4; ++i)
		{
			std::cout << "\t" << i << ") K0" << chapter << "_" << i << "\n";
		}
		if (chapter == 9)
		{
			std::cout << "\t5) K0" << chapter << "_5\n";
		}
	} 
	else
	{
		for (int i = 1; i <= 4; ++i)
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
	executables.push_back(std::make_unique<K12>());
	executables.push_back(std::make_unique<K13>());
	executables.push_back(std::make_unique<K14>());
	//executables.push_back(std::make_unique<FileControl>());
	
	std::cout << "実行したいプログラムを選択してください。\n";

	int choice = 0;

	for (int i = 1; i <= executables.size(); ++i)
	{
		if (i < 10)
		{
			std::cout << i << ") K0" << i << "\t\t";
		}
		else
		{
			int addedChapterNum = 0;
			if (i >= 12)
			{
				addedChapterNum = i >= 17 ? i + 4 : i + 3;
			}
			std::cout << i << ") K" << addedChapterNum << "\t\t";
		}
	}
	std::cout << "100) Kex\t";
	std::cout << "101) Kex_2\n";
	std::cout << "102) Sort\n";
    std::cout << "103) Band Supervisor\n";
	std::cin >> choice;

    switch (choice) {
        case 100:
        {
            auto kex = Kex{};
            kex.Execute();
            break;
        }
        case 101:
        {
            auto kex_2 = Kex_2{};
            kex_2.Execute();
            break;
        }
        case 103:
        {
            BandSupervisor::start_band(3);
            break;
        }
        default:
        {
            showSelections(choice);
            auto choice_2 = 0;
            std::cin >> choice_2;
            executables[choice - 1]->execute(choice_2);
            break;
        }
    }

	return 0;
}