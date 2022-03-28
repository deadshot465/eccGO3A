#include "Kex_2_Enemy.h"
#include <random>

Enemy Kex_2_Enemy::CreateEnemy(EnemyType type)
{
	Enemy enemy = {};
	enemy.Type = type;
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, MAX_GOLEM_LEVEL - 1);

	switch (type)
	{
	case EnemyType::GOLEM:
		enemy.Lv = generator(engine);
		enemy.Hp = enemy.Lv * 50 + 100;
		enemy.Defense = enemy.Lv * 10 + 40;
		enemy.Attack = GOLEM_ATTACK(enemy.Lv);
		enemy.Hit = GOLEM_HIT;
		enemy.Flee = GOLEM_FLEE;
		enemy.Name = "ゴーレム";
		break;
	case EnemyType::GOBLIN:
	{
		auto param = std::uniform_int_distribution<int>::param_type(0, MAX_GOBLIN_LEVEL - 1);
		generator.param(param);
		enemy.Lv = generator(engine);
		enemy.Hp = enemy.Lv * 30 + 75;
		enemy.Defense = enemy.Lv * 5 + 20;
		enemy.Attack = enemy.Lv * 5 + 20;
		enemy.Hit = GOBLIN_HIT;
		enemy.Flee = GOBLIN_FLEE;
		enemy.Name = "ゴブリン";
		break;
	}
	case EnemyType::SLIME:
	{
		auto param = std::uniform_int_distribution<int>::param_type(0, MAX_SLIME_LEVEL - 1);
		generator.param(param);
		enemy.Lv = generator(engine);
		enemy.Hp = enemy.Lv * 10 + 50;
		enemy.Defense = enemy.Lv * 2 + 10;
		enemy.Attack = enemy.Lv * 2 + 10;
		enemy.Hit = SLIME_HIT;
		enemy.Flee = SLIME_FLEE;
		enemy.Name = "スライム";
		break;
	}
	default:
		break;
	}

	return enemy;
}
