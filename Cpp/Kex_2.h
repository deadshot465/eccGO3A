#pragma once
#include "IExecutable.h"
#include <random>
#include <string>
#include "Kex.h"

#define GOBLIN_HIT (85)
#define GOBLIN_FLEE (40)
#define SLIME_HIT (95)
#define SLIME_FLEE (30)
#define MAX_GOLEM_LEVEL (5)
#define MAX_GOBLIN_LEVEL (7)
#define MAX_SLIME_LEVEL (9)

enum class EnemyType
{
	GOLEM = 0,
	GOBLIN = 1,
	SLIME = 2
};

struct Attack
{
	int Hit;
	int Damage;
};

struct Enemy {
	int Lv;
	int Hp;
	int Defense;
	int Attack;
	int Hit;
	int Flee;
	EnemyType Type;
	std::string Name;
};

class Kex_2
{
public:
	template <typename T = std::mt19937, std::size_t N = T::state_size>
	static typename std::enable_if<!!N, T>::type GetEngine();

	void Execute();
};

template<typename T, std::size_t N>
inline typename std::enable_if<!!N, T>::type Kex_2::GetEngine()
{
	typename T::result_type randomData[N];
	std::random_device rd;
	std::generate(std::begin(randomData), std::end(randomData), std::ref(rd));
	std::seed_seq seq(std::begin(randomData), std::end(randomData));
	T engine(seq);
	return engine;
}
