#include <array>
#include <iostream>
#include <stdexcept>
#include "K09.h"

using namespace std;

K09::K09()
= default;


K09::~K09()
= default;

void K09::question1()
{
	try
	{
		int ages[3] = { 0,0,0 };
		for (int i = 0; i < 3; ++i)
		{
			cout << i + 1 << "人目の年齢を入力＞";
			cin >> ages[i];
		}

		for (int i = 0; i < 21; ++i)
		{
			cout << "-";
		}
		cout << "\n";

		float average = 0.0f;
		for (int i = 0; i < 3; ++i)
		{
			cout << i + 1 << "人目：" << ages[i] << "歳\n";
			average += static_cast<float>(ages[i]);
		}

		cout << "平均年齢：" << average / 3.0f << "歳\n";
	}
	catch (const exception& ex)
	{
		cerr << ex.what();
	}
}

void K09::question2()
{
	array<int, 5> numbers = { 8, 3, 12, 7, 9 };

	cout << "元々の配列：";
	for (int i = 0; i < numbers.size(); ++i)
	{
		cout << numbers[i] << " ";
	}
	cout << "\n";

	cout << "逆順での表示：";
	for (int i = numbers.size() - 1; i >= 0; --i)
	{
		cout << numbers[i] << " ";
	}
}

void K09::question3()
{
	/* int student_scores[3][4] = {
		{52, 71, 61, 47},
		{6, 84, 81, 20},
		{73, 98, 94, 95}
	}; */

	array<array<int, 4>, 3> student_scores = {};
	student_scores[0] = { 52,71,61,47 };
	student_scores[1] = { 6,84, 81, 20 };
	student_scores[2] = { 73, 98, 94, 95 };

	cout << "\t|\t科目A\t科目B\t科目C\t科目D\n";
	for (int i = 0; i < 46; ++i)
	{
		cout << "-";
	}
	cout << "\n";

	for (int i = 0; i < student_scores.size(); ++i)
	{
		cout << "学生" << i + 1 << "\t|\t";
		for (int j = 0; j < student_scores[i].size(); ++j)
		{
			cout << student_scores[i][j] << "\t";
		}
		cout << "\n";
	}
}

void K09::question4()
{
	/* int student_scores[3][4] = {
		{52, 71, 61, 47},
		{6, 84, 81, 20},
		{73, 98, 94, 95}
	}; */

	array<array<int, 4>, 3> student_scores = {};
	student_scores[0] = { 52,71,61,47 };
	student_scores[1] = { 6,84, 81, 20 };
	student_scores[2] = { 73, 98, 94, 95 };

	float average[4] = { 0,0,0,0 };
	int total = 0;

	cout << "\t|\t科目A\t科目B\t科目C\t科目D\t|\t合計点\n";
	for (int i = 0; i < 66; ++i)
	{
		cout << '-';
	}
	cout << '\n';

	for (int i = 0; i < student_scores.size(); ++i)
	{
		cout << "学生" << i + 1 << "\t|\t";

		for (int j = 0; j < student_scores[i].size(); ++j)
		{
			cout << student_scores[i][j] << "\t";
			total += student_scores[i][j];
			average[j] += static_cast<float>(student_scores[i][j]);

		}
		cout << "|\t" << total;
		total = 0;
		cout << '\n';
		
	}
	cout << "平均点\t|\t";
	for (int i = 0; i < 4; ++i)
	{
		cout.setf(ios_base::fixed, ios_base::floatfield);
		cout.precision(1);
		cout << average[i] / 3.0f << "\t";
	}
	cout << '|';
}

void K09::swap(int& a, int& b)
{
	int temp = a;
	a = b;
	b = temp;
}

void K09::sort(int* numbers, int total)
{
	for (int i = 0; i < total; ++i)
	{
		for (int j = 0; j < total; ++j)
		{
			if (numbers[j] > numbers[i])
			{
				swap(numbers[i], numbers[j]);
			}
		}
	}
}

void K09::question5()
{
	try
	{
		int numbers[100] = { 0 };
		int count = 0;

		for (int i = 0; i < 100; ++i)
		{
			cout << i + 1 << "件目の入力：";
			cin >> numbers[i];
			if (numbers[i] < 0)
			{
				break;
			}
			++count;
		}

		sort(numbers, count);
		cout << "----並び替え後----\n";

		for (int i = 0; i < count; ++i)
		{
			cout << numbers[i] << "\n";
		}
	}
	catch (const exception& ex)
	{
		cerr << ex.what();
	}
}

void K09::execute(int num)
{
	switch (num)
	{
	case 1:
		question1();
		break;
	case 2:
		question2();
		break;
	case 3:
		question3();
		break;
	case 4:
		question4();
		break;
	case 5:
		question5();
		break;
	}
}
