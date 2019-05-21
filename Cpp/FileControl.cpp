#include <chrono>
#include <fstream>
#include <iostream>
#include <stdexcept>
#include <sqlite3.h>
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

int callback(void* data, int argc, char** argv, char** colName)
{
	std::cout << reinterpret_cast<const char*>(data) << "\n";

	for (int i = 0; i < argc; ++i)
	{
		std::cout << colName[i] << " = " << (argv[i] ? argv[i] : "NULL") << "\n";
	}
	std::cout << "\n";

	return 0;
}

void FileControl::question3()
{

	sqlite3* db;
	int result = sqlite3_open("test.db", &db);

	if (result)
	{
		std::cerr << "Cannot open the database: " << sqlite3_errmsg(db) << "\n";
	}
	else
	{
		std::cerr << "Database successfully opened.\n";
	}

	auto sql = "CREATE TABLE Player(" \
		"Id INTEGER PRIMARY KEY AUTOINCREMENT," \
		"Name TEXT NOT NULL," \
		"Hp INT NOT NULL);";

	char* errMsg;

	result = sqlite3_exec(db, sql, callback, nullptr, &errMsg);

	if (result != SQLITE_OK)
	{
		std::cerr << "SQL Error: " << errMsg << "\n";
	}
	else
	{
		std::cout << "Table created succesfully.\n";
	}

	sqlite3_close(db);

}

void FileControl::question4()
{
	sqlite3* db;
	int result = sqlite3_open("test.db", &db);

	if (result)
	{
		std::cerr << "Cannot open the database: " << sqlite3_errmsg(db) << "\n";
	}
	else
	{
		std::cerr << "Database successfully opened.\n";
	}

	auto sql = "INSERT INTO Player (Name, Hp) VALUES ('Player1', 350);";
	char* errMsg;
	result = sqlite3_exec(db, sql, callback, nullptr, &errMsg);
	if (result != SQLITE_OK)
	{
		std::cerr << "SQL Error: " << errMsg << "\n";
	}
	else
	{
		std::cout << "Insertion succeeded.\n";
	}

	sql = "SELECT * FROM Player";
	const char* data = "Callback function called.\n";
	result = sqlite3_exec(db, sql, callback,
		reinterpret_cast<void*>(const_cast<char*>(data)), &errMsg);
	if (result != SQLITE_OK)
	{
		std::cerr << "SQL Error: " << errMsg << "\n";
	}
	else
	{
		std::cout << "Retrieval succeeded.\n";
	}

	sql = "UPDATE Player SET Hp = 800 WHERE Id = 8;";
	const char* data2 = "Callback function called.\n";
	result = sqlite3_exec(db, sql, callback,
		reinterpret_cast<void*>(const_cast<char*>(data2)), &errMsg);
	if (result != SQLITE_OK)
	{
		std::cerr << "SQL Error: " << errMsg << "\n";
	}
	else
	{
		std::cout << "Update succeeded.\n";
	}

	sqlite3_close(db);


}
