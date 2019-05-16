#pragma once

class IDispatchable
{
public:
	IDispatchable();
	virtual ~IDispatchable();

	virtual void question1() = 0;
	virtual void question2() = 0;
	virtual void question3() = 0;
	virtual void question4() = 0;
};

