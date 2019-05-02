#include "IExecutable.h"

IExecutable::IExecutable()
{
}


IExecutable::~IExecutable()
{
}

void IExecutable::execute(int num)
{
	switch (num)
	{
	case 1:
		question1();
		break;
	case 2:
		question2();
		break;
	case 3:
		question3();
		break;
	case 4:
		question4();
		break;
	default:
		break;
	}
}

void IExecutable::question1()
{
}

void IExecutable::question2()
{
}

void IExecutable::question3()
{
}

void IExecutable::question4()
{
}
