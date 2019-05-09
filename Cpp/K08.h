#pragma once
#include "IExecutable.h"

class K08 : public IExecutable {
public:
	K08();
	~K08();

	// IExecutable ‚ğ‰î‚µ‚ÄŒp³‚³‚ê‚Ü‚µ‚½
	virtual void question1() override;
	virtual void question2() override;
	virtual void question3() override;
	virtual void question4() override;
};