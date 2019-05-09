#pragma once

struct Golem
{
	int hp;
	int defense;
	int attack;

	Golem(int hp = 300, int defense = 80, int attack = 50) :
		hp{ hp }, defense{ defense }, attack{ attack }
	{
	}
};