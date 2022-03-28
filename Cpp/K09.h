#pragma once
#include "IExecutable.h"
class K09 :
	public IExecutable
{
private:
	static void swap(int& a, int& b);
	static void sort(int* numbers, int total);
public:
	K09();
	~K09() override;
	void question1() override;
	void question2() override;
	void question3() override;
	void question4() override;
	static void question5();
	void execute(int num) override;
};

