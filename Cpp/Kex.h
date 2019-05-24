#pragma once

#define PLAYER_INITIAL_HP 500
#define PLAYER_DEFENSE 30
#define ATTACK_HIT 110
#define SKILL_HIT 100
#define MAGIC_HIT 70
#define GOLEM_ATTACK(lv) ((lv) * (10) + (40))
#define GOLEM_HIT 75
#define GOLEM_FLEE 20

struct GolemEx
{
	int Hp;
	int Defense;
	int Attack;
	int Hit = GOLEM_HIT;
	int Flee = GOLEM_FLEE;
};

struct PlayerEx
{
	int Hp = PLAYER_INITIAL_HP;
	int Defense = PLAYER_DEFENSE;
};

class Kex
{
public:
	void Execute();
};

