#include <iostream>
#include <numeric>
#include <vector>

#include "K06.h"

using namespace std;

K06::K06()
{
}


K06::~K06()
{
}

void K06::question1()
{
	std::vector<int> ages;
	for (int i = 0; i < 5; ++i)
	{
		cout << i + 1 << "l–Ú‚Ì”N—î‚ð“ü—Í‚µ‚Ä‰º‚³‚¢F";
		int _age = 0;
		std::cin >> _age;
		ages.push_back(_age);
	}

	double result = std::reduce(ages.begin(), ages.end());
	result /= ages.size();
	cout << ages.size() << "l‚Ì•½‹Ï”N—î‚Í" << result << "‚Å‚·B";
}

void K06::question2()
{
	for (int i = 0; i < 9; ++i)
	{
		for (int j = 0; j < i + 1; ++j)
		{
			cout << "*";
		}
		cout << "\n";
	}
	cout << "\n";

	for (int i = 9; i > 0; --i)
	{
		for (int j = 0; j < i; ++j)
		{
			cout << "*";
		}
		cout << "\n";
	}
	cout << "\n";

	for (int i = 9; i > 0; --i)
	{
		for (int j = 0; j < i - 1; ++j)
		{
			cout << " ";
		}

		for (int k = 9; k > i - 1; --k)
		{
			cout << "*";
		}
		cout << "\n";
	}
}

void K06::question3()
{
	int total = 370;
	int count = 0;

	for (int i = 0; i <= total / 100; ++i)
	{
		for (int j = 0; j <= total / 50; ++j)
		{
			for (int k = 0; k <= total / 10; ++k)
			{
				if (100 * i + 50 * j + 10 * k == total)
				{
					cout << "10‰~‚Ìd‰Ý" << k
						<< "–‡ 50‰~‚Ìd‰Ý" << j
						<< "–‡ 100‰~‚Ìd‰Ý" << i << "–‡\n";

					++count;
				}
			}
		}
	}

	cout << "\nˆÈã" << count << "’Ê‚è‚ð”­Œ©‚µ‚Ü‚µ‚½B\n";
}

void K06::question4()
{
	cout << "\t|\t";
	for (int i = 1; i < 10; ++i)
	{
		cout << i << "\t";
	}
	cout << "\n";

	for (int i = 0; i < 76; ++i)
	{
		cout << "-";
	}
	cout << "\n";

	for (int i = 1; i < 10; ++i)
	{
		cout << i << "\t|\t";
		for (int j = 1; j < 10; ++j)
		{
			cout << i * j << "\t";
		}
		cout << "\n";
	}
}
