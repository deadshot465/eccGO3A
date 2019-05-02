#pragma once
#include "IExecutable.h"
class K06 :
	public IExecutable
{
public:
	K06();
	~K06();

	virtual void question1() override;
	virtual void question2() override;
	virtual void question3() override;
	virtual void question4() override;
};

