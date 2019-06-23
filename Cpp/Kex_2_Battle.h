#pragma once
#include "Kex.h"
#include "Kex_2.h"

class Kex_2_Battle
{
private:
	static bool CheckHitOrMiss(int hit);
	static int GetAttackPower();
	static int GetSkillPower();
	static int GetMagicPower();

public:
	static bool AttackEnemy(PlayerEx& player, Enemy& enemy);
};

