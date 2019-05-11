#include <fstream>
#include <iostream>
#include <stdexcept>
#include <string>

#include "FileControl.h"

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
}

void FileControl::question3()
{
}

void FileControl::question4()
{
}
