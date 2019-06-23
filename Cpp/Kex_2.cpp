#include "Kex_2.h"
#include <iostream>
#include "Kex_2_Battle.h"
#include "Kex_2_Enemy.h"

using std::cout;

void Kex_2::Execute()
{
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, 2);
	cout << "冒険が今始まる！\n";
	PlayerEx player;
	player.Hp = PLAYER_INITIAL_HP;
	player.Defense = PLAYER_DEFENSE;
	int continue_game = 1;
	int kills = 0;

	do
	{
		cout << "\n現HP：" << player.Hp << "\n";
		cout << "奥に進みますか？（１：奥に進む　０．帰る）＞";
		std::cin >> continue_game;
		if (continue_game == 1)
		{
			int lv = generator(engine);
			Enemy enemy = Kex_2_Enemy::CreateEnemy(static_cast<EnemyType>(lv));
			bool result = Kex_2_Battle::AttackEnemy(player, enemy);
			++kills;
			if (!result)
			{
				break;
			}
		}

	} while (continue_game);

	cout << "リ〇ミト！\n\n";
	cout << "戦闘回数：" << kills << "回　残りHP：" << player.Hp << "\n";
}
