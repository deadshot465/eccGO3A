#include <chrono>
#include <fstream>
#include <iostream>
#include <stdexcept>
#include <string>

#include "FileControl.h"

using hClock = std::chrono::high_resolution_clock;
using dSecond = std::chrono::duration<double, std::ratio<1>>;

void FileControl::question1()
{
	try {
		std::string outputStr = "This is the string to output.";
		std::ofstream fout;

		fout.open("output.txt");

		for (int i = 0; i < outputStr.size(); ++i)
		{
			fout << outputStr[i];
		}

		fout.close();

		std::cout << "Completed.";
	}
	catch (const std::exception& ex)
	{
		std::cerr << "Error occurred: " << ex.what();
	}
}

void FileControl::question2()
{
	hClock clock;
	auto begin = clock.now();
	double multiply = 1.0;
	for (int i = 1; i < 150; ++i)
	{
		multiply *= i;
	}
	auto end = clock.now();
	double result = std::chrono::duration_cast<dSecond>(end - begin).count();
	std::cout << result;
}

void FileControl::question3()
{
}

void FileControl::question4()
{
}
