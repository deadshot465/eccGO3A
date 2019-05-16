#pragma once
#include "IExecutable.h"
class K10 :
	public IExecutable
{
public:
	K10();
	~K10();
	void question1() override;
	void question2() override;
	void question3() override;
	void question4() override;
};

