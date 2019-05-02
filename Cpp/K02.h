#pragma once
#include "IExecutable.h"

class K02 :
	public IExecutable
{
public:
	K02();
	~K02();

	virtual void question1() override;
	virtual void question2() override;
	virtual void question3() override;
	virtual void question4() override;
};

