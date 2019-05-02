#pragma once
#include "IExecutable.h"
class K04 :
	public IExecutable
{
public:
	K04();
	~K04();

	virtual void question1() override;
	virtual void question2() override;
	virtual void question3() override;
	virtual void question4() override;
};

