#pragma once
#include "IExecutable.h"
class K03 :
	public IExecutable
{
public:
	K03();
	~K03();

	virtual void question1() override;
	virtual void question2() override;
	virtual void question3() override;
	virtual void question4() override;
};

