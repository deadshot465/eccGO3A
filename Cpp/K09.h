#pragma once
#include "IExecutable.h"
class K09 :
	public IExecutable
{
private:
	void swap(int& a, int& b);
	void sort(int* numbers, int total);
public:
	K09();
	~K09();
	void question1() override;
	void question2() override;
	void question3() override;
	void question4() override;
	void question5();
	void execute(int num) override;
};

