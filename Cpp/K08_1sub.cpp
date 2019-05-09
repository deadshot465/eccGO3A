#include "K08_1sub.h"



K08_1sub::K08_1sub()
{
}


K08_1sub::~K08_1sub()
{
}

int K08_1sub::GetMaxValue(int v1, int v2, int v3)
{
	int temp = v1 >= v2 ? v1 : v2;
	temp = temp >= v3 ? temp : v3;
	return temp;
}

int K08_1sub::GetMinValue(int v1, int v2, int v3)
{
	int temp = v1 < v2 ? v1 : v2;
	temp = temp < v3 ? temp : v3;
	return temp;
}
